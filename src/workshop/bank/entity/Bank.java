package workshop.bank.entity;

import workshop.bank.exception.*;
import java.util.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        accounts.add(new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate));
        System.out.println("Saving(����) ���°� �����Ǿ����ϴ�: " + accounts.get(accounts.size() - 1));
        return accountNumber;
    }

    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        accounts.add(new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit));
        System.out.println("üŷ ���°� �����Ǿ����ϴ�: " + accounts.get(accounts.size() - 1));
        return accountNumber;
    }

    public Account findAccount(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("���¹�ȣ " + accountNumber + "�� �ش��ϴ� ���¸� ã�� �� �����ϴ�."));
    }

    public void deposit(String accountNumber, double amount) {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, double amount) {
        findAccount(accountNumber).withdraw(amount);
    }

    public void transfer(String fromAccount, String toAccount, double amount) {
        Account sender = findAccount(fromAccount);
        Account receiver = findAccount(toAccount);
        sender.withdraw(amount);
        receiver.deposit(amount);
        System.out.printf("%.1f���� %s���� %s�� �۱ݵǾ����ϴ�.%n", amount, fromAccount, toAccount);
    }

    public void printAllAccounts() {
        System.out.println("\n=== ��� ���� ��� ===");
        accounts.forEach(acc -> System.out.println(acc));
        System.out.println("===================");
    }
}
