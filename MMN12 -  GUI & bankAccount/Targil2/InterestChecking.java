import java.util.Objects;

public class InterestChecking extends NoServiceChargeChecking {

    private static final double DEFAULT_INTEREST = 0.1;
    private double interest;

    public InterestChecking(String accNo, String accOwner, String accOwnerID, double accBalance, double min) {
        this(accNo, accOwner, accOwnerID, accBalance, min,DEFAULT_INTEREST);
    }

    public InterestChecking(String accNo, String accOwner, String accOwnerID, double accBalance, double min, double interest) {
        super(accNo, accOwner, accOwnerID, accBalance, min);
        this.interest = interest;
    }

    //get and sets methods
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
        this.deposit(calcInterest());
    }

    public String toString() {
        return super.toString() + "Account interest: " + interest + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InterestChecking)) return false;
        if (!super.equals(o)) return false;
        InterestChecking that = (InterestChecking) o;
        return Double.compare(that.interest, interest) == 0;
    }
}
