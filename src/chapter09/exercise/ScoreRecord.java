package chapter09.exercise;

import java.util.ArrayList;
import java.util.List;

public class ScoreRecord extends Subject {
    private List<Integer> scores = new ArrayList<>();

    public List<Integer> getScores() {
        return scores;
    }

    public void addScore(int score) {
        scores.add(score);
        notifyObservers();
    }
}
