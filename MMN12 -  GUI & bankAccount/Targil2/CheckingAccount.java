public abstract class CheckingAccount extends BankAccount {

    public CheckingAccount(String accNo, String accOwner, String accOwnerID, double accBalance) {
        super(accNo, accOwner, accOwnerID, accBalance);
    }

    public void writeCheck(double amount) {
        try {
            if (amount > getAccountBalance()) {
                throw new IllegalBalance();
            }
            System.out.println("Written check for the amount of:" + amount);
        } catch (IllegalBalance e) {
            System.out.println("Insufficient funds for check.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CheckingAccount)) return false;
        return super.equals(o);
    }
}
