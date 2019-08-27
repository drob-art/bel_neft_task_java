package by.gsu.epamlab.db;

import by.gsu.epamlab.constants.Constant;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultsClear {
    public static void clearResults() {
        try {
            Connection cn = DBConnection.getNewConnection();
            Statement st = cn.createStatement();
            st.executeUpdate(Constant.DEL_TABLE_LOGINS);
            st.executeUpdate(Constant.DEL_TABLE_TESTS);
            st.executeUpdate(Constant.DEL_TABLE_RESULTS);
        } catch (SQLException e) {
            System.err.println("Clean table exception \t=>\t\n" + e.getMessage());
        }
    }
}
