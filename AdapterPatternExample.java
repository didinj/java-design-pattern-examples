interface PaymentProcessor {
    void pay(double amount);
}

class PayPal {
    public void makePayment(double amountInUsd) {
        System.out.println("Paid $" + amountInUsd + " using PayPal");
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void pay(double amount) {
        payPal.makePayment(amount);
    }

    public static void main(String[] args) {
        PaymentProcessor processor = new PayPalAdapter(new PayPal());
        processor.pay(100.0);
    }
}