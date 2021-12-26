package chapter10.practice01;

public class BasicEmailContent implements EmailContentService {
    private String content;

    public BasicEmailContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
