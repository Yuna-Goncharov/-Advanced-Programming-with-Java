public class ServiceChargeChecking extends CheckingAccount {

    private static final double DEFAULT_COMMISSION = 20;
    private double commission;

    //methods to set default commission
    public ServiceChargeChecking(String accNo, String accOwner, String accOwnerID, double accBalance) {
        this(accNo, accOwner, accOwnerID, accBalance, DEFAULT_COMMISSION);
    }

    //methods to set different commission
    public ServiceChargeChecking(String accNo, String accOwner, String accOwnerID, double accBalance, double com) {
        super(accNo, accOwner, accOwnerID, accBalance);
        this.commission = com;
    }

    //get and sets
    public double getCommission() {
        return this.commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public void monthlyManagement() {
        withdraw(this.commission);
    }

    public String toString() {
        return super.toString() + "Account commission :" + commission + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceChargeChecking)) return false;
        if (!super.equals(o)) return false;
        ServiceChargeChecking that = (ServiceChargeChecking) o;
        return Double.compare(that.commission, commission) == 0;
    }
}
