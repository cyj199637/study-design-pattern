package chapter10.practice01;

public class ExternalEmailContentDecorator extends EmailContentDecorator {

    public ExternalEmailContentDecorator(EmailContentService service) {
        super(service);
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
