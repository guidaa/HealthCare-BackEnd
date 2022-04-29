package com.healthcareapp.ecommerce.service;

import com.healthcareapp.ecommerce.dto.Purchase;
import com.healthcareapp.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
