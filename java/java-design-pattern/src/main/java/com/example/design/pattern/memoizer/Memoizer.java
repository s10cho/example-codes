package com.example.design.pattern.memoizer;

import static java.util.stream.IntStream.range;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Function;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Memoizer<V, R> {
    private final BiFunction<? super V, Function<? super V, ? extends R>, ? extends R> bifunction;

    private final HashMap<V, R> map = new HashMap<>();

    public Memoizer(BiFunction<? super V, Function<? super V, ? extends R>, ? extends R> bifunction) {
        this.bifunction = bifunction;
    }

    public static void main(String[] args) {
        var fibo = new Memoizer<Integer, Integer>((n, fib) -> n < 2 ? 1 : fib.apply(n - 1) + fib.apply(n - 2));

        range(0, 20).map(fibo::memoize)
            .mapToObj(Integer::toString)
            .forEach(log::debug);
    }

    public R memoize(V value) {
        return map.computeIfAbsent(value, v -> bifunction.apply(v, this::memoize));
    }
}
