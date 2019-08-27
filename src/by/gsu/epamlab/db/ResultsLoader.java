package by.gsu.epamlab.db;

import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.constants.Constant;
import by.gsu.epamlab.dao.IResultDAO;

import java.sql.*;
import java.text.ParseException;

import static by.gsu.epamlab.constants.Constant.*;

public class ResultsLoader {
    public static void loadResults(IResultDAO reader) {
        try {
            Connection cn = DBConnection.getNewConnection();
            String login = null;
            String test = null;

            while (reader.hasResult()) {
                Result result = null;
                try {
                    result = reader.nextResult();
                    login = result.getLogin();
                    test = result.getTest();
                } catch (ParseException e) {
                    System.err.println("Error read line result " + e.getMessage());
                }

                int idLogin = getId(cn, login, PS_SELECT_LOGIN, PS_INSERT_LOGIN);
                int idTest = getId(cn, test, PS_SELECT_TEST, PS_INSERT_TEST);
                insertTableResults(cn, result, idLogin, idTest);
            }
            reader.closeReader();
        } catch (SQLException e) {
            System.err.println("Driver BD not founds \t=>\t\n" + e.getMessage());
        }
    }

    private static int getId(Connection cn, String value, String psSelect, String psInsert) {
        int id = 0;
        try (Statement st = cn.createStatement()) {
            ResultSet rs = st.executeQuery(psSelect + "'" + value + "'");
            while (rs.next()) {
                id = rs.getInt("id");
            }
            if (id == 0) {
                PreparedStatement pst = cn.prepareStatement(psInsert);
                cn.setAutoCommit(false);
                pst.setNString(1, value);
                pst.executeUpdate();
                cn.commit();
                pst.close();
                rs = st.executeQuery(psSelect + "'" + value + "'");
                while (rs.next()) {
                    id = rs.getInt("id");
                }
            }
            rs.close();
        } catch (SQLException e1) {
            System.err.println("Driver BD not founds \t=>\t\n" + e1.getMessage());
        }
        return id;
    }


    public static void insertTableResults(Connection cn, Result result, int idLogin, int idTest) {
        try{
            if ((idLogin != 0) && (idTest != 0)) {
                PreparedStatement pst = cn.prepareStatement(Constant.INSERT_RESULT);
                cn.setAutoCommit(false);
                pst.setInt(Constant.IDLOGEN_INDEX, idLogin);
                pst.setInt(Constant.IDTEST_INDEX, idTest);
                java.sql.Date sqlDate = new java.sql.Date(result.getDate().getTime());
                pst.setDate(Constant.DATE_INDEX, sqlDate);
                pst.setInt(Constant.MARK_INDEX, result.getMark());
                pst.executeUpdate();
                cn.commit();
                pst.close();
            }
        } catch (SQLException e1) {
            System.err.println("Driver BD not founds \t=>\t\n" + e1.getMessage());
        }
    }

}

