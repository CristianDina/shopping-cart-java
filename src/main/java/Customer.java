import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

public class Customer {

    public List<Fruit> buy(String inputShoppingList) {
        return Arrays.stream(inputShoppingList.split("\\W")).filter(s -> !s.isEmpty() && Arrays.stream(Fruit.values()).map(Enum::toString).collect(Collectors.toSet()).contains(s)).map(Fruit::valueOf).collect(Collectors.toList());
    }

    public int checkOut(List<Fruit> shoppingCart) {
        return checkOutSpecialOffers(shoppingCart);
    }

    private int checkOutSpecialOffers(List<Fruit> shoppingCart) {
        int appleCount = toIntExact(shoppingCart.stream().filter(fruit -> fruit.equals(Fruit.Apple)).count());
        int orangeCount = toIntExact(shoppingCart.stream().filter(fruit -> fruit.equals(Fruit.Orange)).count());
        return (appleCount / 2 + appleCount % 2) * Fruit.Apple.getPrice() + (orangeCount * 2 / 3 + orangeCount % 3) * Fruit.Orange.getPrice();
    }
}
