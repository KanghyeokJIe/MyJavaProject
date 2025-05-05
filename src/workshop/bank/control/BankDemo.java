package workshop.bank.control;

import workshop.bank.entity.Bank;
import workshop.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== 계좌 생성 ===");
        String ac1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        String ac2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        String ac3 = bank.createSavingsAccount("이영희", 30000.0, 2.0);

        bank.printAllAccounts();

        System.out.println("\n=== 입금/출금 테스트 ===");
        bank.deposit(ac1, 5000.0);
        bank.withdraw(ac2, 3000.0);

        System.out.println("\n=== 이자 적용 테스트 ===");
        ((SavingsAccount) bank.findAccount(ac1)).applyInterest();

        System.out.println("\n=== 계좌 이체 테스트 ===");
        bank.transfer(ac3, ac2, 5000.0);

        bank.printAllAccounts();

        // 예외 테스트
        try {
            bank.withdraw(ac2, 6000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
