package org.abewang.java8.chap5.practice;

import java.util.List;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * @Author Abe
 * @Date 2018/8/2.
 */
public class Main {

    static Trader raoul = new Trader("Raoul", "Cambridge");
    static Trader mario = new Trader("Mario", "Milan");
    static Trader alan = new Trader("Alan", "Cambridge");
    static Trader brian = new Trader("Brian", "Cambridge");

    static List<Transaction> transactions = List.of(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        // (1) 找出2011年发生的所有交易, 并按交易额排序
        List<Transaction> tr2011 = transactions.stream()
                .filter(t -> t.getYear() == 2011)
                .sorted(comparing(Transaction::getYear))
                .collect(toList());
        System.out.println(tr2011);

        // (2) 交易员都在哪些不同的城市工作过
        List<String> trCity = transactions.stream()
                .map(t -> t.getTrader().getCity())
                .distinct()
                .collect(toList());
        System.out.println(trCity);

        // (3) 查找所有来自于剑桥的交易员, 并按姓名排序
        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .filter(t -> "Cambridge".equals(t.getCity()))
                .distinct()
                .sorted(comparing(Trader::getName))
                .collect(toList());
        System.out.println(traders);

        // (4) 返回所有交易员的姓名字符串, 按字母顺序排序
        String tradersStr = transactions.stream()
                .map(t -> t.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println(tradersStr);
    }
}
