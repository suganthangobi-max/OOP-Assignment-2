# OOP Assignment 2 – Car Ride Booking System

## Project Description

This is a simple Car Ride Booking System developed using Java for our Object-Oriented Programming (OOP) Assignment 2.

This project is a continuation of Assignment 1. We improved the previous system by adding inheritance and polymorphism.

The program allows a passenger to book a ride using different types of cars, such as Sedan and SUV. The fare is calculated based on the car type and travel distance.

## OOP Concepts Used

The project demonstrates the following OOP concepts:

- Classes and Objects
- Encapsulation
- Inheritance
- Polymorphism
- Method Overriding
- Interfaces
- Default and Parameterized Constructors
- Getter and Setter Methods
- Selection Structures (if-else)
- Looping Structures (for loop)

## Project Files

**1. Car.java**

The parent class that stores common car information such as brand, model, color, year, fuel level, speed, and engine status.

**2. SedanCar.java**

A child class that inherits from Car. It includes additional information about Sedan cars and calculates the Sedan ride fare.

**3. SUVCar.java**

A child class that inherits from Car. It includes additional information about SUV cars and calculates the SUV ride fare.

**4. RideFare.java**

An interface that defines a common method for calculating ride fares. SedanCar and SUVCar provide their own fare calculations.

**5. Driver.java**

Stores driver information and checks whether the driver is eligible to drive.

**6. Passenger.java**

Stores passenger information, including wallet balance, and allows passengers to make ride payments.

**7. RideBooking.java**

Manages the ride booking process by connecting the car, driver, and passenger.

**8. Main.java**

The main class that creates objects and demonstrates how all the classes work together.

## How the Program Works

1. The program creates Sedan and SUV car objects.
2. It calculates different ride fares based on the car type.
3. The passenger selects and books a ride.
4. The system checks the driver and passenger details.
5. The passenger pays using their wallet balance.
6. The ride is completed, and the program displays the updated details.

## How to Run the Program

1. Download all eight Java files.
2. Open the files in a Java IDE such as NetBeans, Eclipse, or VS Code.
3. Make sure all Java files are in the same project folder.
4. Compile and run `Main.java`.
5. View the program output.

## Conclusion

This assignment helped us understand how inheritance, polymorphism, and encapsulation work in Java. We also learned how different classes can interact with each other to create a simple real-life application.
