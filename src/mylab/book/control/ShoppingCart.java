package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;

public class ShoppingCart {
    private List<Publication> items = new ArrayList<>();

    public void addItem(Publication item) {
        items.add(item);
    }

    public boolean removeItem(String title) {
        for (Publication item : items) {
            if (item.getTitle().equals(title)) {
                items.remove(item);
                System.out.println(title + " �׸��� ���ŵǾ����ϴ�.");
                return true;
            }
        }
        System.out.println(title + " �׸��� ã�� �� �����ϴ�.");
        return false;
    }

    public void displayCart() {
        System.out.println("==== ��ٱ��� ��� ====");
        int i = 1;
        for (Publication item : items) {
            System.out.println((i++) + ". " + item);
        }
        System.out.printf("�� ����: %,d��%n", calculateTotalPrice());
        System.out.printf("���� ���� ����: %,d��%n", calculateDiscountedPrice());
    }

    public int calculateTotalPrice() {
        return items.stream().mapToInt(Publication::getPrice).sum();
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            int price = item.getPrice();
            if (item instanceof Magazine) {
                price *= 0.9;
            } else if (item instanceof Novel) {
                price *= 0.85;
            } else if (item instanceof ReferenceBook) {
                price *= 0.9;
            }
            total += price;
        }
        return total;
    }

    public List<Publication> getItems() {
        return items;
    }
}
