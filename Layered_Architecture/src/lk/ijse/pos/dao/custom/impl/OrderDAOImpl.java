package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDAO;
import lk.ijse.pos.dao.custom.impl.util.SQLUtil;
import lk.ijse.pos.entity.Orders;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM `Orders`");
        ArrayList<Orders> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new Orders(rst.getString(1), rst.getDate(2).toLocalDate(), rst.getString(3)));
        }
        return allItems;
    }

    @Override
    public boolean save(Orders entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)", entity.getOid(), Date.valueOf(entity.getDate()), entity.getCustomerID());
    }

    @Override
    public boolean update(Orders entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE `Orders` SET date=?, customerID=? WHERE oid=?", entity.getDate(), entity.getCustomerID(), entity.getOid());
    }

    @Override
    public boolean exist(String orderID) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?", orderID);
        return rst.next();
    }

    @Override
    public boolean delete(String oid) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM `Orders` WHERE oid=?", oid);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");
        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }

    @Override
    public Orders search(String oid) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM `Orders` WHERE oid=?", oid);
        if (rst.next()) {
            return new Orders(rst.getString(1), rst.getDate(2).toLocalDate(), rst.getString(3));
        }
        return null;
    }


}
