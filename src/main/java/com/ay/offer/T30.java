package com.ay.offer;

import java.util.ArrayList;

/**
 * @author ay
 * @create 2020-03-04 15:43
 * <p>
 * <p>
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 * <p>
 * 思路
 * 看到这个问题, 我们最开始可能会想, 添加一个成员变量用于保存最小元素, 每次压栈时如果压栈元素比当前最小元素更小, 就更新最小元素.
 * 但是这样会有一个问题, 如果最小元素被弹出了呢, 如何获得下一个最小元素呢? 分析到这里可以发现,
 * 仅仅添加一个成员变量存放最小元素是不够的,
 * 我们需要在最小元素弹出后还能得到次小元素, 次小的弹出后, 还要能得到次次小的.
 * 因此, 用另一个栈来保存这些元素是再合适不过的了. 我们叫它最小元素栈.
 * 每次压栈操作时, 如果压栈元素比当前最小元素更小, 就把这个元素压入最小元素栈, 原本的最小元素就成了次小元素.
 * 同理, 弹栈时, 同时弹出.
 */
public class T30 {

    ArrayList<Integer> dataList = new ArrayList();
    ArrayList<Integer> minList = new ArrayList();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        dataList.add(node);
        if (node <= min) {
            minList.add(node);
            min = node;
        }else {
            minList.add(min);
        }
    }

    public void pop() {
        int end = dataList.size()-1;
        dataList.remove(end);
        minList.remove(end);
        min = minList.get(end-1);
    }

    public int top() {
        return dataList.get(dataList.size()-1);
    }

    public int min() {
        return min;
    }
}
