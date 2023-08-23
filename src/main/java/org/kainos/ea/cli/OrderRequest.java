package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class OrderRequest {
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    private int customerId;

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    private Date orderDate;
    @JsonCreator

    public OrderRequest(@JsonProperty("customerId") int customerId,
                        @JsonProperty("orderDate") Date orderDate)
    {
        this.customerId = customerId;
        this.orderDate = orderDate;
    }
}
