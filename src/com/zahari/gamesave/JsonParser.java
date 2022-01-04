package com.zahari.gamesave;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.zahari.heroes.Hero;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JsonParser {

    private final Gson gson;
    private List<Hero> heroes;
    private final Type heroListType;

    public JsonParser() {
        gson = new GsonBuilder().setLenient().setPrettyPrinting().create();
        heroes = new ArrayList<>();
        heroListType = new TypeToken<ArrayList<Hero>>(){}.getType();


        if (readHeroesFromFile() != null) {
            heroes.addAll(Objects.requireNonNull(readHeroesFromFile()));
        } else {
            heroes = new ArrayList<>();
        }
    }

    protected void writeHeroToFile(Hero hero) {
        heroes.remove(hero);

        heroes.add(hero);

        writeHeroesToFile(heroes);
    }

    protected Hero readHeroFromFile(String heroName) {
        int heroIndex = 0;
        boolean flag = false;
        for (int i = 0; i < heroes.size(); i++) {
            if (heroes.get(i).getName().equals(heroName)) {
                heroIndex = i;
                flag = true;
            }
        }

        if (!flag) {
            System.out.println("There is no such hero. You have to create it first.");
            return null;
        }

        return heroes.get(heroIndex);
    }

    protected void deleteHero(Hero hero) {
        heroes.remove(hero);
        writeHeroesToFile(heroes);
    }

    public void readJsonArray() {
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }

    private void writeHeroesToFile(List<Hero> heroes) {


        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Zahari\\IdeaProjects\\RPGGame\\src\\saves\\hero_save.json")) {
            gson.toJson(heroes, fileWriter);
        } catch (IOException e) {
            System.out.println("Couldn't open file to write in it.");
            e.printStackTrace();
        }
    }

    private List<Hero> readHeroesFromFile() {
        try (FileReader reader = new FileReader("C:\\Users\\Zahari\\IdeaProjects\\RPGGame\\src\\saves\\hero_save.json")) {
            heroes = gson.fromJson(reader, heroListType);
        } catch (IOException e) {
            System.out.println("Couldn't open file to read from it.");
            e.printStackTrace();
        } catch (NullPointerException npe) {
            // this null is processed in constructor.
            return null;
        }

        return heroes;
    }
}
