import java.util.Locale;

public class CinemaTicketBooking {
    final String customerName;
    final String movieName;
    final double ticketPrice;
    int numberOfTickets;
    boolean bookingSuccessful;

    public CinemaTicketBooking(String customerName, String movieName, double ticketPrice) {
        this.customerName = customerName;
        this.movieName = movieName;
        this.ticketPrice = ticketPrice;
    }

    public CinemaTicketBooking(String customerName, String movieName) {
        this(customerName, movieName, 0.0);
    }

    public boolean bookTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
        this.bookingSuccessful = numberOfTickets > 0;
        return bookingSuccessful;
    }

    public boolean bookTickets(String customerName, int numberOfTickets) {
        if (!this.customerName.equalsIgnoreCase(customerName)) {
            bookingSuccessful = false;
            return false;
        }
        return bookTickets(numberOfTickets);
    }

    public void displayBookingSummary() {
        double totalAmount = bookingSuccessful ? ticketPrice * numberOfTickets : 0.0;
        double discount = bookingSuccessful && numberOfTickets >= 5 ? totalAmount * 0.10 : 0.0;
        double finalAmount = totalAmount - discount;

        System.out.println("Customer Name   : " + customerName.toUpperCase(Locale.ROOT));
        System.out.println("Movie Name      : " + movieName.toUpperCase(Locale.ROOT));
        System.out.printf(Locale.US, "Ticket Price    : Rs. %.2f%n", ticketPrice);
        System.out.println("Number of Tickets: " + numberOfTickets);
        System.out.println("Booking Status  : "
                + (bookingSuccessful ? "Booking Successful" : "Booking Failed"));
        System.out.printf(Locale.US, "Total Amount    : Rs. %.2f%n", totalAmount);
        System.out.printf(Locale.US, "Discount        : Rs. %.2f%n", discount);
        System.out.printf(Locale.US, "Final Amount    : Rs. %.2f%n", finalAmount);
    }

    public void displayBasicDetails() {
        System.out.println("Customer Name   : " + customerName.toUpperCase(Locale.ROOT));
        System.out.println("Movie Name      : " + movieName.toUpperCase(Locale.ROOT));
        System.out.println("Number of Tickets: " + numberOfTickets);
    }

    public static void main(String[] args) {
        CinemaTicketBooking snehaBooking =
                new CinemaTicketBooking("Sneha", "Avatar", 200.00);
        snehaBooking.bookTickets("Sneha", 5);

        CinemaTicketBooking arjunBooking =
                new CinemaTicketBooking("Arjun", "Avatar");
        arjunBooking.bookTickets(2);

        System.out.println("========== CINEMA TICKET BOOKING ==========\n");
        snehaBooking.displayBookingSummary();
        System.out.println();
        arjunBooking.displayBasicDetails();
    }
}
