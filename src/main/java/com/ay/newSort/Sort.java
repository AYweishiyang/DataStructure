package com.ay.newSort;

/**
 * @author ay
 * @create 2020-01-13 10:50
 */
public interface Sort<T extends Comparable<T>> {

    void sort(T[] nums);

    default boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    default void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}