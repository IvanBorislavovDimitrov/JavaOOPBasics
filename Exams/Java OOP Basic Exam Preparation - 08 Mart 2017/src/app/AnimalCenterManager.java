package app;

import app.animals.Animal;
import app.animals.Cat;
import app.animals.Dog;
import app.centers.AdoptionCenter;
import app.centers.CastrationCenter;
import app.centers.Center;
import app.centers.CleansingCenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnimalCenterManager {

    private Map<String, Center> centers;
    private List<String> adoptedAnimals;
    private List<String> cleansedAnimals;
    private List<String> castratedAnimals;

    public AnimalCenterManager() {
        this.centers = new HashMap<>();
        this.adoptedAnimals = new ArrayList<>();
        this.cleansedAnimals = new ArrayList<>();
        this.castratedAnimals = new ArrayList<>();
    }

    public void registerCleansingCenter(String name) {
        Center center = new CleansingCenter(name);
        this.centers.put(name, center);
    }

    public void registerAdoptionCenter(String name) {
        Center center = new AdoptionCenter(name);
        this.centers.put(name, center);
    }

    public void registerCastrationCenter(String name) {
        Center center = new CastrationCenter(name);
        this.centers.put(name, center);
    }

    public void registerDog(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal animal = new Dog(name, age, adoptionCenterName, learnedCommands);
        this.centers.get(adoptionCenterName).getAnimals().add(animal);
    }

    public void registerCat(String name, int age, int learnedCommands, String adoptionCenterName) {
        Animal animal = new Cat(name, age, adoptionCenterName, learnedCommands);
        this.centers.get(adoptionCenterName).getAnimals().add(animal);
    }

    public void sendForCleansing(String adoptionCenterName, String cleansingCenterName) {
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        Center cleansingCenter = this.centers.get(cleansingCenterName);
        for (int i = adoptionCenter.getAnimals().size() - 1; i >= 0; i--) {
            if (adoptionCenter.getAnimals().get(i).getCleansingStatus().equals("UNCLEANSED")) {
                Animal dirtyAnimal = adoptionCenter.getAnimals().remove(i);
                dirtyAnimal.setCleansingStatus("CLEANSED");
                cleansingCenter.getAnimals().add(dirtyAnimal);
            }
        }
    }

    public void sendForCastration(String adoptionCenterName, String castrationCenterName) {
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        Center castrationCenter = this.centers.get(castrationCenterName);
        for (int i = adoptionCenter.getAnimals().size() - 1; i >= 0; i--) {
            if (!adoptionCenter.getAnimals().get(i).isCastrated()) {
                Animal dirtyAnimal = adoptionCenter.getAnimals().remove(i);
                dirtyAnimal.setCastrated(true);
                castrationCenter.getAnimals().add(dirtyAnimal);
            }
        }
    }

    public void cleanse(String cleansingCenterName) {
        Center cleansingCenter = this.centers.get(cleansingCenterName);
        while (cleansingCenter.getAnimals().size() > 0) {
            Animal animal = cleansingCenter.getAnimals().remove(0);
            this.cleansedAnimals.add(animal.getName());
            Center adoptionCenter = this.centers.get(animal.getAdoptionCenterName());
            adoptionCenter.getAnimals().add(animal);
        }
    }

    public void castrate(String castrationCenterName) {
        Center castrationCenter = this.centers.get(castrationCenterName);
        while (castrationCenter.getAnimals().size() > 0) {
            Animal animal = castrationCenter.getAnimals().remove(0);
            this.castratedAnimals.add(animal.getName());
            Center adoptionCenter = this.centers.get(animal.getAdoptionCenterName());
            adoptionCenter.getAnimals().add(animal);
        }
    }

    public void adopt(String adoptionCenterName) {
        Center adoptionCenter = this.centers.get(adoptionCenterName);
        for (int i = adoptionCenter.getAnimals().size() - 1; i >= 0; i--) {
            if (adoptionCenter.getAnimals().get(i).getCleansingStatus().equals("CLEANSED")) {
                this.adoptedAnimals.add(adoptionCenter.getAnimals().get(i).getName());
                adoptionCenter.getAnimals().remove(i);
            }
        }
    }

    public void printStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Incorporative Regular Statistics").append(System.lineSeparator());
        long adoptionCentersCount = this.centers.values().stream().filter(c -> c instanceof AdoptionCenter).count();
        sb.append(String.format("Adoption Centers: %d", adoptionCentersCount)).append(System.lineSeparator());
        long cleansingCentersCount = this.centers.values().stream().filter(c -> c instanceof CleansingCenter).count();
        sb.append(String.format("Cleansing Centers: %d", cleansingCentersCount)).append(System.lineSeparator());
        this.adoptedAnimals.sort(String::compareTo);
        this.cleansedAnimals.sort(String::compareTo);
        if (this.adoptedAnimals.isEmpty()) {
            this.adoptedAnimals.add("None");
        }
        if (this.cleansedAnimals.isEmpty()) {
            this.cleansedAnimals.add("None");
        }
        sb.append("Adopted Animals: ").append(String.join(", ", this.adoptedAnimals)).append(System.lineSeparator());
        sb.append("Cleansed Animals: ").append(String.join(", ", this.cleansedAnimals)).append(System.lineSeparator());
        long animalsAwaitingAdoption =
                this.centers.values().stream().filter(c -> c instanceof AdoptionCenter)
                        .mapToInt(c -> (int) c.getAnimals().stream()
                                .filter(d -> d.getCleansingStatus().equals("CLEANSED")).count()).sum();
        sb.append(String.format("Animals Awaiting Adoption: %d", animalsAwaitingAdoption)).append(System.lineSeparator());
        long animalsAwaitingCleaning =
                this.centers.values().stream().filter(c -> c instanceof CleansingCenter)
                        .mapToInt(c -> (int) c.getAnimals().stream()
                                .filter(d -> d.getCleansingStatus().equals("CLEANSED")).count()).sum();
        sb.append(String.format("Animals Awaiting Cleansing: %d", animalsAwaitingCleaning)).append(System.lineSeparator());

        System.out.println(sb);
    }

    public void castrationStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paw Inc. Regular Castration Statistics").append(System.lineSeparator());
        long castrationCentersCount = this.centers.values().stream().filter(c -> c instanceof CastrationCenter).count();
        sb.append(String.format("Castration Centers: %d", castrationCentersCount)).append(System.lineSeparator());
        this.castratedAnimals.sort(String::compareTo);
        if (this.castratedAnimals.isEmpty()) {
            this.castratedAnimals.add("None");
        }
        sb.append("Castrated Animals: ").append(String.join(", ", this.castratedAnimals)).append(System.lineSeparator());

        System.out.println(sb.toString().trim());
    }
}
