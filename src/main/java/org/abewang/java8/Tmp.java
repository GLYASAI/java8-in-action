package org.abewang.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @Author Abe
 * @Date 2018/8/1.
 */
public class Tmp {
    public static void main(String[] args) {
        List<Integer> numbers1 = List.of(1, 2, 3);
        List<Integer> numbers2 = List.of(3, 4);
        List result = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                                      .filter(j -> (i + j) % 3 == 0)
                                      .map(j -> new int[]{i, j}))
                .collect(toList());
        System.out.println(result);
    }
}
