package chapter02.practice;

public class Practice04 {
    public static void main(String[] args) {
        CartForSongs cart = new CartForSongs();

        Song s1 = new Song(1000);
        s1.applyOnSale();
        Song s2 = new Song(2000);
        s2.applyTodayEvent();
        Song s3 = new Song(1500);
        s3.applyOnSale();
        Song s4 = new Song(900);
        s4.applyTodayEvent();

        cart.add(s1);
        cart.add(s2);
        cart.add(s3);
        cart.add(s4);

        System.out.println(cart.calculateTotalPrice());
    }
}
