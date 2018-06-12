public class BankAccount {

    private static final double DEFAULT_INTEREST_RATE_VALUE = 0.02;
    private static double INTEREST_RATE = DEFAULT_INTEREST_RATE_VALUE ;
    private static int ACCOUNTS_COUNT = 1;

    private int id = 1;
    private double balance;

    public BankAccount() {
        this.id = ACCOUNTS_COUNT++;
    }

    public BankAccount(double balance) {
        this();
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount!");
        }

        this.setBalance(this.getBalance() + amount);
    }

    public void addAmount(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid money");
        }

        this.setBalance(this.getBalance() + amount);
    }
    public double getInterest(int years) {
        return INTEREST_RATE * years * this.getBalance();
    }

    public static double getDefaultInterestRateValue() {
        return DEFAULT_INTEREST_RATE_VALUE;
    }

    public static double getInterestRate() {
        return INTEREST_RATE;
    }

    public static void setInterestRate(double interestRate) {
        INTEREST_RATE = interestRate;
    }

    public static int getAccountsCount() {
        return ACCOUNTS_COUNT;
    }

    public static void setAccountsCount(int accountsCount) {
        ACCOUNTS_COUNT = accountsCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return String.format("ID %d", this.getId());
    }
}
