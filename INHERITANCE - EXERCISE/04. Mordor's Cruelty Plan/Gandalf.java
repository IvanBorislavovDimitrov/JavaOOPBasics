public class Gandalf {

    private int points;

    public Gandalf() {
    }

    public void eat(String food) {
        switch (food.toLowerCase()) {
            case "cram":
                this.points += 2;
                break;
            case "lembas":
                this.points += 3;
                break;
            case "apple":
                this.points += 1;
                break;
            case "melon":
                this.points += 1;
                break;
            case "honeycake":
                this.points += 5;
                break;
            case "mushrooms":
                this.points -= 10;
                break;
            default:
                this.points -= 1;
        }
    }

    public void eatAll(String[] food) {
        for (String s : food) {
            this.eat(s);
        }
    }

    public String mood() {
        if (this.points < -5) {
            return "Angry";
        }
        if (this.points < 0) {
            return "Sad";
        }
        if (this.points < 15) {
            return "Happy";
        }

        return "JavaScript";
    }

    public int getPoints() {
        return this.points;
    }
}
