// Extra class connecting Passenger, Driver and Car for one ride.
public class RideBooking {
    private int bookingId;        // Unique number identifying this booking
    private String pickup;        // Where the ride begins
    private String destination;   // Where the ride ends
    private int distanceKm;       // Travel distance in kilometres
    private double fare;          // Price calculated for this ride (RM)
    private boolean confirmed;    // True after payment is accepted
    private boolean completed;    // True after the ride is finished

    // Constructor stores the booking details before the fare is calculated.
    public RideBooking(int bookingId, String pickup, String destination,
                       int distanceKm) {
        this.bookingId = bookingId;
        this.pickup = pickup;
        this.destination = destination;
        setDistanceKm(distanceKm);
        fare = 0.0;
        confirmed = false;
        completed = false;
    }

    // Getters allow the main class to read the private booking information.
    public int getBookingId() { return bookingId; }
    public String getPickup() { return pickup; }
    public String getDestination() { return destination; }
    public int getDistanceKm() { return distanceKm; }
    public double getFare() { return fare; }
    public boolean getConfirmed() { return confirmed; }
    public boolean getCompleted() { return completed; }

    // Setters validate price and distance before changing these values.
    public void setDistanceKm(int distanceKm) {
        if (distanceKm > 0) this.distanceKm = distanceKm;
    }
    public void setFare(double fare) {
        if (fare > 0) this.fare = fare;
    }

    // Uses objects of THREE other classes to accept or reject a booking.
    public boolean confirmRide(Passenger passenger, Driver driver, Car car) {
        // if/else: check driver, car and passenger before confirming.
        if (!confirmed && !completed && distanceKm > 0 && fare > 0 &&
                driver.canDrive() && car.getFuelLevel() >= 20) {
            if (passenger.bookRide(fare)) {
                confirmed = true;
                System.out.println("Booking #" + bookingId + " confirmed.");
                return true;
            }
        }
        System.out.println("Booking #" + bookingId + " could not be confirmed.");
        return false;
    }

    // Updates the driver, passenger and booking after the ride ends.
    public void finishRide(Passenger passenger, Driver driver) {
        if (confirmed && !completed) {
            passenger.finishRide();
            driver.completeTrip();
            completed = true;
            confirmed = false;
            System.out.println("Booking #" + bookingId + " completed.");
        }
    }

    // Prints the booking summary using the private attributes.
    public void showBooking() {
        System.out.println("Booking #" + bookingId + ": " + pickup + " to " + destination);
        System.out.println("Distance: " + distanceKm + " km, Fare: RM" + fare);
        System.out.println("Confirmed: " + confirmed + ", Completed: " + completed);
    }
}
