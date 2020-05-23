package com.ay.leetcode.queueandstack;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. 打开转盘锁
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1
 *
 * 思路：广度优先
 * 方法一：广度优先搜索
 * 我们可以将 0000 到 9999 这 10000 状态看成图上的 10000 个节点，两个节点之间存在一条边，
 * 当且仅当这两个节点对应的状态只有 1 位不同，且不同的那位相差 1（包括 0 和 9 也相差 1 的情况），
 * 并且这两个节点均不在数组 deadends 中。那么最终的答案即为 0000 到 target 的最短路径。
 *
 * 我们用广度优先搜索来找到最短路径，从 0000 开始搜索。对于每一个状态，它可以扩展到最多 8 个状态，
 * 即将它的第 i = 0, 1, 2, 3 位增加 1 或减少 1，将这些状态中没有搜索过并且不在 deadends 中的状态全部加入到队列中，
 * 并继续进行搜索。注意 0000 本身有可能也在 deadends 中。
 *
 * @author ay
 * @create 2020-05-23 16:08
 */
public class L752 {
    public static int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d: deadends) {
            dead.add(d);
        }
        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        queue.offer(null);
        //标记是否访问过
        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                depth++;
                if (queue.peek() != null) {
                    queue.offer(null);
                }
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)) {
                //一个节点八个邻居
                for (int i = 0; i < 4; ++i) {
                    for (int d = -1; d <= 1; d += 2) {
                        //可以实现'0'-'1'=='9'
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        //将y拼接回去
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","9888","8788","8988","7988","7898","7889"};
        String targer = "8888";
        int i = openLock(deadends, targer);
        System.out.println(i);
    }
}
