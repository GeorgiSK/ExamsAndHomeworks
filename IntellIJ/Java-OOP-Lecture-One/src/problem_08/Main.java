package problem_08;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Trainer> trainers = new ArrayList<>();

        String input;

        while (!(input = reader.readLine()).equals("Tournament")) {
            String[] line = input.trim().split(" ");
            //Create a new trainer and add it to the list
            Trainer current = new Trainer(line[0]);
            boolean exists = false;

            for (Trainer trainer : trainers) {
                //If the trainer already exists, remove the new one from the list and set it to the existing one
                if (trainer.name.equals(line[0])) {
                    current = trainer;
                    exists = true;
                }
            }

            //add his pokemon to the list
            current.pokemonCollection.add(new Pokemon(line[1], line[2], Integer.parseInt(line[3])));
            if (!exists) {
                trainers.add(current);
            }
        }

        while (!(input = reader.readLine()).equals("End")) {
            for (Trainer trainer : trainers) {
                trainer.handleAttack(input);
            }
        }

        trainers.sort((a, b) -> b.numOfBadges - a.numOfBadges);

        trainers.stream().forEach( e -> System.out.println(e.toString()));
    }
}

class Trainer {
    String name;
    Integer numOfBadges;
    List<Pokemon> pokemonCollection;
    List<Pokemon> deadPokemons = new ArrayList<>();

    public Trainer(String name) {
        this.name = name;
        this.pokemonCollection = new ArrayList<>();
        this.numOfBadges = 0;
    }

    public void handleAttack(String element) {
        if (pokemonCollection.stream().filter(e -> e.element.equals(element)).findFirst().isPresent()) {
            numOfBadges++;
        }else {
            pokemonCollection.stream().forEach(e -> {
                e.health -= 10;
                if (e.health <= 0) {
                    deadPokemons.add(e);
                }
            });
        }

        for (Pokemon deadPokemon : deadPokemons) {
            pokemonCollection.remove(deadPokemon);
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.numOfBadges + " " + this.pokemonCollection.size();
    }
}

class Pokemon {
    String name;
    String element;
    Integer health;

    public Pokemon(String name, String element, Integer health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }
}
