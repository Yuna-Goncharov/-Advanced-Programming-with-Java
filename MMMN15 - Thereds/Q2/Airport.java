/*
 * A class representing one airport
 */

import java.util.concurrent.ConcurrentLinkedQueue;

public class Airport {

    private int runwaysNum; // the number of runways
    private String name; // Airport name
    private boolean[] runways; // represents the runway states. false = empty , true = taken
    private ConcurrentLinkedQueue<Boolean> queue = new ConcurrentLinkedQueue<>();

    // constructs a new airport with empty runways
    public Airport(String name, int runNum) {
        this.name = name;
        this.runwaysNum = runNum;
        this.runways = new boolean[runwaysNum];
        System.out.println("Airport " + name + " with number of runways: " + runNum + " initialized");
    }

    // method for the flight to depart from the airport
    public int depart(int flightNum) {

        // adds the flight to the queue for using a runway
        addFlightToQueue(true);

        synchronized (this) {
            try {
                while (getFreeRunway() == -1 || !isWaitingForDepart()) {
                    System.out.println("Flight " + flightNum + " is waiting for depart from " + getName());
                    wait();
                }
            } catch (InterruptedException e) {
                System.out.println("rude awakening!!");
            }

            int freeRunway = getFreeRunway(); // get a runway for departure
            occupy(freeRunway); // mark the runway as occupied
            removeFlightFromQueue();
            System.out.println("Flight " + flightNum + " is departing from " + getName() + ", runway number: " + freeRunway);

            return freeRunway + 1; // return the number of the used runway
        }
    }

    // method for the flight to land at the airport
    public int land(int flightNum) {

        // adds the flight to the queue for using a runway
        addFlightToQueue(false);
        synchronized (this) {
            // if there is no free runway wait for one
            while (getFreeRunway() == -1 || !isWaitingForLand()) {
                try {
                    System.out.println("Flight " + flightNum + " is waiting to land to " + getName());
                    wait();
                } catch (InterruptedException e) {
                    System.out.println("rude awakening!!");
                }
            }
            int freeRunway = getFreeRunway();// get a runway for departure
            occupy(freeRunway);// mark the runway as occupied
            removeFlightFromQueue();
            System.out.println("Flight " + flightNum + " is landing to " + getName() + ", runway number: " + freeRunway);

            return freeRunway + 1;// return the number of the used runway
        }
    }

    // clears the given runway and notifies waiting threads
    public void freeRunway(int runNum) {
        synchronized (this) {
            this.runways[runNum - 1] = false;
            notifyAll();
        }
    }

    // looks for the next free runway. if not found returns -1
    private synchronized int getFreeRunway() {
        for (int i = 0; i < runwaysNum; i++)
            if (!this.runways[i])
                return i;
        return -1;
    }

    private synchronized void occupy(int runwayNumber) {
        this.runways[runwayNumber] = true;
    }

    private synchronized void addFlightToQueue(boolean isDepart) {
        this.queue.add(isDepart);
    }

    private synchronized void removeFlightFromQueue() {
        this.queue.remove();
    }

    private synchronized boolean isWaitingForDepart() {
        return this.queue.peek() != null && this.queue.peek();
    }

    private synchronized boolean isWaitingForLand() {
        return this.queue.peek() != null && !this.queue.peek();
    }

    public String getName() {
        return this.name;
    }
}
