package chapter09.exercise;

import java.util.List;

public class DataSheetView implements Observer {
    private ScoreRecord scoreRecord;
    private int viewCount;

    public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
        this.scoreRecord = scoreRecord;
        this.viewCount = viewCount;
    }

    public void update() {
        List<Integer> scores = scoreRecord.getScores();
        int end = Math.min(scores.size(), viewCount);
        displayScores(scores.subList(0, end));
    }

    private void displayScores(List<Integer> scores) {
        System.out.print("List of " + viewCount + " entries: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
