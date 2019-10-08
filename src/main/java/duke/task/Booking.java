package duke.task;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking extends Task{
    protected String customerName;
    protected String customerContact;
    protected String numberOfPax;
    protected String bookingDate;
    protected Date date;
    protected SimpleDateFormat dateFormatter;
    protected String orderName;

    public Booking(String customerName, String customerContact, String numberOfPax, String bookingDate, String orderName) throws ParseException {
        //super(description);
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.numberOfPax = numberOfPax;
        this.bookingDate = bookingDate;
        date = new SimpleDateFormat("dd/MM/yyyy").parse(bookingDate);
        dateFormatter = new SimpleDateFormat("d MMMM yyyy");
        this.orderName = orderName;

    }

    @Override
    public String toSaveString() {
        return "booking" + " | " + customerName + " | " + customerContact + " | " + numberOfPax + " | " + bookingDate + " | " +  orderName;
    }

    @Override
    public String toString() {
        return "[Customer name: " + customerName + "] " + "[Contact No.: " + customerContact + "] "
                + "[No. of pax: " + numberOfPax+ "] " + "[Booking on: " + dateFormatter.format(date) + "] "
                + "[Orders: " + orderName + "]";
    }

    @Override
    public Date getDateTime() {
        return date;
    }
}
