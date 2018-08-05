package org.abewang.java8.chap7;

import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * 代码清单7-1
 *
 * @Author Abe
 * @Date 2018/8/5.
 */
public class Code_7_1 {
    public static long measureSumPref(Function<Long, Long> adder, Long n) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;
//            System.out.println("Result: " + sum);
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n)
                .reduce(0L, Long::sum);
    }

    public static void main(String[] args) {
        long n = 50_000_000;
        System.out.println("Sequential sum done in " +
                measureSumPref(ParallelStreams::sequentialSum, n) + " msecs");

        // 用传统for循环的迭代版本执行起来应该会快很多, 因为它更为底层, 更重要的是不需要对原始类型做
        // 任何装箱和折箱操作.
        System.out.println("Iterative sum done in " +
                measureSumPref(ParallelStreams::iterativeSum, n) + " msecs");

        System.out.println("Parallel sum done in " +
                measureSumPref(ParallelStreams::parallelSum, n) + " msecs");

        System.out.println("Ranged sum done in " +
                measureSumPref(ParallelStreams::rangedSum, n) + " msecs");

        System.out.println("Parallel range sum done in " +
                measureSumPref(ParallelStreams::rangedSum, n) + " msecs");
    }
}
