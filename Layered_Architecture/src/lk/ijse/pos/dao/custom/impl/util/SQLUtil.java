package lk.ijse.pos.dao.custom.impl.util;

import lk.ijse.pos.db.DBConnection;

import java.sql.*;

public class SQLUtil {
    public static <T>T execute(String sql,Object... args) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1),args[i]);
        }
        if (sql.startsWith("SELECT") || sql.startsWith("select")){
            return (T) pstm.executeQuery();
        }else{
            return (T)  new Boolean(pstm.executeUpdate()>0);
        }
    }
}
