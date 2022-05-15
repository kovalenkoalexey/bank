import java.util.Objects;

public class Client {
    private String name;
    private int age;
    Client(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public boolean equals (Object obj) {
        if (obj==null) return false;
        if (this==obj) return true;
        if (this.getClass()!=obj.getClass()) return false;
        Client client=(Client)obj;
        return this.name==client.name&&this.age==client.age;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.age);
    }
}
