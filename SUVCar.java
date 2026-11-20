// An SUV is another type of Car (inheritance).
public class SUVCar extends Car {
    private int extraSeats; // SUV's extra attribute: additional passenger seats

    // Reuses the base-class constructor through super(...).
    public SUVCar(String brand, String model, String color, int year,
                  int fuelLevel, int speed, boolean engineOn, int extraSeats) {
        super(brand, model, color, year, fuelLevel, speed, engineOn);
        setExtraSeats(extraSeats);
    }

    // Getter and setter keep the new attribute private.
    public int getExtraSeats() { return extraSeats; }
    public void setExtraSeats(int extraSeats) {
        if (extraSeats >= 0) this.extraSeats = extraSeats;
    }

    // Overrides the SAME fare method: SUV costs RM5 + RM3 per km.
    @Override
    public double calculateFare(int distanceKm) {
        if (distanceKm <= 0) return 0;
        return 5.0 + distanceKm * 3.0;
    }

    // Overrides display method to show the SUV's special information.
    @Override
    public void showCar() {
        System.out.println("SUV car:");
        super.showCar();
        System.out.println("Extra seats: " + extraSeats);
    }
}
