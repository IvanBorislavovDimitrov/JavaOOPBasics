
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<BankAccount> bankAccounts;

    public Person(String name, int age) {
        this(name, age, new ArrayList<>());
    }

    public Person(String name, int age, List<BankAccount> bankAccounts) {
        this.name = name;
        this.age = age;
        this.bankAccounts = bankAccounts;
    }

    public double getBalance() {
        return this.getBankAccounts().stream().mapToDouble(BankAccount::getBalance).sum();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }
}
