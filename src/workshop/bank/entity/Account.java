package workshop.bank.entity;

public abstract class Account {
    protected String accountNumber;
    protected String ownerName;
    protected double balance;

    public Account(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        balance += amount;
        System.out.printf("%.1f원이 입금되었습니다. 현재 잔액: %.1f원%n", amount, balance);
    }

    public abstract void withdraw(double amount);

    @Override
    public String toString() {
        return String.format("계좌번호: %s, 소유자: %s, 잔액: %.1f원", accountNumber, ownerName, balance);
    }
}