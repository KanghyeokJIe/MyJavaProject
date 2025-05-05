package workshop.bank.entity;

import workshop.bank.exception.*;
import java.util.*;

public class Bank {
    private List<Account> accounts = new ArrayList<>();
    private int nextAccountNumber = 1000;

    public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
        String accountNumber = "AC" + nextAccountNumber++;
        accounts.add(new SavingsAccount(accountNumber, ownerName, initialBalance, interestRate));
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + accounts.get(accounts.size() - 1));
        return accountNumber;
    }

    public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
        String accountNumber = "AC" + nextAccountNumber++;
        accounts.add(new CheckingAccount(accountNumber, ownerName, initialBalance, withdrawalLimit));
        System.out.println("체킹 계좌가 생성되었습니다: " + accounts.get(accounts.size() - 1));
        return accountNumber;
    }

    public Account findAccount(String accountNumber) {
        return accounts.stream()
                .filter(acc -> acc.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다."));
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
        System.out.printf("%.1f원이 %s에서 %s로 송금되었습니다.%n", amount, fromAccount, toAccount);
    }

    public void printAllAccounts() {
        System.out.println("\n=== 모든 계좌 목록 ===");
        accounts.forEach(acc -> System.out.println(acc));
        System.out.println("===================");
    }
}
