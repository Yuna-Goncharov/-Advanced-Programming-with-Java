import java.util.Random;

public class FlightTester {
    public static void main(String[] args) {

        // make two airports
        Airport newYorkAirport = new Airport("NEW YORK", 3);
        Airport londonAirport = new Airport("LONDON", 3);
        Flight flight;
        Random rand = new Random();

        // create and start 10 flight randomly between the airports
        for (int i = 0; i < 10; i++) {
            if (rand.nextInt(100) % 2 == 1) {
                flight = new Flight(rand.nextInt(9999), newYorkAirport, londonAirport);
            } else {
                flight = new Flight(rand.nextInt(9999), londonAirport, newYorkAirport);
            }
            flight.start();
        }
    }
}
