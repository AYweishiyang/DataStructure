package com.ay.test01;

/**
 * @author ay
 * @create 2019-09-18 16:03
 */
public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showList();
        circleSingleLinkedList.countBoy(1,2,5);
    }
}
class CircleSingleLinkedList{
    private Boy first = new Boy(0);
    public void addBoy(int num){
        if(num<1){
            System.out.println("erro");
        }else{
            Boy cur = null;
            for(int i = 1; i <= num; i++){
                Boy newBoy = new Boy(i);
                if(i == 1){
                    first = newBoy;
                    first.setNext(first);
                    cur = first;
                }else {
                    cur.setNext(newBoy);
                    newBoy.setNext(first);
                    cur = newBoy;
//                    cur = cur.getNext();
                }
            }
        }

    }
    public void showList(){
        Boy cur = first;

        while(cur.getNext() != first){
            System.out.println(cur.getNo() + "---");
            cur = cur.getNext();

        }
        System.out.println(cur.getNo() + "---");

    }
    public void countBoy(int startNo,int countNum,int nums){
        Boy helper = first;
//        while(true){
//            if(helper.getNext() == first){
//                break;
//            }else {
//                helper = helper.getNext();
//            }
//        }
        for(;helper.getNext() != first;helper = helper.getNext()){

        }
        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }


        while(true){

            if(first == helper){
                break;
            }
            for (int i = 0; i < countNum -1 ; i++) {
                first = first.getNext();
                helper = helper.getNext();

            }
            System.out.println(first.getNo() + "--");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println(first.getNo() + "--");



    }
}

class Boy{
    private int no;
    private Boy next = null;
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}