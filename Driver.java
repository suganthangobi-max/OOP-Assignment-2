//  Extra class for the person who drives the selected car.
public class Driver {
    // Private data protects the driver's details (encapsulation).
    private String name;           // Driver name
    private int age;               // Driver age
    private String licenseNumber;  // Driving licence identifier
    private String phone;          // Contact number
    private String city;           // Driver's city
    private int yearsExperience;   // Years of experience
    private int tripsCompleted;    // Total completed trips

    // Default constructor gives starting values.
    public Driver() {
        name = "Unknown";
        age = 18;
        licenseNumber = "None";
        phone = "Not set";
        city = "Unknown";
        yearsExperience = 0;
        tripsCompleted = 0;
    }

    // Parameterized constructor creates a driver with specific values.
    public Driver(String name, int age, String licenseNumber, String phone,
                  String city, int yearsExperience, int tripsCompleted) {
        this.name = name;
        setAge(age);
        this.licenseNumber = "None";
        setLicenseNumber(licenseNumber);
        this.phone = phone;
        this.city = city;
        setYearsExperience(yearsExperience);
        setTripsCompleted(tripsCompleted);
    }

    // Getters return each private value.
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getPhone() { return phone; }
    public String getCity() { return city; }
    public int getYearsExperience() { return yearsExperience; }
    public int getTripsCompleted() { return tripsCompleted; }

    // Setters update values, checking that numbers are sensible.
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age >= 0) this.age = age;
    }
    public void setLicenseNumber(String licenseNumber) {
        // Reject missing or blank licence values.
        if (licenseNumber != null && !licenseNumber.trim().isEmpty()) {
            this.licenseNumber = licenseNumber;
        }
    }
    public void setPhone(String phone) { this.phone = phone; }
    public void setCity(String city) { this.city = city; }
    public void setYearsExperience(int yearsExperience) {
        if (yearsExperience >= 0) this.yearsExperience = yearsExperience;
    }
    public void setTripsCompleted(int tripsCompleted) {
        if (tripsCompleted >= 0) this.tripsCompleted = tripsCompleted;
    }

    // Selection rule: the driver must be at least 18 and have a licence.
    public boolean canDrive() {
        return age >= 18 && licenseNumber != null
               && !licenseNumber.trim().isEmpty()
               && !licenseNumber.trim().equalsIgnoreCase("None");
    }

    // Updates the driver's trip count after the booking is finished.
    public void completeTrip() {
        tripsCompleted++;
        System.out.println(name + " completed a trip.");
    }

    // Shows important information without exposing private fields directly.
    public void showDriver() {
        System.out.println("Driver: " + name + ", City: " + city);
        System.out.println("Completed trips: " + tripsCompleted);
    }
}
