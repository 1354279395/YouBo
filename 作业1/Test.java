package com.src12yue.Test1204.price;

public class Test {
    public static void main(String[] args) {
     DoubleQueue  queue=new DoubleQueue();
        for (int i=1; i <8 ; i++) {
            queue.pushQueue(i);
        }
       queue.show();

        System.out.println(queue.popQueue());
        System.out.println(queue.popQueue());
        System.out.println(queue.popQueue());
        queue.show();
        queue.pushQueue(10);
        queue.pushQueue(15);
        queue.pushQueue(18);
        queue.show();
    }


}
