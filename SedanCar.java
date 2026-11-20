// A sedan is a type of Car (inheritance).
public class SedanCar extends Car {
    private int bootSize; // Sedan's extra attribute: luggage space in litres

    // Uses the base-class constructor through super(...).
    public SedanCar(String brand, String model, String color, int year,
                    int fuelLevel, int speed, boolean engineOn, int bootSize) {
        super(brand, model, color, year, fuelLevel, speed, engineOn);
        setBootSize(bootSize);
    }

    // Getter and setter keep the new attribute private.
    public int getBootSize() { return bootSize; }
    public void setBootSize(int bootSize) {
        if (bootSize >= 0) this.bootSize = bootSize;
    }

    // Overrides the common fare method: sedan costs RM3 + RM2 per km.
    @Override
    public double calculateFare(int distanceKm) {
        if (distanceKm <= 0) return 0;
        return 3.0 + distanceKm * 2.0;
    }

    // Overrides display method to show the sedan's special information.
    @Override
    public void showCar() {
        System.out.println("Sedan car:");
        super.showCar();
        System.out.println("Boot size: " + bootSize + " litres");
    }
}
