import java.util.Objects;

public abstract class BankAccount {

    //includes protected account number of type String
    //name of the account owner type String,
    //Id number for the owner of the account type String
    //account balance type double

    private String accountNum;
    private String accountOwner;
    private String accountOwnerID;
    private double accountBalance;

    //bank account constructor
    public BankAccount() {
        accountNum = "";
        accountOwner = "";
        accountOwnerID = "";
        accountBalance = 0;
    }

    public BankAccount(String accNo, String accOwner, String accOwnerID, double accBalance) {
        accountNum = accNo;
        accountOwner = accOwner;
        accountOwnerID = accOwnerID;
        accountBalance = accBalance;
    }

    //get and set methods for bank account

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }

    public String getAccountOwnerID() {
        return accountOwnerID;
    }

    public void setAccountOwnerID(String accountOwnerID) {
        this.accountOwnerID = accountOwnerID;
    }

    public double getAccountBalance() {
        return accountBalance;
    }


    //boolean method test if the deposit is higher then 0 then add to balance account
    public boolean deposit(double x) {
        if (x > 0) {
            this.accountBalance += x;
            return true;
        } else {
            return false;
        }

        //method withdraw - checks if reducing the wanted amount causing luck of money
        // in the account will lead to illegal balance
    }

    public void withdraw(double w) {
        try {
            if (this.accountBalance < w) {
                throw new IllegalBalance();
            } else {
                this.accountBalance -= w;
            }
        } catch (IllegalBalance e) {
            System.out.println("Insufficient funds for withdraw.");
        }
    }

    public abstract void monthlyManagement();

    //toString method
    public String toString() {
        return "Account status:\n-------------\n" + "Account number :" + accountNum + "\nAccount owner: " + accountOwner +
                "\nAccount owner ID: " + accountOwnerID + "\nAccount balance:" + accountBalance + "\n";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount that = (BankAccount) o;
        return Double.compare(that.accountBalance, accountBalance) == 0 &&
                Objects.equals(accountNum, that.accountNum) &&
                Objects.equals(accountOwner, that.accountOwner) &&
                Objects.equals(accountOwnerID, that.accountOwnerID);
    }
}
	
	
	
	