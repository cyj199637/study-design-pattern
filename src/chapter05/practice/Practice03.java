package chapter05.practice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Practice03 {
    public static void main(String[] args) {
        final Member member = new Member("Lora");
        final List<Book> books = List.of(
                new Book("A", LocalDateTime.now(), BigDecimal.valueOf(10_000L)),
                new Book("B", LocalDateTime.now(), BigDecimal.valueOf(15_000L)),
                new Book("C", LocalDateTime.now(), BigDecimal.valueOf(13_500L))
        );

        final List<Book> books2 = List.of(
                new Book("D", LocalDateTime.now(), BigDecimal.valueOf(20_000L)),
                new Book("E", LocalDateTime.now(), BigDecimal.valueOf(17_000L))
        );
    }
}

class Member {
    private String name;
    private BigDecimal totalRentalAmount;

    public Member(String name) {
        this.name = name;
        this.totalRentalAmount = BigDecimal.ZERO;
    }

    public BigDecimal getTotalRentalAmount() {
        return totalRentalAmount;
    }

    public void addRentalAmount(BigDecimal rentalAmount) {
        this.totalRentalAmount = this.totalRentalAmount.add(rentalAmount);
    }
}

class Book {
    private String signature;
    private LocalDateTime publishedAt;
    private BigDecimal price;

    public Book(String signature, LocalDateTime publishedAt, BigDecimal price) {
        this.signature = signature;
        this.publishedAt = publishedAt;
        this.price = price;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

class Counter {
    private List<DiscountPolicy> policies = new ArrayList<>();

    public void setPolicies(List<DiscountPolicy> policies) {
        this.policies = policies;
    }

    public void addPolicies(DiscountPolicy policy) {
        this.policies.add(policy);
    }

    public BigDecimal calculateTotalPrice(Member buyer, List<Book> books) {
        BigDecimal totalPrice = books.stream()
                .map(book -> {
                    BigDecimal price = book.getPrice();
                    for (DiscountPolicy policy : policies) {
                        price = policy.discount(buyer, book, price);
                    }
                    return price;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        buyer.addRentalAmount(totalPrice);
        return totalPrice;
    }
}

interface DiscountPolicy {
    BigDecimal discount(Member member, Book book, BigDecimal currentPrice);
}

class BookDiscountPolicy implements DiscountPolicy {
    private int baseYear;
    private double discountRate;

    public BookDiscountPolicy(int baseYear, double discountRate) {
        this.baseYear = baseYear;
        this.discountRate = discountRate;
    }

    public BigDecimal discount(Member member, Book book, BigDecimal currentPrice) {
        LocalDateTime year = LocalDateTime.now().minusYears(baseYear);
        return year.isAfter(book.getPublishedAt()) ? BigDecimal.valueOf(currentPrice.doubleValue() * discountRate) : currentPrice;
    }
}

class MemberDiscountPolicy implements DiscountPolicy {
    private BigDecimal baseAmount;
    private double discountRate;

    public MemberDiscountPolicy(BigDecimal baseAmount, double discountRate) {
        this.baseAmount = baseAmount;
        this.discountRate = discountRate;
    }

    public BigDecimal discount(Member member, Book book, BigDecimal currentPrice) {
        int result = baseAmount.compareTo(member.getTotalRentalAmount());
        return result < 0 ? BigDecimal.valueOf(currentPrice.doubleValue() * discountRate) : currentPrice;
    }
}