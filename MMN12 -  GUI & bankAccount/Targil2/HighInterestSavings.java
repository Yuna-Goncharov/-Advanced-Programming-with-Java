import java.util.Objects;

public class HighInterestSavings extends SavingsAccount {

    private static final double DEFAULT_HIGH_MINIMUM = 200;
    private static final double DEFAULT_HIGH_INTEREST = 0.2;
    private double highMinimum;

    public HighInterestSavings(String accNo, String accOwner, String accOwnerID, double accBalance) {
        this(accNo, accOwner, accOwnerID, accBalance, DEFAULT_HIGH_MINIMUM);
    }

    public HighInterestSavings(String accNo, String accOwner, String accOwnerID, double accBalance, double highMinimum) {
        super(accNo, accOwner, accOwnerID, accBalance, DEFAULT_HIGH_INTEREST);
        this.highMinimum = highMinimum;
    }

    //set and get methods
    public double getHighMinimum() {
        return highMinimum;
    }

    public double minAllowed() {
        return highMinimum;
    }

    public void setHighMinimum(double highMinimum) {
        this.highMinimum = highMinimum;
    }

    public String toString() {
        return super.toString() + "Account minimum: " + highMinimum + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HighInterestSavings)) return false;
        if (!super.equals(o)) return false;
        HighInterestSavings that = (HighInterestSavings) o;
        return Double.compare(that.highMinimum, highMinimum) == 0;
    }
}
