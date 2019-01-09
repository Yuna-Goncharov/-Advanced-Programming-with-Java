import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskManager {

    private ExecutorService executor;
    private NumberProvider provider;

    public void findPrimeNumbers() {

        try {
            askUser();

            for (long i = 1; i <= this.provider.getMaxNumber(); i++) {
                this.executor.execute(new PrimeNumberTask(this.provider));
            }

            this.executor.shutdown();

            this.provider.printAllPrimes();
        } catch (InputMismatchException im) {
            System.out.println("Wrong input");
        } catch (Exception e) {
            System.out.println("Error !!! " + e.getMessage());
        }
    }

    private void askUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the max number: ");
        long number = sc.nextLong();
        System.out.println("Please enter the number of threads: ");
        int numberOfThreads = sc.nextInt();

        sc.close();

        this.executor = Executors.newFixedThreadPool(numberOfThreads);
        this.provider = new NumberProvider(number);
    }

}
