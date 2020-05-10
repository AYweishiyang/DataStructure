package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-27 10:43
 * 核心思路：
 * 1.从(0,0)开始走，每成功走一步标记当前位置为true,然后从当前位置往四个方向探索，
 * 返回1 + 4 个方向的探索值之和。
 * 2.探索时，判断当前节点是否可达的标准为：
 * 1）当前节点在矩阵内；
 * 2）当前节点未被访问过；
 * 3）当前节点满足limit限制。
 */
public class T13 {
    public int movingCount(int threshold, int rows, int cols)
    {
        //标记是否走过
        boolean[][] visited = new boolean[rows][cols];
        return countingStep(threshold, rows, cols, 0, 0, visited);

    }

    /**
     *
     * @param threshold
     * @param rows
     * @param cols
     * @param r
     * @param c
     * @param visited
     * @return
     */
    private int countingStep(int threshold,int rows,int cols,int r,int c,boolean[][] visited){
        //递归终止条件 ：越界 大于threshold 已经走过
        if(r<0 || c < 0 || r>=rows || c >= cols || bitSum(r) + bitSum(c) > threshold || visited[r][c]){
            return 0;
        }
        visited[r][c] = true;
        //数字1 代表(0,0)这个坐标，
        return countingStep(threshold,rows,cols,r+1,c,visited)+
                countingStep(threshold,rows,cols,r-1,c,visited)+
                countingStep(threshold,rows,cols,r,c+1,visited)+
                countingStep(threshold,rows,cols,r,c-1,visited)
                +1;

    }
    private int bitSum(int num){
        int count = 0;
        while(num > 0){
            //获得最低位
            count += num %10;
            //除以10来去掉最低位
            num = num /10;
        }
        return count;
    }
}
