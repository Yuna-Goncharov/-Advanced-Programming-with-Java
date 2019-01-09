import java.util.Objects;

public class NoServiceChargeChecking extends CheckingAccount {

    private static final double DEFAULT_WITHDRAW_MINIMUM = 200;
    private double minimum;

    public NoServiceChargeChecking(String accNo, String accOwner, String accOwnerID, double accBalance) {
        this(accNo, accOwner, accOwnerID, accBalance, DEFAULT_WITHDRAW_MINIMUM);
    }

    public NoServiceChargeChecking(String accNo, String accOwner, String accOwnerID, double accBalance, double min) {
        super(accNo, accOwner, accOwnerID, accBalance);
        minimum = min;
    }

    public double minAllowed() {
        return minimum;
    }

    //get and sets for minimum
    public double getMinimum() {
        return minimum;
    }

    public void setMinimum(double minimum) {
        this.minimum = minimum;
    }

    public void monthlyManagement() {
    }

    public String toString() {
        return super.toString() + "Minimum withdraw :" + minimum + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoServiceChargeChecking)) return false;
        if (!super.equals(o)) return false;
        NoServiceChargeChecking that = (NoServiceChargeChecking) o;
        return Double.compare(that.minimum, minimum) == 0;
    }
}
