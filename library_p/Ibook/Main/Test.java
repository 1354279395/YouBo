package early_project.library_p.Ibook.Main;
import early_project.library_p.Ibook.impl.Admin;
import early_project.library_p.Ibook.impl.User;
import early_project.library_p.Ibook.uitl.Book;
import early_project.library_p.Ibook.uitl.Person;

import java.util.*;

public class Test {
    public static int count=3;
    static final int size=10;
    public static Book[] booklist= new Book[size];


    public static void main(String[] args) {
        booklist[0]=new Book("c语言","w芋头",1,15.5);
        booklist[1]=new Book("java","y小轩",2,18.0);
        booklist[2]=new Book("mysql","t晓博",3,14.7);

        while(true) {
            System.out.println();
            System.out.println("------------youbo图书管理系统------------\n");
            System.out.print("请登录：1：普通用户   2：管理员登录\n\n");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            Person p = null;
            switch(choose){
                case 1:
                    System.out.print("请输入：姓名 \n");
                    String usrname = scan.next();
                    System.out.print("请输入：性别 \n");
                    String usrsex = scan.next();
                    System.out.print("请输入：年龄 \n");
                    int usrage = scan.nextInt();

                    p = new User(usrname,usrsex,usrage);
                    System.out.println("当前用户："+usrname+" "+usrsex+" "+usrage);
                    ((User) p).userChoose();
                    break;
                case 2:
                    System.out.print("请输入：姓名 \n");
                    String adminname = scan.next();
                    System.out.print("请输入：性别 \n");
                    String adminsex = scan.next();
                    System.out.print("请输入：年龄 \n");
                    int adminage = scan.nextInt();
                    System.out.println("当前管理员："+adminname+" "+adminsex+" "+adminage);
                    p = new Admin(adminname,adminsex,adminage);
                    ((Admin) p).adminChoose();
                    break;
                default:System.out.println("输入异常,请重新输入\n");break;
            }
        }

    }
}
