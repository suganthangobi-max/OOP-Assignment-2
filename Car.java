// Base class from Assignment 1, shared by different types of cars.
// "implements RideFare" gives all cars the same fare-calculation method name.
public class Car implements RideFare {
    // All 7 attributes are private to protect the object's data.
    private String brand;     // Car manufacturer
    private String model;     // Model name
    private String color;     // Car colour
    private int year;         // Manufacturing year
    private int fuelLevel;    // Fuel units remaining (0 to 100)
    private int speed;        // Current speed in km/h
    private boolean engineOn; // Whether the engine is running

    // Default constructor: used when no values are supplied.
    public Car() {
        brand = "Unknown";
        model = "Unknown";
        color = "White";
        year = 2020;
        fuelLevel = 30;
        speed = 0;
        engineOn = false;
    }

    // Parameterized constructor: initializes all 7 car attributes.
    public Car(String brand, String model, String color, int year,
               int fuelLevel, int speed, boolean engineOn) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        setYear(year);
        setFuelLevel(fuelLevel);
        setSpeed(speed);
        setEngineOn(engineOn);
    }

    // Getter methods: provide read-only access to each private attribute.
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getColor() { return color; }
    public int getYear() { return year; }
    public int getFuelLevel() { return fuelLevel; }
    public int getSpeed() { return speed; }
    public boolean getEngineOn() { return engineOn; }

    // Setter methods: control how each private attribute can change.
    public void setBrand(String brand) { this.brand = brand; }
    public void setModel(String model) { this.model = model; }
    public void setColor(String color) { this.color = color; }
    public void setYear(int year) {
        if (year > 0) this.year = year;
    }
    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel >= 0 && fuelLevel <= 100) {
            this.fuelLevel = fuelLevel;
            if (fuelLevel == 0) engineOn = false;
        }
    }
    public void setSpeed(int speed) {
        if (speed >= 0) this.speed = speed;
    }
    public void setEngineOn(boolean engineOn) {
        // An engine cannot be turned on with an empty fuel tank.
        if (engineOn && fuelLevel == 0) {
            this.engineOn = false;
        } else {
            this.engineOn = engineOn;
        }
    }

    // Base fare rule. The child classes override this with their own prices.
    @Override
    public double calculateFare(int distanceKm) {
        if (distanceKm <= 0) return 0;
        return distanceKm * 2.0;
    }

    // Starts the engine only if the car still has fuel.
    public void startEngine() {
        if (fuelLevel > 0) {
            engineOn = true;
            System.out.println("Engine started.");
        } else {
            System.out.println("Cannot start: no fuel.");
        }
    }

    // Simulates one part of the journey: adds speed and uses 10 fuel units.
    public void drive() {
        if (engineOn && fuelLevel >= 10) {
            speed = speed + 20;
            fuelLevel = fuelLevel - 10;
            System.out.println("Driving at " + speed + " km/h. Fuel: " + fuelLevel);
        } else {
            System.out.println("Cannot drive. Check engine and fuel.");
        }
    }

    // Stops the car and resets its speed.
    public void stopEngine() {
        engineOn = false;
        speed = 0;
        System.out.println("Engine stopped.");
    }

    // Displays the car's main information using its stored attributes.
    public void showCar() {
        System.out.println(brand + " " + model + " (" + year + ") - " + color);
        System.out.println("Fuel: " + fuelLevel + ", Engine on: " + engineOn);
    }
}
