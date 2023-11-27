package bms.service;

import bms.dao.Database;
import bms.models.Booking;
import bms.models.Transaction;

public class PaymentService {
    private final Database db = Database.init();
    private static Boolean isCreated = false;
    private static PaymentService obj;

    public void makePayment(Booking booking){
        Transaction t1 = Transaction.create("sda", booking);
        db.transactions.add(t1);
    }

    private PaymentService() {
    }

    synchronized public static PaymentService create() {
        if(isCreated)
            return obj;

        obj = new PaymentService();
        isCreated = true;
        return obj;
    }
}
