public class CustomerDemo {
    Cart myCart;
    public CustomerDemo () {
        myCart = new Cart();
    }
    public static void demo () {
        CustomerDemo c = new CustomerDemo();
        Shoe shoe = new Shoe ("Sneaker",12,33.99);
        Book book = new Book ("ThinkJava",125,35.99);
        c.myCart.addShoe(shoe);
        c.myCart.addBook(book);
        System.out.println("What's in my cart?");
        System.out.print(c.myCart);
        System.out.printf("My total is: $%.2f",
            c.myCart.getTotal());
    }
}