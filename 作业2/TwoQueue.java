package com.src12yue.Test1204.Price2;

 class TwoQueue {
     private int front;
     private int rear;
     private int[] elem;
     private  int useSize=0;
     private  int allSize;

     public TwoQueue(int size){
         this.front=0;
         this.rear=0;
         this.elem=new int[size];
         this.allSize=size;
     }
       //空
     public boolean isEmtry(){
         if (this.rear==this.front){
             return true;
         }
         return false;
     }
     // 满
     public boolean isFull(){
         if ((rear+1)%allSize==this.front){
             return true;
         }
         return false;
     }
      //入队
     public void push(int val){
         if (isFull()){
             throw  new UnsupportedOperationException("满");
         }
         this.elem[this.rear]=val;
         this.rear=(this.rear+1)%allSize;
         useSize++;
     }
      //出队
     public void pop(){
         if (isEmtry()){
             throw  new UnsupportedOperationException("kong");
         }
         this.front=(this.front+1)%allSize;
         useSize--;
     }
     //得到将要出队的元素
     public int getpopVal(){
         return this.elem[this.front];
     }
     //打印
     public void show (){
         int a=this.front;
         while (a!=rear){
             System.out.print(this.elem[a]+" ");
             a=(a+1)%allSize;
         }
         System.out.println();
     }
	 
	 //专门为实现的栈写的打印
     public void Stack_QueueShow(){
         int a=this.rear-1;
         if (a==-1){
             a=allSize-1;
         }
         while (a!=front){
             System.out.print(this.elem[a]+" ");
             if (a==0){
                 a=allSize;
             }
             a=a-1;
         }
         System.out.print(this.elem[front]+" ");
         System.out.println();
     }

     public int getUseSize() {
         return useSize;
     }

 }
