package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;
import workshop.bank.exception.WithdrawalLimitExceededException;

public class CheckingAccount extends Account {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double withdrawalLimit) {
        super(accountNumber, ownerName, initialBalance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("출금 한도를 초과했습니다. 한도: %.1f원", withdrawalLimit));
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n", amount, balance);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 출금 한도: %.1f원", withdrawalLimit);
    }
}
