package org.example.PaymentStrategyPackage.ConcretePaymentStrategies;

import org.example.PaymentStrategyPackage.PaymentStrategy;

public class CashPayment implements PaymentStrategy {
    public CashPayment(double fee) {
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing payment by the card for amount : "  + amount);
    }
}
