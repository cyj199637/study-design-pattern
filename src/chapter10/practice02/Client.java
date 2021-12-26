package chapter10.practice02;

public class Client {

    public static void main(String[] args) {
        CarComponent basic = new BasicCar(30000000);
        System.out.println("가격: " + basic.getPrice());
        System.out.println("차량 정보: " + basic.getCarInfo());

        CarComponent addedAirbag = new AirbagDecorator(new BasicCar(30000000), 1000000);
        System.out.println("가격: " + addedAirbag.getPrice());
        System.out.println("차량 정보: " + addedAirbag.getCarInfo());

        CarComponent addedSCC =
            new SCCDecorator(new AirbagDecorator(new BasicCar(30000000), 1000000), 5000000);
        System.out.println("가격: " + addedSCC.getPrice());
        System.out.println("차량 정보: " + addedSCC.getCarInfo());

        CarComponent addedESC =
            new ESCDecorator(new NaviDecorator(new SCCDecorator(new BasicCar(30000000), 5000000), 2000000), 3000000);
        System.out.println("가격: " + addedESC.getPrice());
        System.out.println("차량 정보: " + addedESC.getCarInfo());
    }
}
