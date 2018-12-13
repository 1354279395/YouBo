package early_project.library_p.Ibook.impl;


import early_project.library_p.Ibook.InterFace.AdminPriv;
import early_project.library_p.Ibook.InterFace.Common;
import early_project.library_p.Ibook.uitl.Book;
import early_project.library_p.Ibook.uitl.Person;
import early_project.library_p.Ibook.Main.Test;

import java.util.*;

public  class Admin extends Person implements AdminPriv,Common {//Comparable<Book>
   Test test;
//    Book[] books;//�������books��Ҫ����������
    Scanner scan = new Scanner(System.in);
    public Admin(String name, String sex, int age) {
        super(name, sex, age);
    }

 // Admin�������溯��adminChoose()��
    public void adminChoose(){
        while (true){
            System.out.println("---------------------------Admin����Աҳ��---------------------------\n");
            System.out.print("��ѡ��1������鼮   2����ѯ�鼮   3�������鼮   4.ɾ���鼮\n\n");
            System.out.print("        5.��ӡ�鼮�б�  6.�˳�\n\n");
            if(test.count==0){ //������������Ϊ�գ������ѹ���Ա������鼮
                System.out.println("��ʱ�鼮Ϊ0���������Ա��ѡ��1������鼮");
            }

            int choose = scan.nextInt();
            switch(choose) {
                case 1:insert();break;
                case 2:select();break;
                case 3:arrange();break;
                case 4:delect();break;
                case 5:printing();break;
                case 6:break;
                default:System.out.println("�����쳣,����������\n");break;
            }
            if(choose==6) {
                break;   //��ѡ���˳�ʱ�������˳���ѡ���û�����
            }
        }
    }

/* ������ */
    @Override
    public void arrange() {
        Book[] books=new Book[test.count];
        System.arraycopy(test.booklist,0,books,0,test.count);
        //booklist����һֱ����10������û�д����������޷���compare����
        // ���Խ�Ŀǰ�Ѵ�����鼮��books���棬��books����
       Arrays.sort(books, new Comparator<Book>() {
           @Override
           public int compare(Book o1, Book o2) {
//               return o1.getName().compareTo(o2.getName());//��������
               //return (int)(o1.getBianhao()-(o2.getBianhao())); //�������
               return (int)(o1.getPrice()-(o2.getPrice()));  //�۸�����
               //return o1.getWritor().compareTo(o2.getWritor()); //��������
           }
       });
       /* ��ʾ����Ľ��*/
       for(int i=0;i<books.length;i++){
           System.out.println("��"+books[i].getName()+"�����ߣ�"+books[i].getWritor()+" ��ţ�"
                   +books[i].getBianhao()+" �۸�"+books[i].getPrice()+" ״̬Ϊ:"
                   +books[i].getCondition());
        }
        System.arraycopy(books,0,test.booklist,0,test.count);
    }

     /*  ����鼮�ĺ���*/
    @Override
    public void insert() {   /*   ����鼮�ĺ���*/
           //�����forѭ��ȥ��ӵĻ����ӵ�ǰcount��ʼ�����ֻ����ӵ���������10���飩
        for(int i=test.count;i<test.booklist.length;i++) { //һ��Ҫ��count��ʼ��ӣ������i��ʼֵΪ0.������˳�������ӣ�
             // �ڽ�����һ�����ʱ�����ִӿ�ʼ��ӣ����ϴ���ӵĻḲ�ǵ���
            System.out.print("�����룺�鼮���� \n");
            String bookname = scan.next();
            System.out.print("�����룺�鼮���� \n");
            String bookwritor = scan.next();
            System.out.print("�����룺��� \n");
            int bookbianhao = scan.nextInt();
            System.out.print("�����룺�۸� \n");
            double bookprice = scan.nextDouble();

            test.booklist[i]= new Book(bookname, bookwritor,bookbianhao, bookprice);
             // ����һ����count��ʼ�����size��ѭ����ÿ�����һ����newһ��Book��
            test.count++;
            //��ӳɹ����������+1��
            System.out.println("�鼮��ӳɹ���Ŀǰ�У� " + test.count +  "���飬�Ƿ������ӣ���/��");
            String a = scan.next();
            if (a.equals("��")) {
                continue;  //����ǣ�����������ѭ�����������
            } else if (a.equals("��")) {
                break; //��Ļ���ֱ������forѭ��
            } else {
                System.out.println("�����ʽ����ϵͳĬ����ѡ����Ǽ������");
            }
        }

    }

    /*ɾ���鼮*/
    @Override
    public void delect() {
        System.out.println("��������Ҫɾ����������");
        String delectBookName = scan.next();
        int index;
        for(int i=0;i<test.count;i++){  //�������� ��Ѱ��ƥ���������
            if(test.booklist[i].getName().equals(delectBookName)){
                System.out.println("�����㽫Ҫɾ��������Ϣ��");
                index=i;   //��ס�Ȿ���ڸ������е��±�
                System.out.println("��"+test.booklist[i].getName()+"�����ߣ�"+test.booklist[i].getWritor()+" ��ţ�"
                        +test.booklist[i].getBianhao()+" �۸�"+test.booklist[i].getPrice()+" ״̬Ϊ:"
                        +test.booklist[i].getCondition());
                if(test.booklist[i].getCondition().equals("����")){
                    System.out.println("�Ȿ���Ѿ����˽����ˣ���û�й黹��\n" +
                                      " �����ѡ��Ҫɾ��������\n");
                }
                System.out.println("ȷ��ɾ������/��");
                String delectYesNo = scan.next();
                if(delectYesNo.equals("��")){
                    //������ֵ������ǰ����
                    for(int j=index;j<test.count-1;j++){
                        test.booklist[j]=test.booklist[j+1];
                    }
                    System.out.println("ɾ���ɹ�");
                    test.count--;
                }else{
                    break;
                }
            }
            else{
                if(i==test.count-1){  //������ȣ��Ҷ�����������һ���ˣ��������һ��Ҳ�����㣬���û�ҵ�
                    System.out.println("û�д��鼮��");
                }
            }
        }

    }
  /*   ��ѯ����*/
    @Override
    public void select() {
         System.out.println("��������Ҫ���ҵ�������");
        String selectBookName = scan.next();
        for(int i=0;i<test.count;i++){   //
            if(test.booklist[i].getName().equals(selectBookName)){
                System.out.println("��ѯ���Ϊ��");
                System.out.println("��"+test.booklist[i].getName()+"�����ߣ�"+test.booklist[i].getWritor()+" ��ţ�"
                        +test.booklist[i].getBianhao()+" �۸�"+test.booklist[i].getPrice()+" ״̬Ϊ:"
                        +test.booklist[i].getCondition());
                break;
            }else{
                 /* ����0���±�ɨ�赽���һ��ֵ��ʱ�����ɨ�赽�˾�������if�������
                 *    ��������һ����ûɨ�赽���Ǿ�û���Ȿ��*/
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
