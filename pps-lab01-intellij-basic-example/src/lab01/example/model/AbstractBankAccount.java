package lab01.example.model;

public abstract class AbstractBankAccount implements BankAccount{

    protected final AccountHolder holder;
    protected double balance;

    public AbstractBankAccount(final AccountHolder holder, final double balance) {
        this.balance = balance;
        this.holder = holder;
    }

    public AccountHolder getHolder() {
        return this.holder;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount;
        }
    }

    public void depositWithAtm(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.deposit(userID, amount - this.getFee());
        }
    }

    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount;
        }
    }

    public void withdrawWithAtm(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.withdraw(userID, amount + this.getFee());
        }
    }

    private boolean isWithdrawAllowed(final double amount) {
        return this.balance >= amount;
    }

    protected abstract double getFee();

    private boolean checkUser(final int id) {
        return this.holder.getId() == id;
    }
}
