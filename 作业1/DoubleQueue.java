package com.src12yue.Test1204.price;

 class DoubleQueue {
     CStack s1= new CStack();
     CStack s2= new CStack();


     public  void pushQueue(int val){
         if (s1.isFull()){
             return;
         }
         if (s2.isEmpty()){
             s1.push(val);
         }
     }
     public  int popQueue(){
         int result=0;
         while (s1.getTop()>1){
             int s1val=s1.getStackTop();
             s2.push(s1val);
             s1.pop();
         }
         result=s1.getStackTop();
         s1.pop();
         while (!s2.isEmpty()){
             int s2val=s2.getStackTop();
             s1.push(s2val);
             s2.pop();
         }
         return result;
     }
     public void show(){
         while (!s1.isEmpty()){
             int s1val=s1.getStackTop();
             s2.push(s1val);
             s1.pop();
         }
         while (!s2.isEmpty()){
             int s2val=s2.getStackTop();
             System.out.print(s2val+" ");
             s1.push(s2val);
             s2.pop();
         }
         System.out.println();
     }
}
