package com.example.elrahma.hero;

import java.util.ArrayList;

public class HeroesData {

    public static String[][] data = new String[][]{
            {"Tinker", "Carry", "https://www.teamtrainit.com/android/hero/tinker.jpg"},
            {"Earth Spirit", "Ganker", "https://www.teamtrainit.com/android/hero/earthspirit.jpg"},
            {"Tusk", "Roamer", "https://www.teamtrainit.com/android/hero/tusk.jpg"},
            {"Bounty Hunter", "Roamer", "https://www.teamtrainit.com/android/hero/bountyhunter.jpg"},
            {"Ember Spirit", "Ganker", "https://www.teamtrainit.com/android/hero/emberspirit.jpg"},
            {"Puck", "Semi-carry", "https://www.teamtrainit.com/android/hero/puck.jpg"},
            {"Gyrocopter", "Carry", "https://www.teamtrainit.com/android/hero/gyrocopter.jpg"}
    };

    public static ArrayList<Heroes> getListData(){
        Heroes heroes = null;
        ArrayList<Heroes> list = new ArrayList<>();
        for (String[] aData : data) {
            heroes = new Heroes();
            heroes.setNama(aData[0]);
            heroes.setDeskripsi(aData[1]);
            heroes.setGambar(aData[2]);

            list.add(heroes);
        }

        return list;
    }
}
