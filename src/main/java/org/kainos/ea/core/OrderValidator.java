package org.kainos.ea.core;

import org.joda.time.DateTime;
import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.db.CustomerDao;

import java.sql.SQLException;
import java.time.Year;
import java.util.Date;

public class OrderValidator {
    private CustomerDao customerDao = new CustomerDao();
    public String isOrderValid(OrderRequest orderRequest) throws SQLException {
        if(!orderRequest.getOrderDate().after(DateTime.now().minusYears(1).toDate())){
            return "Order date is older than 1 year";
        }
        if(!customerDao.doesCustomerExist(orderRequest.getCustomerId()))
        {
            return "Customer doesn't exists in database";
        }
        return null;
    }
}
