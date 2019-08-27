package by.gsu.epamlab.db;

import by.gsu.epamlab.beans.mark.Mark;
import by.gsu.epamlab.beans.result.Result;
import by.gsu.epamlab.constants.Constant;

import java.sql.*;
import java.util.List;

public class ResultsSelect {
    public static void selectAvgMark() {
        try (Statement st = DBConnection.getNewConnection().createStatement()){
            String name;
            Mark mark = null;
            ResultSet rs = st.executeQuery(Constant.SELECT_AVG_MARKS);
            while (rs.next()) {
                name = rs.getString("name");
                mark = new Mark((int) (rs.getDouble("avgMark")));
                System.out.println(name + "; " + mark);
            }
        } catch (SQLException e1) {
            System.err.println("Driver BD not founds \t=>\t\n" + e1.getMessage());
            try {
                DBConnection.getNewConnection().rollback();
            } catch (SQLException e) {
                System.err.println("Rollback exception \t=>\t\n" + e1.getMessage());
            }
        }
    }


    public static void selectMonthNow(List<Result> linkResult) {
        try (Statement st = DBConnection.getNewConnection().createStatement()) {
            String student;
            String test;
            Date date;
            Mark mark;
            ResultSet rs = st.executeQuery(Constant.SELECT_MONTH_NOW);
            while (rs.next()) {
                student = rs.getString("student");
                test = rs.getString("test");
                date = rs.getDate("dat");
                mark = new Mark((int) (rs.getDouble("mark")));
                linkResult.add(new Result(student, test, date, mark));
            }
        } catch (SQLException e1) {
            System.err.println("Driver BD not founds \t=>\t\n" + e1.getMessage());
        }
    }
}
