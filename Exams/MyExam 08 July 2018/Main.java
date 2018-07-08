import app.factories.ComicsFactory;
import app.manager.Manager;
import app.manager.WarManager;
import app.models.api.Arena;
import app.models.api.ComicCharacter;
import app.models.api.SuperPower;
import app.models.imp.ArenaImpl;
import app.models.imp.Power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Manager manager = new WarManager();
        String line;
        while (!"WAR_IS_OVER".equals(line = input.readLine())) {
            String[] info = line.split("\\s+");
            switch (info[0]) {
                case "CHECK_CHARACTER":
                    try {
                        System.out.println(manager.checkComicCharacter(info[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "REGISTER_HERO":
                    try {
                        ComicCharacter hero = ComicsFactory.createComic(info[1], info[2], Integer.parseInt(info[3]),
                                Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
                        System.out.println(manager.addHero(hero));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "REGISTER_ANTI_HERO":
                    try {
                        ComicCharacter hero = ComicsFactory.createComic(info[1], info[2], Integer.parseInt(info[3]),
                                Double.parseDouble(info[4]), Double.parseDouble(info[5]), Double.parseDouble(info[6]));
                        System.out.println(manager.addAntiHero(hero));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "BUILD_ARENA":
                    try {
                        Arena arena = new ArenaImpl(info[1], Integer.parseInt(info[2]));
                        System.out.println(manager.addArena(arena));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "SEND_HERO":
                    try {
                        System.out.println(manager.addHeroToArena(info[1], info[2]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "SEND_ANTI_HERO":
                    try {
                        System.out.println(manager.addAntiHeroToArena(info[1], info[2]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "SUPER_POWER":
                    try {
                        SuperPower superPower = new Power(info[1], Integer.parseInt(info[2]));
                        System.out.println(manager.loadSuperPowerToPool(superPower));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "ASSIGN_POWER":
                    try {
                        System.out.println(manager.assignSuperPowerToComicCharacter(info[1], info[2]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "UNLEASH":
                    try {
                        System.out.println(manager.usePowers(info[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "COMICS_WAR":
                    try {
                        System.out.println(manager.startBattle(info[1]));
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }

        System.out.println(manager.endWar());
    }
}
