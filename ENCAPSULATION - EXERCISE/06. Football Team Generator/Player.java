public class Player {

    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    private static final double MINIMAL_SKILL_LEVEL = 0;
    private static final double MAXIMAL_SKILL_LEVEL = 100;
    private static final String ILLEGAL_NAME_MESSAGE = "A name should not be empty.";
    private static final String ILLEGAL_STAT_MESSAGE = "%s should be between 0 and 100.";

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException(ILLEGAL_NAME_MESSAGE);
        }
        this.name = name;
    }

    private void setEndurance(int endurance) {
        if (endurance < MINIMAL_SKILL_LEVEL || endurance > MAXIMAL_SKILL_LEVEL) {
            throw new IllegalArgumentException(String.format(ILLEGAL_STAT_MESSAGE, "Endurance"));
        }

        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        if (sprint < MINIMAL_SKILL_LEVEL || sprint > MAXIMAL_SKILL_LEVEL) {
            throw new IllegalArgumentException(String.format(ILLEGAL_STAT_MESSAGE, "Sprint"));
        }

        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        if (dribble < MINIMAL_SKILL_LEVEL || dribble > MAXIMAL_SKILL_LEVEL) {
            throw new IllegalArgumentException(String.format(ILLEGAL_STAT_MESSAGE, "Dribble"));
        }

        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        if (passing < MINIMAL_SKILL_LEVEL || passing > MAXIMAL_SKILL_LEVEL) {
            throw new IllegalArgumentException(String.format(ILLEGAL_STAT_MESSAGE, "Passing"));
        }

        this.passing = passing;
    }

    private void setShooting(int shooting) {
        if (shooting < MINIMAL_SKILL_LEVEL || shooting > MAXIMAL_SKILL_LEVEL) {
            throw new IllegalArgumentException(String.format(ILLEGAL_STAT_MESSAGE, "Shooting"));
        }

        this.shooting = shooting;
    }

    double averageSkills() {
        return ((this.endurance + this.sprint + this.dribble + this.passing + this.shooting) / 5.0);
    }
}
