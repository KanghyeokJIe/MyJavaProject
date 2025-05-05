package mylab.book.control;

import mylab.book.entity.*;
import java.util.*;
import java.util.stream.*;

public class StatisticsAnalyzer {
    private List<Publication> items;

    public StatisticsAnalyzer(List<Publication> items) {
        this.items = items;
    }

    public void calculateAveragePriceByType() {
        // 고정된 순서 유지: 소설 → 참고서 → 잡지
        Map<String, List<Publication>> grouped = new LinkedHashMap<>();
        grouped.put("소설", new ArrayList<>());
        grouped.put("참고서", new ArrayList<>());
        grouped.put("잡지", new ArrayList<>());

        for (Publication p : items) {
            if (p instanceof Novel) grouped.get("소설").add(p);
            else if (p instanceof ReferenceBook) grouped.get("참고서").add(p);
            else if (p instanceof Magazine) grouped.get("잡지").add(p);
        }

        System.out.println("1. 타입별 평균 가격:");
        for (String type : grouped.keySet()) {
            List<Publication> pubs = grouped.get(type);
            double avg = pubs.stream().mapToInt(Publication::getPrice).average().orElse(0);
            System.out.printf("   - %s: %,d원%n", type, (int) avg);
        }
    }

    public void printStatistics() {
        System.out.println("===== 출판물 통계 분석 =====");
        calculateAveragePriceByType();

        System.out.println("\n2. 출판물 유형 분포:");
        long total = items.size();

        Map<String, Long> typeCount = new LinkedHashMap<>();
        typeCount.put("소설", 0L);
        typeCount.put("참고서", 0L);
        typeCount.put("잡지", 0L);

        for (Publication p : items) {
            if (p instanceof Novel) typeCount.put("소설", typeCount.get("소설") + 1);
            else if (p instanceof ReferenceBook) typeCount.put("참고서", typeCount.get("참고서") + 1);
            else if (p instanceof Magazine) typeCount.put("잡지", typeCount.get("잡지") + 1);
        }

        for (Map.Entry<String, Long> entry : typeCount.entrySet()) {
            double ratio = (double) entry.getValue() / total * 100;
            System.out.printf("   - %s: %.2f%%%n", entry.getKey(), ratio);
        }

        // ✅ 3. 2007년 출판 비율
        long year2007 = items.stream()
            .filter(p -> p.getPublishDate().startsWith("2007"))
            .count();
        double yearRatio = (double) year2007 / total * 100;

        System.out.printf("\n3. 2007년에 출판된 출판물 비율: %.2f%%%n", yearRatio);
        System.out.println("=============================");
    }
}
