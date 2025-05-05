package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 1. ���ǹ� �߰�
        cart.addItem(new Magazine("����ũ�μ���Ʈ", "2007-10-01", 328, 9900, "�ſ�"));
        cart.addItem(new Magazine("�濵����ǻ��", "2007-10-03", 316, 9000, "�ſ�"));
        cart.addItem(new Novel("���߿�", "2007-07-01", 396, 9800, "����������������", "����Ҽ�"));
        cart.addItem(new Novel("���ѻ꼺", "2007-04-14", 383, 11000, "����", "���ϼҼ�"));
        cart.addItem(new ReferenceBook("�ǿ��������α׷���", "2007-01-14", 496, 25000, "����Ʈ�������"));
        cart.addItem(new Novel("�ҳ��̿´�", "2014-05-01", 216, 15000, "�Ѱ�", "����Ҽ�"));
        cart.addItem(new Novel("�ۺ������ʴ´�", "2021-09-09", 332, 15120, "�Ѱ�", "����Ҽ�"));

        // 2. ���� ���� ���
        System.out.println("==== ���� ���� ��� ====");
        int i = 1;
        for (Publication p : cart.getItems()) {
            System.out.printf("%d. %s%n", i++, p);
        }

        // 3. ���� ���� �׽�Ʈ
        System.out.println("\n==== ���� ���� ====");
        Publication book = cart.getItems().get(6); // "�ۺ������ʴ´�"
        int before = book.getPrice();
        System.out.printf("%s ���� �� ����: %,d��%n", book.getTitle(), before);

        modifyPrice(book); // ���� ����

        int after = book.getPrice();
        System.out.printf("%s ���� �� ����: %,d��%n", book.getTitle(), after);
        System.out.printf("����: %,d��%n", before - after);

        // 4. ��� �м� ���
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer(cart.getItems());
        analyzer.printStatistics();
    }

    // ���ǹ� Ÿ�Ժ� ���� ���� �޼���
    public static void modifyPrice(Publication p) {
        int price = p.getPrice();
        if (p instanceof Magazine) {
            p.setPrice((int) (price * 0.6));  // 40% ����
        } else if (p instanceof Novel) {
            p.setPrice((int) (price * 0.8));  // 20% ����
        } else if (p instanceof ReferenceBook) {
            p.setPrice((int) (price * 0.9));  // 10% ����
        }
    }
}
