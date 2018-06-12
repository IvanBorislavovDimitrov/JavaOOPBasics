import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String birthDate;
    private List<Person> parents;
    private List<Person> children;

    public Person() {
        this("", "");
    }

    public Person(String name, String birthDate) {
        this(name, birthDate, new ArrayList<>(), new ArrayList<>());
    }

    public Person(String name, String birthDate, List<Person> parents, List<Person> children) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = parents;
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public List<Person> getParents() {
        return parents;
    }

    public void setParents(List<Person> parents) {
        this.parents = parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName()).append(" ").append(this.getBirthDate()).append(System.lineSeparator());
        sb.append("Parents:").append(System.lineSeparator());
        this.getParents().forEach(x -> sb.append(String.format("%s %s", x.getName(), x.getBirthDate())).append(System.lineSeparator()));
        sb.append("Children:").append(System.lineSeparator());
        this.getChildren().forEach(x -> sb.append(String.format("%s %s", x.getName(), x.getBirthDate())).append(System.lineSeparator()));

        return sb.toString();
    }
}
