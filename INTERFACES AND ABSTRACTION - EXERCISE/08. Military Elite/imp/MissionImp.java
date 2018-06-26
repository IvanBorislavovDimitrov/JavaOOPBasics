package imp;

import interfaces.Mission;

public class MissionImp implements Mission {

    private static final String MISSION_COMPLETED = "Finished";
    private static final String MISSION_IN_PROGRESS = "inProgress";
    private static final String INVALID_MISSION_STATE = "Invalid mission state";

    private String codeName;
    private String state;

    public MissionImp(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        if (!MISSION_COMPLETED.equals(state) && !MISSION_IN_PROGRESS.equals(state)) {
            throw new IllegalArgumentException(INVALID_MISSION_STATE);
        }
        this.state = state;
    }

    public void completeMission() {
        this.state = MISSION_COMPLETED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
