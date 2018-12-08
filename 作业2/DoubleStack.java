package com.src12yue.Test1204.Price2;

class DoubleStack {
    TwoQueue que1=new TwoQueue(10);
    TwoQueue que2=new TwoQueue(10);

    public void pushStack(int val){
        if (que1.isFull()||que2.isFull()){
            return;
        }
        if (que1.isEmtry()){
            que2.push(val);
        }else {
            que1.push(val);
        }
    }
    public int popStack(){
        int result=0;
        if (que1.isEmtry()){
            while (que2.getUseSize()>1){
                int que2val=que2.getpopVal();
                que1.push(que2val);
                que2.pop();
            }
            result=que2.getpopVal();
            que2.pop();
        }else {
            while (que1.getUseSize()>1){
                int que1val=que1.getpopVal();
                que2.push(que1val);
                que1.pop();
            }
            result=que1.getpopVal();
            que1.pop();
        }
        return result;
    }

    public void show(){
            if (que1.isEmtry()){
                que2.Stack_QueueShow();
                return;
            }else {
               que1.Stack_QueueShow();
            }
    }


}
