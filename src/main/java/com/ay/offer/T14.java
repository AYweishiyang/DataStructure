package com.ay.offer;

/**
 * @author ay
 * @create 2020-02-27 11:32
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），至少剪一次+
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class T14 {


    /**
     * 动态规划
     * https://www.zhihu.com/question/39948290
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target ==3){
            return 2;
        }
        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        //不用剪的情况下 target=2 最大乘积就是2
        products[2] = 2;
        //不用剪的情况下 target=3 最大乘积就是3
        products[3] = 3;

        int max = 0;
        //按顺序从小往大算
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                //状态转移方程 当前的最大乘积等于max(f(j)*f(i-j))
                max = Math.max(max,products[j]*products[i-j]);
            }
            //缓存结果
            products[i] = max;
        }
        return products[target];
    }


    /**
     * 贪婪算法
     * @param target
     * @return
     */
    public int cutRope2(int target) {
        if(target < 2){
            return 0;
        }
        if(target == 2){
            return 1;
        }
        if(target ==3){
            return 2;
        }
        int timesOf3 = target / 3;
        if(target%3 == 1){
            timesOf3 --;
        }
        //因为题目要求至少剪一次，所以当target==4时要处理
        int timesOf2 = (target - timesOf3*3) / 2;
       return (int) (Math.pow(3,timesOf3) * (int)Math.pow(2,timesOf2));
    }

    public static void main(String[] args) {
        T14 t14 = new T14();
        int i = t14.cutRope(5);
        System.out.println(i);
    }
}
