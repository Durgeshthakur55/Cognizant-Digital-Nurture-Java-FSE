public class Car {
    String make;
    String model;
    int year;

    public void displayDetails() {
        System.out.println("Car Details: " + year + " " + make + " " + model);
    }

    public static void main(String[] args) {
        Car firstCar = new Car();
        firstCar.make = "Honda";
        firstCar.model = "Civic";
        firstCar.year = 2022;
        firstCar.displayDetails();
        
        Car secondCar = new Car();
        secondCar.make = "Tesla";
        secondCar.model = "Model 3";
        secondCar.year = 2024;
        secondCar.displayDetails();
    }
    
}
