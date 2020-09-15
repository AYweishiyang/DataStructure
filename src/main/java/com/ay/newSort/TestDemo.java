package com.ay.newSort;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author ay
 * @create 2020-09-09 16:22
 */
public class TestDemo {
    public static void main(String[] args) {
        TreeSet tr=new TreeSet(Collections.reverseOrder());
        tr.add("aaa");
        tr.add("ffgfg");
        tr.add("sdsdsghghgh");
        Iterator it=tr.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}


////若有自定义比较器，想要翻转排列，则可如下
//
//public class TreeSetDemo {
//
//    public static void main(String[] args) {
//        TreeSet tr=new TreeSet(Collections.reverseOrder(new StrLenComparator()));
//        tr.add("aaa");
//        tr.add("ffgfg");
//        tr.add("sdsdsghghgh");
//        Iterator it=tr.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//    }
//}