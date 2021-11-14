package chapter05.practice;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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

        member.buyBooks(books);
        member.buyBooks(books2);

        System.out.println(member.getRentalAmount());
    }
}

class Member {
    private String name;
    private BigDecimal rentalAmount;

    public Member(String name) {
        this.name = name;
        this.rentalAmount = BigDecimal.ZERO;
    }

    public BigDecimal getRentalAmount() {
        return rentalAmount;
    }

    public void buyBooks(List<Book> books) {
        this.rentalAmount = books.stream()
                .map(Book::getPrice)
                .reduce(rentalAmount, BigDecimal::add);
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
    private List<DiscountPolicy> policies;

    public void setPolicies(List<DiscountPolicy> policies) {
        this.policies = policies;
    }

    public void addPolicies(DiscountPolicy policy) {
        this.policies.add(policy);
    }

    public void calculate(Member buyer, List<Book> books) {

    }
}

interface DiscountPolicy {
    BigDecimal discount(BigDecimal price);
}

class BookDiscountPolicy {
    private long baseYear;
    private double discountRate;

    public BigDecimal discount(Book book) {
        if (LocalDateTime.now().minusYears(baseYear).isAfter(book.getPublishedAt())) {
            return BigDecimal.valueOf(book.getPrice().doubleValue() * discountRate);
        }
        return book.getPrice();
    }
}

class MemberDiscountPolicy {
    private BigDecimal baseAmount;
    private double discountRate;

    public BigDecimal discount(Member member, Book book) {
        return null;
    }
}