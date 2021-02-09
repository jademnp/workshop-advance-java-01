package shop;

import java.util.List;

public class Buyer {
    private String firstName;
    private String lastName;

    public void requestToBuy(){
        //1. create basket
        Basket basket = new Basket();
        //2. add book to basket
        basket.addBook(null);
        //3. checkout
        //TODO
    }
}
class Basket{
    List<Book> books;

    public void addBook(Book book){
        books.add(book);
    }

}
class Book{
    private String name;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    private int price;

}
