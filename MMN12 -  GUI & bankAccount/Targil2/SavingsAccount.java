import java.util.Objects;

public class SavingsAccount extends BankAccount {

    private static final double DEFAULT_INTEREST = 0.1;
    private double interest;

    public SavingsAccount(String accNo, String accOwner, String accOwnerID, double accBalance) {
        this(accNo, accOwner, accOwnerID, accBalance,DEFAULT_INTEREST);
    }

    public SavingsAccount(String accNo, String accOwner, String accOwnerID, double accBalance, double interest) {
        super(accNo, accOwner, accOwnerID, accBalance);
        this.interest = interest;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double calcInterest() {
        return this.getAccountBalance() * interest;
    }

    public void monthlyManagement() {
        this.deposit(this.calcInterest());
    }

    public String toString() {
        return super.toString() + "Account interest: " + interest + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SavingsAccount)) return false;
        if (!super.equals(o)) return false;
        SavingsAccount that = (SavingsAccount) o;
        return Double.compare(that.interest, interest) == 0;
    }
}
