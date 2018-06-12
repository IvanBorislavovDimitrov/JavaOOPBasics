import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        List<Cat> cats = new ArrayList<>();
        String line;
        while (!"End".equals(line = input.readLine())) {
            String[] catInfo = line.split("\\s+");
            String catBreed = catInfo[0];
            String catName = catInfo[1];
            switch (catBreed) {
                case "StreetExtraordinaire":
                    double decibelsOfMeows = Double.parseDouble(catInfo[2]);
                    Cat cat = new StreetExtraordinaire(catName, decibelsOfMeows);
                    cats.add(cat);
                    break;
                case "Siamese":
                    double earSize = Double.parseDouble(catInfo[2]);
                    cat = new Siamese(catName, earSize);
                    cats.add(cat);
                    break;
                case "Cymric":
                    double furLength = Double.parseDouble(catInfo[2]);
                    cat = new Cymric(catName, furLength);
                    cats.add(cat);
                    break;
            }
        }

        String catName = input.readLine();
        System.out.println(cats.stream().filter(c -> c.getName().equals(catName)).findFirst().get());
    }
}