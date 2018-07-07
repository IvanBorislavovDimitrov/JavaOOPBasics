package app.animals;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {

    private String name;
    private int age;
    private String cleansingStatus;
    private String adoptionCenterName;
    private boolean isCastrated;

    public Animal(String name, int age, String adoptionCenterName) {
        this.name = name;
        this.age = age;
        this.adoptionCenterName = adoptionCenterName;
        this.cleansingStatus = "UNCLEANSED";
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCleansingStatus() {
        return this.cleansingStatus;
    }

    public void setCleansingStatus(String cleansingStatus) {
        this.cleansingStatus = cleansingStatus;
    }

    public String getAdoptionCenterName() {
        return this.adoptionCenterName;
    }

    public void setAdoptionCenterName(String adoptionCenterName) {
        this.adoptionCenterName = adoptionCenterName;
    }

    public boolean isCastrated() {
        return this.isCastrated;
    }

    public void setCastrated(boolean castrated) {
        isCastrated = castrated;
    }
}
