package chapter09.exercise;

import java.util.Comparator;
import java.util.List;

public class MinMaxView implements Observer {
    private ScoreRecord scoreRecord;

    public MinMaxView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        displayMinMax(scores);
    }

    private void displayMinMax(List<Integer> scores) {
        int min = scores.stream().min(Comparator.comparingInt(x -> x)).get();
        int max = scores.stream().max(Comparator.comparingInt(x -> x)).get();
        System.out.println("Min: " + min + ", Max: " + max);
    }
}
