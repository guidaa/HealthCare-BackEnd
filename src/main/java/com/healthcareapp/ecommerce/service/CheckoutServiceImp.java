package com.healthcareapp.ecommerce.service;

import com.healthcareapp.ecommerce.dao.CustomerRepository;
import com.healthcareapp.ecommerce.dto.Purchase;
import com.healthcareapp.ecommerce.dto.PurchaseResponse;
import com.healthcareapp.ecommerce.entity.Customer;
import com.healthcareapp.ecommerce.entity.Order;
import com.healthcareapp.ecommerce.entity.OrderItem;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImp implements CheckoutService{

    private CustomerRepository customerRepository;

    // one construction dont need: @Autowired
    public CheckoutServiceImp(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        // retrieve the order info from dto
        Order order = purchase.getOrder();

        // generate tracking number
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        //populate order with billingAddrss and shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        //populate customer with order
        Customer customer = purchase.getCustomer();

        // check if this is an existing customer
        String theEmail = customer.getEmail();
        Customer customerFromDB = customerRepository.findByEmail(theEmail);

        if (customerFromDB != null) {
            // we found them .... lets assign them accordingly
            customer = customerFromDB;
        }
        customer.add(order);


        //save to the database
        customerRepository.save(customer);
        // return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a random UUID number (UUID version -4)
        return UUID.randomUUID().toString();
    }

}
