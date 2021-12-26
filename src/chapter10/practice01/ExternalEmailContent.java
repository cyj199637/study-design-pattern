package chapter10.practice01;

public class ExternalEmailContent extends BasicEmailContent {

    public ExternalEmailContent(String content) {
        super(content);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        String externalContent = addDisclaimer(content);
        return externalContent;
    }

    private String addDisclaimer(String content) {
        return content + " Company Disclaimer";
    }
}
