// Common interface: different car types calculate their ride fares differently.
public interface RideFare {
    // Returns the fare (RM) for the given travel distance in kilometres.
    double calculateFare(int distanceKm);
}
