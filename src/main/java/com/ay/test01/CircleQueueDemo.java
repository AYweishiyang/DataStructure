package com.ay.test01;

/**
 * @author ay
 * @create 2019-09-18 11:18
 */
import java.util.Scanner;

public class CircleQueueDemo {
    public static void main(String[] args) {
        boolean loop = true;
        CircleQueue queue = new CircleQueue(4);//说明设置 4, 其队列的有效数据最大是 3
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据为%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据为%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
            System.out.println("程序退出");
        }
    }
}
class CircleQueue{
    private int maxSize;//数组最大容量
    private int front;
    private int rear;
    private int[] arr;
    public CircleQueue(int arrMaxSize) {

        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }
    //判断队列是否为满
    public boolean isFull() {
        return (rear+1)%maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //插入队列
    public void addQueue(int n) {
        //判断队列是否为满
        if(isFull()) {
            System.out.println("队列为满");
            return;
        }
        arr[rear] = n;
        rear = (rear+1)%maxSize;
    }
    //出队列
    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value =  arr[front];
        front = (front+1)%maxSize;
        return value;
    }
    //显示队列所有数据
    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < size(); i++) {
            System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
        }
    }
    public int size() {
        return (rear + maxSize - front)%maxSize;
    }
    //显示队列头
    public int headQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}