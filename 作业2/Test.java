package com.src12yue.Test1204.Price2;

public class Test {
    public static void main(String[] args) {
        DoubleStack stack=new DoubleStack();
        for (int i=1; i <8 ; i++) {
            stack.pushStack(i);
        }
        stack.show();
        System.out.println(stack.popStack());
        System.out.println(stack.popStack());
        System.out.println(stack.popStack());
        stack.pushStack(10);
        stack.pushStack(15);
        stack.pushStack(18);
        stack.show();
    }

}
