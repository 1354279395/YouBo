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
        booklist[0]=new Book("c����","w��ͷ",1,15.5);
        booklist[1]=new Book("java","yС��",2,18.0);
        booklist[2]=new Book("mysql","t����",3,14.7);

        while(true) {
            System.out.println();
            System.out.println("------------youboͼ�����ϵͳ------------\n");
            System.out.print("���¼��1����ͨ�û�   2������Ա��¼\n\n");
            Scanner scan = new Scanner(System.in);
            int choose = scan.nextInt();
            Person p = null;
            switch(choose){
                case 1:
                    System.out.print("�����룺���� \n");
                    String usrname = scan.next();
                    System.out.print("�����룺�Ա� \n");
                    String usrsex = scan.next();
                    System.out.print("�����룺���� \n");
                    int usrage = scan.nextInt();

                    p = new User(usrname,usrsex,usrage);
                    System.out.println("��ǰ�û���"+usrname+" "+usrsex+" "+usrage);
                    ((User) p).userChoose();
                    break;
                case 2:
                    System.out.print("�����룺���� \n");
                    String adminname = scan.next();
                    System.out.print("�����룺�Ա� \n");
                    String adminsex = scan.next();
                    System.out.print("�����룺���� \n");
                    int adminage = scan.nextInt();
                    System.out.println("��ǰ����Ա��"+adminname+" "+adminsex+" "+adminage);
                    p = new Admin(adminname,adminsex,adminage);
                    ((Admin) p).adminChoose();
                    break;
                default:System.out.println("�����쳣,����������\n");break;
            }
        }

    }
}
