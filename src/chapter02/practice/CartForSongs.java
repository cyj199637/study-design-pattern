package chapter02.practice;

import java.util.ArrayList;

public class CartForSongs {
    private ArrayList<Song> cart = new ArrayList<>();

    public void add(Song song) {
        if (!cart.contains(song)) {
            cart.add(song);
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;
        for (Song s : cart) {
            totalPrice += s.getPrice();
        }

        return totalPrice;
    }
}
