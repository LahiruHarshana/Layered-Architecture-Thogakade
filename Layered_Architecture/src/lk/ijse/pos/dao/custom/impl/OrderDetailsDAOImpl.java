package lk.ijse.pos.dao.custom.impl;

import lk.ijse.pos.dao.custom.OrderDetailsDAO;
import lk.ijse.pos.dao.custom.impl.util.SQLUtil;
import lk.ijse.pos.entity.OrderDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDetailsDAOImpl implements OrderDetailsDAO {
    @Override
    public ArrayList<OrderDetails> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT * FROM OrderDetails");
        ArrayList<OrderDetails> allItems = new ArrayList<>();
        while (rst.next()) {
            allItems.add(new OrderDetails(rst.getString(1), rst.getString(2), rst.getInt(3),rst.getBigDecimal(4)));
        }
        return allItems;
    }

    @Override
    public boolean save(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)", entity.getOid(), entity.getItemCode(), entity.getUnitPrice(), entity.getQty());
    }

    @Override
    public boolean update(OrderDetails entity) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("UPDATE OrderDetails SET itemCode=?, qty=?,unitPrice=? WHERE oid=?", entity.getItemCode(), entity.getQty(), entity.getUnitPrice(),entity.getOid());
    }

    @Override
    public boolean exist(String oid) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.execute("SELECT oid FROM OrderDetails WHERE oid=?", oid);
        return rst.next();
    }

    @Override
    public boolean delete(String oid) throws SQLException, ClassNotFoundException {
        return SQLUtil.execute("DELETE FROM OrderDetails WHERE oid=?", oid);
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

    @Override
    public OrderDetails search(String s) throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("This feature yet to be developed");
    }

}
