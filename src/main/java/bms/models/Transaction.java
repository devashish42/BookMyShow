package bms.models;

/**
 * Class for storing Payment information.
 * It is used as a ledger in this system.
 */
public class Transaction {
    public Integer id;
    public String paymentInfo;
    public Booking booking;

    private Transaction(String paymentInfo, Booking booking){
        this.id = SequenceGenerator.getNextId();
        this.paymentInfo = paymentInfo;
        this.booking = booking;
    }

    public static Transaction create(String paymentInfo, Booking booking){
        return new Transaction(paymentInfo, booking);
    }

    private static class SequenceGenerator {
        private static Integer seq = 0;
        public static Integer getNextId() {
            return ++seq;
        }
    }
}
