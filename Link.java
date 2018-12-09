 class Link {

     class Entry{
         int data;
         Entry next;

         public Entry(){
             this.data=-1;
             this.next=null;
         }
         public Entry(int val){
             this.data=val;
             this.next=null;
         }
     }
     private Entry head;

     public Entry getHead() {
         return head;
     }


     public Link(){
         this.head=new Entry();
     }
     //头插
     public void insertHead(int val){
         Entry cur=new Entry(val);
         cur.next=this.head.next;
         this.head.next=cur;
     }
     //尾插
     public void insertTail(int val){
         Entry cur=new Entry(val);
         Entry entry=this.head;
         while (entry.next!=null){
             entry=entry.next;
         }
         entry.next=cur;
     }
     //任意位置插入
     public void insertPos(int val,int pos) {
         int count=0;
         Entry cur=new Entry(val);
         Entry entry=this.head;
         while (entry.next != null) {
             count++;
             if (count == pos) {
                 cur.next=entry.next;
                 entry.next=cur;
                 break;
             }
             entry=entry.next;
         }
     }
     //删除单链表中所有值为val的值； O（n）的时间
     public void delectVal(int val){
         Entry entry=this.head;
         while (entry.next!=null){
             if (entry.next.data==val){
                 entry.next=entry.next.next;
             }else{
                 entry=entry.next;
             }
         }
     }

     
     //得到表长度
     public int getLength(){
         int count=0;
         Entry entry=this.head.next;
         while (entry!=null){
             count++;
             entry=entry.next;
         }
         return count;
     }
      //打印
    public void show(){
         Entry entry=this.head.next;
         while (entry!=null){
             System.out.print(entry.data+" ");
             entry=entry.next;
         }
        System.out.println();
    }

    public int finK(int k){
         int length=getLength();
         Entry cur1=this.head;
         Entry cur2=this.head;
         if (k<=0||k>length){
             return -99;
         }else {
             for (int i=0; i <k-1 ; i++) {
                 cur1=cur1.next;
             }
             while (cur1.next!=null){
                 cur1=cur1.next;
                 cur2=cur2.next;
             }
             return cur2.data;
         }
    }
    //求环的入口点：
    public int enterEntry(){
             Entry fast= this.head;
             Entry slow= this.head;
             while (fast!=null&&fast.next!=null) {
                 fast=fast.next.next;
                 slow=slow.next;
                 if (fast==slow){
                  break;
                 }
             }
             slow=this.head;
             while (fast!=slow){
                 slow=slow.next;
                 fast=fast.next;
             }
        return slow.data;
    }

    //求环的长度：
    public int enterEntryLength(){
        Entry fast= this.head;
        Entry slow= this.head;
        boolean flg=false;
        int count=0;
        while (fast!=null&&fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                if (flg==true){ break; }
                else { flg=true; }
            }
            if (flg==true){
                count++;
            }
        }
       return count;
    }
    //删除倒数第K节点
     public void delectFinK(int k){
         int length=getLength();
         Entry cur1=this.head;
         Entry cur2=this.head;
         if (k<=0||k>length){
             throw new UnsupportedOperationException("不合法");
         }else {
             for (int i=0; i <k ; i++) {
                 cur1=cur1.next;
             }
             while (cur1.next!=null){
                 cur1=cur1.next;
                 cur2=cur2.next;
             }
             Entry del=cur2.next;
             cur2=del.next;
         }
     }
     //判断是否有环
     public  boolean isLoop(){
         Entry fast= this.head;
         Entry slow= this.head;
         while (fast!=null&&fast.next!=null){
             fast=fast.next.next;
             slow=slow.next;
             if (fast==slow){
                 return true;
             }
         }
         return  false;
     }
 //单链表的逆置？(使用头插法逆置)
     public void reverseLinkInsertHead(){
         Entry cur1=this.head.next;
         Entry cur2=cur1.next;
         while (cur2!=null){
             cur1.next=cur2.next;
            Entry cur=cur2;
            cur.next=this.head.next;
           this.head.next=cur;
           cur2=cur1.next;
         }
     }
     //反转
     public Entry reversion(){
         Entry entry=null;
         Entry prev=null;
         Entry cur=this.head;
         Entry curNext=cur.next;
         while (curNext!=null){
             cur.next=prev;
             prev=cur;
             cur=curNext;
            curNext=curNext.next;
         }
         if (curNext==null){
             entry=cur;
         }
         return entry;
     }

   public boolean delectEntey(Entry entryStart,Entry entryDelete){
         if (entryDelete.next==null){
             if (this.head.next==entryDelete){
                 this.head.next=null;
                 return true;
             }else {
                 Entry entry=this.head;
                 while (entry.next!=null){
                     entry=entry.next;
                     if (entry.next==entryDelete){
                         entry.next=null;
                         return true;
                     }
                 }
             }
         }else {
             entryDelete.data=entryDelete.next.data;
             entryDelete.next=entryDelete.next.next;
             entryDelete.next.next=null;
             return true;
         }
         return false;
   }
 }