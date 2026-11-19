// Shared main class: demonstrates all objects, inheritance, polymorphism,
// interface use, getter/setter access, if/else and a for loop.
public class Main {
    public static void main(String[] args) {
        System.out.println("=== ASSIGNMENT 2: CAR RIDE BOOKING SYSTEM ===");

        // Create a base Car object and modify it using setters.
        Car normalCar = new Car();
        normalCar.setBrand("Perodua");
        normalCar.setModel("Myvi");
        System.out.println("\nBase class example:");
        normalCar.showCar();

        // Create two CHILD objects. Each child inherits the fields/methods of Car.
        SedanCar sedan = new SedanCar("Proton", "Saga", "Black", 2026, 50, 0, false, 450);
        SUVCar suv = new SUVCar("Honda", "CR-V", "White", 2025, 60, 0, false, 2);

        // Create the three extra classes (Driver, Passenger, RideBooking).
        Driver driver = new Driver("Ali", 22, "D200", "0120000000", "Shah Alam", 2, 0);
        Passenger passenger = new Passenger("Aina", 20, "0130000000",
                                             "MSU", "Shopping Mall", 50.0, false);
        RideBooking booking = new RideBooking(101, passenger.getPickup(),
                                               passenger.getDestination(), 6);

        // Interface references hold different car objects (polymorphism).
        // The SAME method call gives a different result for sedan and SUV.
        RideFare[] fareChoices = {sedan, suv};
        Car[] cars = {sedan, suv};
        System.out.println("\n=== CAR CHOICES AND FARES ===");
        // for loop: visit every car and print its special fare and attributes.
        for (int i = 0; i < fareChoices.length; i++) {
            cars[i].showCar();
            System.out.println("Fare for " + booking.getDistanceKm() + " km: RM"
                               + fareChoices[i].calculateFare(booking.getDistanceKm()));
            System.out.println();
        }

        // Choose the sedan through a parent-class reference (inheritance).
        Car selectedCar = sedan;
        // Use the interface reference to calculate the chosen fare.
        booking.setFare(fareChoices[0].calculateFare(booking.getDistanceKm()));
        System.out.println("=== BOOKING DEMONSTRATION ===");
        System.out.println(passenger.getName() + " chooses " + selectedCar.getModel());

        // if/else: check booking conditions before allowing the ride to start.
        if (booking.confirmRide(passenger, driver, selectedCar)) {
            selectedCar.startEngine();
            // for loop: simulate two parts of the journey.
            for (int i = 1; i <= 2; i++) {
                System.out.println("Drive " + i + ":");
                selectedCar.drive();
            }
            selectedCar.stopEngine();
            booking.finishRide(passenger, driver);
        } else {
            System.out.println("Ride cancelled because the checks failed.");
        }

        // Getter and setter demonstrate safe access to a private attribute.
        selectedCar.setColor("Silver");
        System.out.println("\nUpdated car colour: " + selectedCar.getColor());
        System.out.println("\n=== FINAL DETAILS ===");
        selectedCar.showCar();
        driver.showDriver();
        passenger.showPassenger();
        booking.showBooking();
    }
}
