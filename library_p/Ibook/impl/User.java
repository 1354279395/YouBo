package early_project.library_p.Ibook.impl;

import early_project.library_p.Ibook.InterFace.Common;
import early_project.library_p.Ibook.InterFace.UserPriv;
import early_project.library_p.Ibook.uitl.Person;
import early_project.library_p.Ibook.Main.Test;

import java.util.*;

public class User extends Person implements UserPriv,Common {
    Test test;
    Scanner scan = new Scanner(System.in);
    public User(String name, String sex, int age) {
        super(name, sex, age);
    }
    // User的主界面函数userChoose()；
    public void userChoose(){
        while (true){
            System.out.println();
            System.out.println("--------------------User用户页面-------------------------\n");
            System.out.println("请选择：1：查询书籍   2：借阅书籍   3：归还书籍 ");
            System.out.println("        4.打印书籍列表  5.退出\n");

            int choose = scan.nextInt();
            switch(choose) {
                case 1:select();break;
                case 2:borrow();break;
                case 3:revert();break;
                case 4:printing();break;
                case 5:break;
                default:System.out.println("输入异常,请重新输入\n");break;
            }
            if(choose==5){
                break;
            }
        }
    }
    /*借书函数，默认为ture（在），借走的时候，改为flase */
    @Override
    public void borrow(){
        System.out.println("请输入你要借的书名：");
        String borrowBookName = scan.next();
        for(int i=0;i<test.count;i++){
            if(test.booklist[i].getName().equals(borrowBookName)){
                //if(test.booklist[i].getCondition()==true){
                if(test.booklist[i].getCondition().equals("尚在")){
                    System.out.println("这是你将要借的书信息：");
                    System.out.println("《"+test.booklist[i].getName()+"》作者："+test.booklist[i].getWritor()+" 编号："
                            +test.booklist[i].getBianhao()+" 价格："+test.booklist[i].getPrice()+" 状态为:"
                            +test.booklist[i].getCondition());
                    System.out.println("是否要借走？是/否");
                    String delectYesNo = scan.next();
                    if(delectYesNo.equals("是")){
//                        test.booklist[i].setCondition(false);
                        test.booklist[i].setCondition("借走");
                        System.out.println("借走书《"+borrowBookName+"》成功");
                        break;
                    }else{
                        break;
                    }
                }else{
                    System.out.println("该书已被借走");
                    break;
                }
            }else{
                if(i==test.count-1){
                    System.out.println("没有此书籍！");
                }
            }
        }
    }
    /* 还书函数 借走的书的状态为flase，还了之后，为true*/
    @Override
    public void revert(){
        int m=0;
        while (true) {

            for (int i = 0; i < test.count; i++) {
//                if (test.booklist[i].getCondition() == false) {
                if (test.booklist[i].getCondition().equals("借走")) {
                    break;
                } else {
                    if (test.booklist[test.count - 1].getCondition().equals("尚在")) {
                        System.out.println("系统中所有图书都在，无需归还");
                    }
                    m=1;
                    break;
                }
            }
            if(m==1){
                break;
            }
            System.out.print("请输入：书籍名字 \n");
            String revertBookName = scan.next();
            for (int i = 0; i < test.count; i++) {
                if (test.booklist[i].getName().equals(revertBookName)) {
//                    if (test.booklist[i].getCondition() == false) {
                    if (test.booklist[i].getCondition().equals("借走")) {
                        System.out.println("这是你将要归还的书信息：");
                        System.out.println("《"+test.booklist[i].getName()+"》作者："+test.booklist[i].getWritor()+" 编号："
                                +test.booklist[i].getBianhao()+" 价格："+test.booklist[i].getPrice()+" 状态为:"
                                +test.booklist[i].getCondition());
                        System.out.println("是否要归还？是/否");
                        String delectYesNo = scan.next();
                        if (delectYesNo.equals("是")) {
//                            test.booklist[i].setCondition(true);
                            test.booklist[i].setCondition("尚在");
                            System.out.println("归还书《" + revertBookName + "》成功");
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("该书已还");
                        break;
                    }
                } else {
                    if (i == test.count - 1) {
                        System.out.println("书籍系统中没有此书，请检查你输入的书名是否正确！");
                    }
                }
            }
        }
    }

 /*查询函数*/
    @Override
    public void select() {
        System.out.println("请输入你要查找的书名：");
        String selectBookName = scan.next();
        for(int i=0;i<test.count;i++){
            if(test.booklist[i].getName().equals(selectBookName)){
                System.out.println("查询结果为：");
                System.out.println("《"+test.booklist[i].getName()+"》作者："+test.booklist[i].getWritor()+" 编号："
                        +test.booklist[i].getBianhao()+" 价格："+test.booklist[i].getPrice()+" 状态为:"
                        +test.booklist[i].getCondition());
                break;
            }
            else{
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

 /*
    public void borrow1() {
        System.out.println("请输入你要借的书名：");
        String borrowBookName = scan.next();
        int index;
        for(int i=0;i<test.count;i++){
            if(test.booklist[i].getName().equals(borrowBookName)){
                System.out.println("这是你将要借的的书信息：");
                index=i;
                System.out.println(test.booklist[i]);
                System.out.println("是否要借走？是/否");
                String delectYesNo = scan.next();
                if(delectYesNo.equals("是")){
                    for(int j=index;j<test.count-1;j++){
                        test.booklist[j]=test.booklist[j+1];
                    }
                    test.count--;
                }else{
                    break;
                }
            }
            else{
                System.out.println("没有此书籍！");
            }
        }
    }
*/
   /* 归还函数
     和admin中的增加函数一样 */

   /*
    public void revert1() {
        for(int i=0;i<test.booklist.length;i++) {
            System.out.print("请输入：书籍名字 \n");
            String bookname = scan.next();
            System.out.print("请输入：书籍作者 \n");
            String bookwritor = scan.next();
            System.out.print("请输入：编号 \n");
            int bookbianhao = scan.nextInt();
            System.out.print("请输入：价格 \n");
            double bookprice = scan.nextDouble();
            test.booklist[i]= new Book(bookname, bookwritor,bookbianhao, bookprice);

            test.count++;
            System.out.println("书籍归还成功，是否继续归还：是/否？");
            String a = scan.next();
            if (a.equals("是")) {
                continue;
            } else if (a.equals("否")) {
                break;
            } else {
                System.out.println("输入格式错误：系统选择添加");
            }
        }

    }
    */