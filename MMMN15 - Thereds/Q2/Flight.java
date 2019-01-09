
/*
 * A class that represents a single flight from one destination to another
 */

import java.util.Random;

public class Flight extends Thread {
    private int flightNum; // the flight number
    private Airport departAirport; // departing airport
    private Airport landingAirport; // landing airport
    private Random rand = new Random();

    // constructs a new flight
    public Flight(int flightNum, Airport departAirport, Airport landingAirport) {
        this.flightNum = flightNum;
        this.departAirport = departAirport;
        this.landingAirport = landingAirport;
    }

    // Overrides the run method
    public void run() {
        try {
            // flight is departing
            int departRunway = departAirport.depart(flightNum);
            departing();

            departAirport.freeRunway(departRunway);

            // waiting in flight
            flight();

            // flight is landing
            int landRunway = landingAirport.land(flightNum);
            landing();
            landingAirport.freeRunway(landRunway);
        } catch (InterruptedException e) {
            System.out.println("Good Morning !!");
        }
    }

    private void departing() throws InterruptedException {
        sleep((rand.nextInt(3) + 2) * 1000);
    }

    private void flight() throws InterruptedException {
        System.out.println("Flight " + flightNum + " is flying");
        sleep(rand.nextInt(2) * 1000);
    }

    private void landing() throws InterruptedException {
        sleep((rand.nextInt(3) + 2) * 1000);
    }

}
