import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Trainer> trainers = new ArrayList<>();
        String line;
        while (!"Tournament".equals(line = input.readLine())) {
            String[] trainerInfo = line.split("\\s+");
            addTrainer(trainers, trainerInfo);
        }
        while (!"End".equals(line = input.readLine())) {
            String element = line;
            for (Trainer trainer : trainers) {
                if (trainer.getPokemons().stream().anyMatch(p -> p.getElement().equals(element))) {
                    trainer.setNumberOfBadges(trainer.getNumberOfBadges() + 1);
                } else {
                    for (Pokemon pokemon : trainer.getPokemons()) {
                        pokemon.setHealth(pokemon.getHealth() - 10);
                    }
                    trainer.setPokemons(trainer.getPokemons().stream().filter(p -> p.getHealth() > 0).collect(Collectors.toSet()));
                }
            }
        }

        trainers.sort((o1, o2) -> Integer.compare(o2.getNumberOfBadges(), o1.getNumberOfBadges()));
        trainers.forEach(System.out::println);
    }

    private static void addTrainer(List<Trainer> trainers, String[] trainerInfo) {
        String trainerName = trainerInfo[0];
        String pokemonName = trainerInfo[1];
        String pokemonElement = trainerInfo[2];
        int health = Integer.parseInt(trainerInfo[3]);
        Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, health);
        Trainer trainer = trainers.stream().filter(t -> t.getName().equals(trainerName)).findFirst().orElse(null);
        if (trainer != null) {
            trainer.getPokemons().add(pokemon);
        } else {
            trainer = new Trainer(trainerName);
            trainer.getPokemons().add(pokemon);
            trainers.add(trainer);
        }

    }
}
