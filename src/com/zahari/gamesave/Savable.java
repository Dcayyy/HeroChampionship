package com.zahari.gamesave;

import com.zahari.heroes.Hero;

public interface Savable {

    void save(Hero hero);
    Hero load(String heroName);
    void delete(Hero hero);
}
