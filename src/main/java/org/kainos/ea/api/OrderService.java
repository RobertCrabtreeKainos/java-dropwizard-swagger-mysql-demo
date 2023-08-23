package org.kainos.ea.api;

import io.swagger.models.auth.In;
import org.kainos.ea.cli.Order;
import org.kainos.ea.cli.OrderRequest;
import org.kainos.ea.cli.Product;
import org.kainos.ea.client.*;
import org.kainos.ea.core.OrderValidator;
import org.kainos.ea.core.ProductValidator;
import org.kainos.ea.db.OrderDao;

import java.sql.SQLException;
import java.util.List;

public class OrderService {
    private OrderValidator orderValidator = new OrderValidator();
    private OrderDao orderDao = new OrderDao();

    public List<Order> getAllOrders() throws FailedToGetOrdersException {
        List<Order> orderList = null;
        try {
            orderList = orderDao.getAllOrders();
        } catch (SQLException e) {
            throw new FailedToGetOrdersException();
        }
        return orderList;
    }

    public Order getOrderById(int id) throws FailedToGetOrdersException, OrderDoesNotExistException {
        try {
            Order order = orderDao.getOrderById(id);

            if (order == null) {
                throw new OrderDoesNotExistException();
            }
            return order;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new OrderDoesNotExistException();
        }
    }

    public int createOrder(OrderRequest order) throws InvalidOrderException, FailedToCreateOrderException {
        try {
            String validation = orderValidator.isOrderValid(order);
            if (validation != null) {
                throw new InvalidOrderException(validation);
            }
            int id = orderDao.createOrder(order);
            if(id == -1)
            {
                throw new FailedToCreateOrderException();
            }
            return id;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateOrderException();
        }
    }

    public void updateOrder(int id, OrderRequest order) throws InvalidOrderException, OrderDoesNotExistException, FailedToUpdateOrderException {
        try{
            String validation = orderValidator.isOrderValid(order);

            if(validation != null)
            {
                throw new InvalidOrderException(validation);
            }
            Order orderToUpdate = orderDao.getOrderById(id);

            if(orderToUpdate == null)
            {
                throw new OrderDoesNotExistException();
            }
            orderDao.updateProduct(id, order);
        } catch (SQLException e) {
            throw new FailedToUpdateOrderException();
        }
    }

    public void deleteOrder(int id) throws FailedToDeleteOrderException, OrderDoesNotExistException{
        try{
            Order orderToDelete = orderDao.getOrderById(id);
            if(orderToDelete == null)
            {
                throw  new OrderDoesNotExistException();
            }
            orderDao.deleteOrder(id);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw  new FailedToDeleteOrderException();
        }
    }
}