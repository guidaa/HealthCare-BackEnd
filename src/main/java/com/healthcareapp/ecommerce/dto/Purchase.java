package com.healthcareapp.ecommerce.dto;

import com.healthcareapp.ecommerce.entity.Address;
import com.healthcareapp.ecommerce.entity.Customer;
import com.healthcareapp.ecommerce.entity.Order;
import com.healthcareapp.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
