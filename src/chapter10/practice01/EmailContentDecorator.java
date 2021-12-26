package chapter10.practice01;

public class EmailContentDecorator implements EmailContentService {
    private EmailContentService service;

    public EmailContentDecorator(EmailContentService service) {
        this.service = service;
    }

    @Override
    public String getContent() {
        return service.getContent();
    }
}
