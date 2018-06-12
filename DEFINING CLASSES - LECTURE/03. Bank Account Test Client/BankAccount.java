public class BankAccount {

    private Integer id;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(Integer id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount of money!");
        }

        this.setBalance(this.getBalance() + amount);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid amount of money!");
        } else if (this.getBalance() - amount < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        this.setBalance(this.getBalance() - amount);
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.getId(), this.getBalance());
    }
}
