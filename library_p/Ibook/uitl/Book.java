package early_project.library_p.Ibook.uitl;

public class Book {
    private String name;
    private int bianhao;
    private double price;
    private String writor;
    private String condition="Щадк";

    public Book(String name, String writor,int bianhao, double price) {
        this.name = name;
        this.writor=writor;
        this.bianhao = bianhao;
        this.price = price;
    }

    public String getWritor() { return writor; }

    public String getName() {
        return name;
    }

    public int getBianhao() {
        return bianhao;
    }

    public double getPrice() {
        return price;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
