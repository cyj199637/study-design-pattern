package chapter10.practice01;

public class SecureEmailContentDecorator extends EmailContentDecorator {

    public SecureEmailContentDecorator(EmailContentService service) {
        super(service);
    }

    @Override
    public String getContent() {
        String content = super.getContent();
        String encryptedContent = encrypt(content);
        return encryptedContent;
    }

    private String encrypt(String content) {
        return content + " Encrypted";
    }
}
