import java.util.TreeSet;

public class NumberProvider {

    private long maxNumber;
    private long nextNumber;
    private TreeSet<Long> primeNumbers;
    private long count;
    private boolean isFinished;

    public NumberProvider(long maxNumber) {
        this.maxNumber = maxNumber;
        this.nextNumber = 1;
        this.count = 0;
        this.primeNumbers = new TreeSet<>();
        this.isFinished = false;
    }

    public synchronized long getNextNumber() {
        return this.nextNumber++;
    }

    public synchronized void addPrime(long primeNumber) {
        this.primeNumbers.add(primeNumber);
    }

    public long getMaxNumber() {
        return this.maxNumber;
    }

    public synchronized void checked() {
        this.count++;
        if (this.count == this.maxNumber) {
            isFinished = true;
            notifyAll();
        }
    }

    public synchronized void printAllPrimes() {
        try {
            while (!isFinished) {
                wait();
            }

            System.out.println("*****************");
            for (Long prime : primeNumbers) {
                System.out.print(" " + prime);
            }
            System.out.println();
            System.out.println("*****************");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
