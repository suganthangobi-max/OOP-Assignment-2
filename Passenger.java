// Member 3: Extra class for the person who books and pays for a ride.
public class Passenger {
    private String name;         // Passenger name
    private int age;             // Passenger age
    private String phone;        // Contact number
    private String pickup;       // Pickup location
    private String destination;  // Drop-off location
    private double walletBalance;// Money available to pay for the ride (RM)
    private boolean booked;      // Whether there is an active ride

    // Default constructor gives starting values.
    public Passenger() {
        name = "Unknown";
        age = 18;
        phone = "Not set";
        pickup = "Unknown";
        destination = "Unknown";
        walletBalance = 0.0;
        booked = false;
    }

    // Parameterized constructor initializes all passenger details.
    public Passenger(String name, int age, String phone, String pickup,
                     String destination, double walletBalance, boolean booked) {
        this.name = name;
        setAge(age);
        this.phone = phone;
        this.pickup = pickup;
        this.destination = destination;
        setWalletBalance(walletBalance);
        this.booked = booked;
    }

    // Getters safely return the 7 private attributes.
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }
    public String getPickup() { return pickup; }
    public String getDestination() { return destination; }
    public double getWalletBalance() { return walletBalance; }
    public boolean getBooked() { return booked; }

    // Setters update the attributes; negative balances are not allowed.
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }
    public void setPhone(String phone) { this.phone = phone; }
    public void setPickup(String pickup) { this.pickup = pickup; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setWalletBalance(double walletBalance) {
        if (walletBalance >= 0) this.walletBalance = walletBalance;
    }
    public void setBooked(boolean booked) { this.booked = booked; }

    // Books a ride only when it is new and the wallet can pay the fare.
    public boolean bookRide(double fare) {
        if (!booked && fare > 0 && walletBalance >= fare) {
            walletBalance = walletBalance - fare;
            booked = true;
            System.out.println(name + " paid RM" + fare + " and booked the ride.");
            return true;
        } else {
            System.out.println("Booking failed: check wallet or existing booking.");
            return false;
        }
    }

    // Marks the passenger's current ride as finished.
    public void finishRide() {
        if (booked) {
            booked = false;
            System.out.println(name + " reached " + destination + ".");
        }
    }

    // Displays the passenger's current booking and balance.
    public void showPassenger() {
        System.out.println("Passenger: " + name + " (" + pickup + " to " + destination + ")");
        System.out.println("Wallet balance: RM" + walletBalance + ", Booked: " + booked);
    }
}
