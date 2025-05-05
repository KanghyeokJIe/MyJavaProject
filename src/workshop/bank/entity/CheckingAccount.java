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
                String.format("��� �ѵ��� �ʰ��߽��ϴ�. �ѵ�: %.1f��", withdrawalLimit));
        }
        if (balance < amount) {
            throw new InsufficientBalanceException("�ܾ��� �����մϴ�.");
        }
        balance -= amount;
        System.out.printf("%.1f���� ��ݵǾ����ϴ�. ���� �ܾ�: %.1f��%n", amount, balance);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", ��� �ѵ�: %.1f��", withdrawalLimit);
    }
}
