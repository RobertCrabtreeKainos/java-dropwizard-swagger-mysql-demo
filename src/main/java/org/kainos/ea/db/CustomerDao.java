package org.kainos.ea.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {
    private DatabaseConnector databaseConnector = new DatabaseConnector();
    public boolean doesCustomerExist(int customerId) throws SQLException
    {
        Connection c = DatabaseConnector.getConnection();

        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT CustomerId FROM `Customer`;");

        while (rs.next()){
            if(rs.getInt("CustomerId") == customerId)
            {
                return true;
            }
        }
        return false;
    }
}
