package workshop.bank.control;

import workshop.bank.entity.Bank;
import workshop.bank.entity.SavingsAccount;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        System.out.println("=== ���� ���� ===");
        String ac1 = bank.createSavingsAccount("ȫ�浿", 10000.0, 3.0);
        String ac2 = bank.createCheckingAccount("��ö��", 20000.0, 5000.0);
        String ac3 = bank.createSavingsAccount("�̿���", 30000.0, 2.0);

        bank.printAllAccounts();

        System.out.println("\n=== �Ա�/��� �׽�Ʈ ===");
        bank.deposit(ac1, 5000.0);
        bank.withdraw(ac2, 3000.0);

        System.out.println("\n=== ���� ���� �׽�Ʈ ===");
        ((SavingsAccount) bank.findAccount(ac1)).applyInterest();

        System.out.println("\n=== ���� ��ü �׽�Ʈ ===");
        bank.transfer(ac3, ac2, 5000.0);

        bank.printAllAccounts();

        // ���� �׽�Ʈ
        try {
            bank.withdraw(ac2, 6000.0);
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999");
        } catch (Exception e) {
            System.out.println("���� �߻�: " + e.getMessage());
        }
    }
}
