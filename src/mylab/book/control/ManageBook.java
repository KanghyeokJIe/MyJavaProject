package mylab.book.control;

import mylab.book.entity.*;

public class ManageBook {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 1. 출판물 추가
        cart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));
        cart.addItem(new Novel("소년이온다", "2014-05-01", 216, 15000, "한강", "장편소설"));
        cart.addItem(new Novel("작별하지않는다", "2021-09-09", 332, 15120, "한강", "장편소설"));

        // 2. 도서 정보 출력
        System.out.println("==== 도서 정보 출력 ====");
        int i = 1;
        for (Publication p : cart.getItems()) {
            System.out.printf("%d. %s%n", i++, p);
        }

        // 3. 가격 변경 테스트
        System.out.println("\n==== 가격 변경 ====");
        Publication book = cart.getItems().get(6); // "작별하지않는다"
        int before = book.getPrice();
        System.out.printf("%s 변경 전 가격: %,d원%n", book.getTitle(), before);

        modifyPrice(book); // 할인 적용

        int after = book.getPrice();
        System.out.printf("%s 변경 후 가격: %,d원%n", book.getTitle(), after);
        System.out.printf("차액: %,d원%n", before - after);

        // 4. 통계 분석 출력
        StatisticsAnalyzer analyzer = new StatisticsAnalyzer(cart.getItems());
        analyzer.printStatistics();
    }

    // 출판물 타입별 할인 적용 메서드
    public static void modifyPrice(Publication p) {
        int price = p.getPrice();
        if (p instanceof Magazine) {
            p.setPrice((int) (price * 0.6));  // 40% 할인
        } else if (p instanceof Novel) {
            p.setPrice((int) (price * 0.8));  // 20% 할인
        } else if (p instanceof ReferenceBook) {
            p.setPrice((int) (price * 0.9));  // 10% 할인
        }
    }
}
