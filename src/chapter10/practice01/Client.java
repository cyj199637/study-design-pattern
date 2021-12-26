package chapter10.practice01;

public class Client {

    public static void main(String[] args) {
        BasicEmailContent basic = new BasicEmailContent("Hello");
        System.out.println(basic.getContent());

        ExternalEmailContent external = new ExternalEmailContent("Hello");
        System.out.println(external.getContent());

        SecureEmailContent secure = new SecureEmailContent("Hello");
        System.out.println(secure.getContent());

        SecureEmailContentDecorator secureDecorator =
            new SecureEmailContentDecorator(new ExternalEmailContentDecorator(new BasicEmailContent("Hello")));
        System.out.println(secureDecorator.getContent());
    }
}
