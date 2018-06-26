import java.text.DecimalFormat;

public abstract class Base {

    private String username;
    private String hashedPassword;
    private int level;

    protected Base(String username, int level) {
        this.username = username;
        this.level = level;
    }

    protected String getUsername() {
        return this.username;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected String getHashedPassword() {
        return this.hashedPassword;
    }

    protected void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    protected int getLevel() {
        return this.level;
    }

    protected void setLevel(int level) {
        this.level = level;
    }


}
