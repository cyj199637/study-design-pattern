package chapter10.practice01;

public class SecureEmailContent extends BasicEmailContent {

    public SecureEmailContent(String content) {
        super(content);
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
