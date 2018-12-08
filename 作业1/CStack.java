package com.src12yue.Test1204.price;

 class CStack {
     private int top;
     private int[] elem;


     public CStack(){
         this(10);
     }
     public CStack(int size) {
         this.top=0;
         this.elem=new int[size];
     }
     public boolean isFull(){
         if (top==10){
             return true;
         }
         return false;
     }
     public boolean isEmpty(){
         if (top==0){
             return true;
         }
         return false;
     }
     //入栈
     public void push(int val){
         if (isFull()){
             return;
         }
         this.elem[this.top++] = val;

     }
     //出栈
     public void pop(){
         if (isEmpty()){
             return;
         }
         --this.top;
     }
     //得到栈顶元素
     public int getStackTop(){
         if(isEmpty()) {
             return -1;
         }
         return this.elem[top-1];
     }
     //打印
     public void show() {
         for (int i = 0; i < this.top; i++) {
             System.out.print(this.elem[i]+" ");
         }
         System.out.println();
     }

     public int getTop() {
         return this.top;
     }
 }
