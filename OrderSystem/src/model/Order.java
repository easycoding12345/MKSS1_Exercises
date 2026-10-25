package model;

import java.time.LocalDateTime;

public class Order {
    private int lumpSumInCents = 0;
    private LocalDateTime checkoutTime;

    public LocalDateTime getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(LocalDateTime checkoutTime) {
        this.checkoutTime = checkoutTime;
    }
   //lumpSum is a constand price for the end price
    public int getLumpSumInCents() {
        return lumpSumInCents;
    }

    public void setLumpSumInCents(int lumpSumInCents) {
        this.lumpSumInCents = lumpSumInCents;
    }
}
