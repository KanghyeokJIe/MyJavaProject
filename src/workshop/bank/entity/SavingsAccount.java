package workshop.bank.entity;

import workshop.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, String ownerName, double initialBalance, double interestRate) {
        super(accountNumber, ownerName, initialBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void applyInterest() {
        double interest = balance * (interestRate / 100);
        deposit(interest);
        System.out.printf("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원%n", interest, balance);
    }

    @Override
    public void withdraw(double amount) {
        if (balance < amount) {
            throw new InsufficientBalanceException("잔액이 부족합니다.");
        }
        balance -= amount;
        System.out.printf("%.1f원이 출금되었습니다. 현재 잔액: %.1f원%n", amount, balance);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 이자율: %.1f%%", interestRate);
    }
}