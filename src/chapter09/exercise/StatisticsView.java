package chapter09.exercise;

import java.util.List;

public class StatisticsView implements Observer {
    private ScoreRecord scoreRecord;

    public StatisticsView(ScoreRecord scoreRecord) {
        this.scoreRecord = scoreRecord;
    }

    @Override
    public void update() {
        List<Integer> scores = scoreRecord.getScores();
         displayStatistics(scores);
    }

    private void displayStatistics(List<Integer> scores) {
        int sum = scores.stream().reduce(0, Integer::sum);
        double avg = sum / scores.size();
        System.out.println("Sum: " + sum + ", Average: " + avg);
    }
}
