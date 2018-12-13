package early_project.library_p.Ibook.impl;


import early_project.library_p.Ibook.InterFace.AdminPriv;
import early_project.library_p.Ibook.InterFace.Common;
import early_project.library_p.Ibook.uitl.Book;
import early_project.library_p.Ibook.uitl.Person;
import early_project.library_p.Ibook.Main.Test;

import java.util.*;

public  class Admin extends Person implements AdminPriv,Common {//Comparable<Book>
   Test test;
//    Book[] books;//定义这个books主要用于排序函数
    Scanner scan = new Scanner(System.in);
    public Admin(String name, String sex, int age) {
        super(name, sex, age);
    }

 // Admin的主界面函数adminChoose()；
    public void adminChoose(){
        while (true){
            System.out.println("---------------------------Admin管理员页面---------------------------\n");
            System.out.print("请选择：1：添加书籍   2：查询书籍   3：整理书籍   4.删除书籍\n\n");
            System.out.print("        5.打印书籍列表  6.退出\n\n");
            if(test.count==0){ //如果存书的数组为空，则提醒管理员先添加书籍
                System.out.println("此时书籍为0本，请管理员先选择1：添加书籍");
            }

            int choose = scan.nextInt();
            switch(choose) {
                case 1:insert();break;
                case 2:select();break;
                case 3:arrange();break;
                case 4:delect();break;
                case 5:printing();break;
                case 6:break;
                default:System.out.println("输入异常,请重新输入\n");break;
            }
            if(choose==6) {
                break;   //当选择退出时，让它退出到选择用户界面
            }
        }
    }

/* 排序函数 */
    @Override
    public void arrange() {
        Book[] books=new Book[test.count];
        System.arraycopy(test.booklist,0,books,0,test.count);
        //booklist数组一直都是10，后面没有存满的数据无法用compare排序，
        // 所以将目前已存入的书籍用books保存，将books排序；
       Arrays.sort(books, new Comparator<Book>() {
           @Override
           public int compare(Book o1, Book o2) {
//               return o1.getName().compareTo(o2.getName());//姓名排序
               //return (int)(o1.getBianhao()-(o2.getBianhao())); //编号排序
               return (int)(o1.getPrice()-(o2.getPrice()));  //价格排序
               //return o1.getWritor().compareTo(o2.getWritor()); //作者排序
           }
       });
       /* 显示整理的结果*/
       for(int i=0;i<books.length;i++){
           System.out.println("《"+books[i].getName()+"》作者："+books[i].getWritor()+" 编号："
                   +books[i].getBianhao()+" 价格："+books[i].getPrice()+" 状态为:"
                   +books[i].getCondition());
        }
        System.arraycopy(books,0,test.booklist,0,test.count);
    }

     /*  添加书籍的函数*/
    @Override
    public void insert() {   /*   添加书籍的函数*/
           //用这个for循环去添加的话，从当前count开始，最多只能添加到数组满（10本书）
        for(int i=test.count;i<test.booklist.length;i++) { //一定要从count开始添加，如果从i起始值为0.那如果退出本次添加，
             // 在进行下一次添加时，它又从开始添加，把上次添加的会覆盖掉；
            System.out.print("请输入：书籍名字 \n");
            String bookname = scan.next();
            System.out.print("请输入：书籍作者 \n");
            String bookwritor = scan.next();
            System.out.print("请输入：编号 \n");
            int bookbianhao = scan.nextInt();
            System.out.print("请输入：价格 \n");
            double bookprice = scan.nextDouble();

            test.booklist[i]= new Book(bookname, bookwritor,bookbianhao, bookprice);
             // 用了一个从count开始到最大size的循环，每当添加一个就new一个Book，
            test.count++;
            //添加成功，书的总数+1；
            System.out.println("书籍添加成功，目前有： " + test.count +  "本书，是否继续添加：是/否？");
            String a = scan.next();
            if (a.equals("是")) {
                continue;  //如果是，则跳出本次循环，继续添加
            } else if (a.equals("否")) {
                break; //否的话，直接跳出for循环
            } else {
                System.out.println("输入格式错误：系统默认你选择的是继续添加");
            }
        }

    }

    /*删除书籍*/
    @Override
    public void delect() {
        System.out.println("请输入你要删除的书名：");
        String delectBookName = scan.next();
        int index;
        for(int i=0;i<test.count;i++){  //遍历数组 ，寻找匹配的书名字
            if(test.booklist[i].getName().equals(delectBookName)){
                System.out.println("这是你将要删除的书信息：");
                index=i;   //记住这本书在该数组中的下标
                System.out.println("《"+test.booklist[i].getName()+"》作者："+test.booklist[i].getWritor()+" 编号："
                        +test.booklist[i].getBianhao()+" 价格："+test.booklist[i].getPrice()+" 状态为:"
                        +test.booklist[i].getCondition());
                if(test.booklist[i].getCondition().equals("借走")){
                    System.out.println("这本书已经被人借走了，还没有归还，\n" +
                                      " 你最好选择不要删除！！！\n");
                }
                System.out.println("确定删除？是/否");
                String delectYesNo = scan.next();
                if(delectYesNo.equals("是")){
                    //后续的值挨个往前覆盖
                    for(int j=index;j<test.count-1;j++){
                        test.booklist[j]=test.booklist[j+1];
                    }
                    System.out.println("删除成功");
                    test.count--;
                }else{
                    break;
                }
            }
            else{
                if(i==test.count-1){  //如果不等，且都到数组的最后一项了，而且最后一项也不满足，则就没找到
                    System.out.println("没有此书籍！");
                }
            }
        }

    }
  /*   查询函数*/
    @Override
    public void select() {
         System.out.println("请输入你要查找的书名：");
        String selectBookName = scan.next();
        for(int i=0;i<test.count;i++){   //
            if(test.booklist[i].getName().equals(selectBookName)){
                System.out.println("查询结果为：");
                System.out.println("《"+test.booklist[i].getName()+"》作者："+test.booklist[i].getWritor()+" 编号："
                        +test.booklist[i].getBianhao()+" 价格："+test.booklist[i].getPrice()+" 状态为:"
                        +test.booklist[i].getCondition());
                break;
            }else{
                 /* 当从0号下标扫描到最后一个值的时候，如果扫描到了就在上面if中输出，
                 *    如果到最后一个还没扫描到，那就没有这本书*/
                if(i==test.count-1){
                    System.out.println("没有此书籍！");
                }
            }
        }
    }
 /* 打印函数*/
    @Override
    public void printing() {
        for(int i=0;i<test.count;i++){
            System.out.println("《"+test.booklist[i].getName()+"》作者："+test.booklist[i].getWritor()+" 编号："
                    +test.booklist[i].getBianhao()+" 价格："+test.booklist[i].getPrice()+" 状态为:"
                    +test.booklist[i].getCondition());
        }
//        System.out.println("（true:表示尚在，flase表示被借出）");
    }

}
