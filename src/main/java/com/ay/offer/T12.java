package com.ay.offer;
/**
 * @author ay
 * @create 2020-02-27 9:28
 * 回溯
 * 回溯法（探索与回溯法）是一种选优搜索法，又称为试探法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，
 * 就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为“回溯点”。
 * 其实我总结起来就3点：
 * 1 出口。一个递归算法一定要有出口，否则就是一个死循环了。出口语句一般都挺好写的，但 是出口语句该放在哪儿了，这个就是关键了，
 * 这儿容许我先卖个关子。
 * 2 递归函数的参数。一般情况下，递归函数是要带参数的，因为递归操作都是用来处理下一次的过程，如果没有参数的话，
 * 那么就很难从下一次的操作回溯到当前操作了。这么说，可能会有点迷糊，别急，后面我会举例子，这儿还是卖个关子。
 * 3 递归函数的处理过程。这个自不必多说，重中之重，需要好好理解其过程
 * 上面3点就是我总结的关于回溯法的关键点了，我觉得只要真正的把这3步吃透，一般的回溯法题目是ok的（这可不是我吹牛哈）
 * 下面我就这3点仔细讲讲，大家可要竖起耳朵通清楚了哈。
 * <p>
 * 1 出口
 * <p>
 * 关于这个出口条件，就像我上面说的，它的关键是出口语句放置的位置，因为这个语句其实挺好写的，一般也就2-3行代码，
 * 大多数人都能想出来。但我觉得大多数人苦恼的就是不知道该把它放在哪儿，我刚开始也是这样，后面总结了2-3题之后，
 * 我发现了一个万能规律，就是把出口语句放在递归函数的第一行就行，大家可以看看八皇后问题的递归函数back()
 * 以及迷宫问题的递归函数back()，我这儿就直接贴出来。
 * <p>
 * 基本思想：
 * 0.根据给定数组，初始化一个标志位数组，初始化为false，表示未走过，true表示已经走过，不能走第二次
 * 1.根据行数和列数，遍历数组，先找到一个与str字符串的第一个元素相匹配的矩阵元素，进入judge
 * 2.根据i和j先确定一维数组的位置，因为给定的matrix是一个一维数组
 * 3.确定递归终止条件：越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的，这三类情况，都直接false，说明这条路不通
 * 4.若k，就是待判定的字符串str的索引已经判断到了最后一位，此时说明是匹配成功的
 * 5.下面就是本题的精髓，递归不断地寻找周围四个格子是否符合条件，只要有一个格子符合条件，就继续再找这个符合条件的格子的四周是否存在符合条件的格子，直到k到达末尾或者不满足递归条件就停止。
 * 6.走到这一步，说明本次是不成功的，我们要还原一下标志位数组index处的标志位，进入下一轮的判断。
 */
public class T12 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        //标志位，初始化为false
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //循环遍历二维数组，找到起点等于str第一个元素的值，再递归判断四周是否有符合条件的----回溯法
                if (judge(matrix, i, j, rows, cols, flag, str, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * judge(初始矩阵，索引行坐标i，索引纵坐标j，矩阵行数，矩阵列数，待判断的字符串，字符串索引初始为0即先判断字符串的第一位)
     *
     * @param matrix 初始矩阵
     * @param i 索引行坐标i
     * @param j 索引纵坐标j
     * @param rows 矩阵行数
     * @param cols 矩阵列数
     * @param flag 标志位
     * @param str 待判断的字符串
     * @param k 字符串索引初始为0即先判断字符串的第一位
     * @return
     */
    private boolean judge(char[] matrix, int i, int j, int rows, int cols, boolean[] flag, char[] str, int k) {
        //先根据i和j计算匹配的第一个元素转为一维数组的位置
        int index = i * cols + j;
        //递归终止条件:越界，当前找到的矩阵值不等于数组对应位置的值，已经走过的
        if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[index] != str[k] || flag[index]) {
            return false;
        }
        //若k已经到达str末尾了，说明之前的都已经匹配成功了，直接返回true即可
        if (k == str.length - 1) {
            return true;
        }
        //要走的第一个位置置为true，表示已经走过了
        flag[index] = true;

        //回溯，递归寻找，每次找到了就给k加一，找不到，还原
        if (judge(matrix, i - 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i + 1, j, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j - 1, rows, cols, flag, str, k + 1) ||
                judge(matrix, i, j + 1, rows, cols, flag, str, k + 1)) {
            return true;
        }
        //走到这，说明这一条路不通，还原，再试其他的路径
        flag[index] = false;
        return false;
    }
}





















