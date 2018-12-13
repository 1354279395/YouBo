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
    // User�������溯��userChoose()��
    public void userChoose(){
        while (true){
            System.out.println();
            System.out.println("--------------------User�û�ҳ��-------------------------\n");
            System.out.println("��ѡ��1����ѯ�鼮   2�������鼮   3���黹�鼮 ");
            System.out.println("        4.��ӡ�鼮�б�  5.�˳�\n");

            int choose = scan.nextInt();
            switch(choose) {
                case 1:select();break;
                case 2:borrow();break;
                case 3:revert();break;
                case 4:printing();break;
                case 5:break;
                default:System.out.println("�����쳣,����������\n");break;
            }
            if(choose==5){
                break;
            }
        }
    }
    /*���麯����Ĭ��Ϊture���ڣ������ߵ�ʱ�򣬸�Ϊflase */
    @Override
    public void borrow(){
        System.out.println("��������Ҫ���������");
        String borrowBookName = scan.next();
        for(int i=0;i<test.count;i++){
            if(test.booklist[i].getName().equals(borrowBookName)){
                //if(test.booklist[i].getCondition()==true){
                if(test.booklist[i].getCondition().equals("����")){
                    System.out.println("�����㽫Ҫ�������Ϣ��");
                    System.out.println("��"+test.booklist[i].getName()+"�����ߣ�"+test.booklist[i].getWritor()+" ��ţ�"
                            +test.booklist[i].getBianhao()+" �۸�"+test.booklist[i].getPrice()+" ״̬Ϊ:"
                            +test.booklist[i].getCondition());
                    System.out.println("�Ƿ�Ҫ���ߣ���/��");
                    String delectYesNo = scan.next();
                    if(delectYesNo.equals("��")){
//                        test.booklist[i].setCondition(false);
                        test.booklist[i].setCondition("����");
                        System.out.println("�����顶"+borrowBookName+"���ɹ�");
                        break;
                    }else{
                        break;
                    }
                }else{
                    System.out.println("�����ѱ�����");
                    break;
                }
            }else{
                if(i==test.count-1){
                    System.out.println("û�д��鼮��");
                }
            }
        }
    }
    /* ���麯�� ���ߵ����״̬Ϊflase������֮��Ϊtrue*/
    @Override
    public void revert(){
        int m=0;
        while (true) {

            for (int i = 0; i < test.count; i++) {
//                if (test.booklist[i].getCondition() == false) {
                if (test.booklist[i].getCondition().equals("����")) {
                    break;
                } else {
                    if (test.booklist[test.count - 1].getCondition().equals("����")) {
                        System.out.println("ϵͳ������ͼ�鶼�ڣ�����黹");
                    }
                    m=1;
                    break;
                }
            }
            if(m==1){
                break;
            }
            System.out.print("�����룺�鼮���� \n");
            String revertBookName = scan.next();
            for (int i = 0; i < test.count; i++) {
                if (test.booklist[i].getName().equals(revertBookName)) {
//                    if (test.booklist[i].getCondition() == false) {
                    if (test.booklist[i].getCondition().equals("����")) {
                        System.out.println("�����㽫Ҫ�黹������Ϣ��");
                        System.out.println("��"+test.booklist[i].getName()+"�����ߣ�"+test.booklist[i].getWritor()+" ��ţ�"
                                +test.booklist[i].getBianhao()+" �۸�"+test.booklist[i].getPrice()+" ״̬Ϊ:"
                                +test.booklist[i].getCondition());
                        System.out.println("�Ƿ�Ҫ�黹����/��");
                        String delectYesNo = scan.next();
                        if (delectYesNo.equals("��")) {
//                            test.booklist[i].setCondition(true);
                            test.booklist[i].setCondition("����");
                            System.out.println("�黹�顶" + revertBookName + "���ɹ�");
                            break;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("�����ѻ�");
                        break;
                    }
                } else {
                    if (i == test.count - 1) {
                        System.out.println("�鼮ϵͳ��û�д��飬����������������Ƿ���ȷ��");
                    }
                }
            }
        }
    }

 /*��ѯ����*/
    @Override
    public void select() {
        System.out.println("��������Ҫ���ҵ�������");
        String selectBookName = scan.next();
        for(int i=0;i<test.count;i++){
            if(test.booklist[i].getName().equals(selectBookName)){
                System.out.println("��ѯ���Ϊ��");
                System.out.println("��"+test.booklist[i].getName()+"�����ߣ�"+test.booklist[i].getWritor()+" ��ţ�"
                        +test.booklist[i].getBianhao()+" �۸�"+test.booklist[i].getPrice()+" ״̬Ϊ:"
                        +test.booklist[i].getCondition());
                break;
            }
            else{
                if(i==test.count-1){
                    System.out.println("û�д��鼮��");
                }
            }
        }
    }
 /* ��ӡ����*/
    @Override
    public void printing() {
        for(int i=0;i<test.count;i++){
            System.out.println("��"+test.booklist[i].getName()+"�����ߣ�"+test.booklist[i].getWritor()+" ��ţ�"
                    +test.booklist[i].getBianhao()+" �۸�"+test.booklist[i].getPrice()+" ״̬Ϊ:"
                    +test.booklist[i].getCondition());
        }
//        System.out.println("��true:��ʾ���ڣ�flase��ʾ�������");
    }
}

 /*
    public void borrow1() {
        System.out.println("��������Ҫ���������");
        String borrowBookName = scan.next();
        int index;
        for(int i=0;i<test.count;i++){
            if(test.booklist[i].getName().equals(borrowBookName)){
                System.out.println("�����㽫Ҫ��ĵ�����Ϣ��");
                index=i;
                System.out.println(test.booklist[i]);
                System.out.println("�Ƿ�Ҫ���ߣ���/��");
                String delectYesNo = scan.next();
                if(delectYesNo.equals("��")){
                    for(int j=index;j<test.count-1;j++){
                        test.booklist[j]=test.booklist[j+1];
                    }
                    test.count--;
                }else{
                    break;
                }
            }
            else{
                System.out.println("û�д��鼮��");
            }
        }
    }
*/
   /* �黹����
     ��admin�е����Ӻ���һ�� */

   /*
    public void revert1() {
        for(int i=0;i<test.booklist.length;i++) {
            System.out.print("�����룺�鼮���� \n");
            String bookname = scan.next();
            System.out.print("�����룺�鼮���� \n");
            String bookwritor = scan.next();
            System.out.print("�����룺��� \n");
            int bookbianhao = scan.nextInt();
            System.out.print("�����룺�۸� \n");
            double bookprice = scan.nextDouble();
            test.booklist[i]= new Book(bookname, bookwritor,bookbianhao, bookprice);

            test.count++;
            System.out.println("�鼮�黹�ɹ����Ƿ�����黹����/��");
            String a = scan.next();
            if (a.equals("��")) {
                continue;
            } else if (a.equals("��")) {
                break;
            } else {
                System.out.println("�����ʽ����ϵͳѡ�����");
            }
        }

    }
    */