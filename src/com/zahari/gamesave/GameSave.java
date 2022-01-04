package com.zahari.gamesave;

import com.zahari.heroes.Hero;

public class GameSave implements Savable {

    private final JsonParser jsonParser;

    public GameSave() {
        this.jsonParser = new JsonParser();
    }

    @Override
    public void save(Hero hero) {
        jsonParser.writeHeroToFile(hero);
    }

    @Override
    public Hero load(String heroName) {
        return jsonParser.readHeroFromFile(heroName);
    }

    @Override
    public void delete(Hero hero) {
        jsonParser.deleteHero(hero);
    }
}
