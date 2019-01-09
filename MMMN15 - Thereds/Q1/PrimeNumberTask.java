public class PrimeNumberTask implements Runnable {

    private NumberProvider provider;

    public PrimeNumberTask(NumberProvider provider) {
        this.provider = provider;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is started");
        long number = provider.getNextNumber();

        System.out.println(Thread.currentThread().getName() + " checking number [ " + number + " ]");

        boolean flag = false;

        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                flag = true;
                break;
            }
        }

        if (!flag) {
            System.out.println(Thread.currentThread().getName() + " number [ " + number + " ] is a prime");
            provider.addPrime(number);

        } else {
            System.out.println(Thread.currentThread().getName() + " number [ " + number + " ] isn't a prime");
        }
        provider.checked();

        System.out.println(Thread.currentThread().getName() + " is stopped");
    }
}
