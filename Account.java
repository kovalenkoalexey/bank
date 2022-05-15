import java.util.Objects;

public class Account {
    private final int number;
    Account(int number) {
        this.number=number;
    }
    public int getNumber() {
        return this.number;
    }
    @Override
    public boolean equals (Object obj) {
        if (obj==null) return false;
        if (this==obj) return true;
        if (this.getClass()!=obj.getClass()) return false;
        Account account=(Account)obj;
        return this.number==account.number;
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.number);
    }
}
