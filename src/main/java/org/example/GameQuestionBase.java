package org.example;

import java.util.ArrayList;
import java.util.List;

public class GameQuestionBase {
    private static GameQuestionBase instance;
    private final List<GameQuestion> questions;
    private final int currentQuestionIndex;

    private GameQuestionBase(){
        questions = new ArrayList<>();
        questions.add(new GameQuestion("img/1.jpg",
                "Rarity",
                "Rainbow Dach",
                "Spike",
                "Fedora",1));
        questions.add(new GameQuestion("img/2.png",
                "Princess Celestia",
                "Fluttershy",
                "Rarity",
                "Princess Luna",2));
        questions.add(new GameQuestion("img/3.png",
                "Princess Cadance",
                "Pinkie Pie",
                "Applejack",
                "Twilight Sparkle",4));
        questions.add(new GameQuestion("img/4.png",
                "Rarity",
                "Shining armor",
                "Rainbow Dash",
                "Sweetie Belle",3));
        questions.add(new GameQuestion("img/5.png",
                "Pinkie Pie",
                "Fluttershy",
                "Princess Luna",
                "Twilight Sparkle",1));
        questions.add(new GameQuestion("img/6.png",
                "Applejack",
                "Fluttershy",
                "Spike",
                "Princess Luna",1));
        questions.add(new GameQuestion("img/7.png",
                "Princess Cadance",
                "Princess Celestia",
                "Fluttershy",
                "Twilight Sparkle",2));
        questions.add(new GameQuestion("img/8.png",
                "Fedora",
                "Pinkie Pie",
                "Princess Luna",
                "Princess Celestia",3));
        questions.add(new GameQuestion("img/9.png",
                "Shining armor",
                "Rainbow Dash",
                "Applejack",
                "Princess Cadance",4));
        questions.add(new GameQuestion("img/10.png",
                "Twilight Sparkle",
                "Scootaloo",
                "Sweetie Belle",
                "Spike",2));
        questions.add(new GameQuestion("img/11.png",
                "Apple Bloom",
                "Sweetie Belle",
                "Applejack",
                "Granny Smith",1));
        questions.add(new GameQuestion("img/12.png",
                "Apple Bloom",
                "Pinkie Pie",
                "Starlight Glimmer",
                "Princess Celestia",3));
        questions.add(new GameQuestion("img/13.png",
                "Twilight Sparkle",
                "Scootaloo",
                "Rainbow Dash",
                "Diamond Tiara",4));
        questions.add(new GameQuestion("img/14.png",
                "Rabbit",
                "Jerry",
                "Spike",
                "Tom",3));

        currentQuestionIndex = 0;

    }

    public static synchronized GameQuestionBase getInstance() {
        if(instance == null){
            instance = new GameQuestionBase();
        }
        return instance;
    }

    public List<GameQuestion> getQuestions() {
        return questions;
    }
}
