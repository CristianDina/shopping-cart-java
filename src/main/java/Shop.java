import java.util.List;
import java.util.Scanner;

public class Shop {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Please provide your shopping list. Press ENTER to submit");
            Customer customer = new Customer();
            List<Fruit> shoppingCart = customer.buy(sc.nextLine());
            customer.checkOut(shoppingCart);
        }
    }
}
