package app.centers;

import app.animals.Animal;

import java.util.ArrayList;
import java.util.List;

public abstract class Center {

    private String name;
    private List<Animal> animals;

    public Center(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return this.animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
