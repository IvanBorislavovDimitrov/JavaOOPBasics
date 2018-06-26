import java.text.DecimalFormat;

public class Archangel extends Base {

    private int mana;

    protected Archangel(String username, int mana, int level) {
        super(username, level);
        this.mana = mana;
        this.setHashedPassword();
    }

    public int getMana() {
        return this.mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setHashedPassword() {
        StringBuilder sb = new StringBuilder(this.getUsername()).reverse();
        sb.append(this.getUsername().length() * 21);
        super.setHashedPassword(sb.toString());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return String.format("\"%s\" | \"%s\" -> %s\n%d", this.getUsername(), this.getHashedPassword(), this.getClass().getSimpleName(),
                (this.getMana() * this.getLevel()));
    }
}
