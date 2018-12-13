package early_project.library_p.Ibook.uitl;

public class Person {
    private String name;
    private String sex;
    private int age;
    public Person(String name,String sex,int age){
        this.name=name;
        this.sex=sex;
        this.age=age;
    }

       public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}