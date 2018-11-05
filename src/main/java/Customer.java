import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    public List<Fruit> buy(String inputShoppingList) {
        return Arrays.stream(inputShoppingList.split("\\W")).filter(s -> !s.isEmpty() && Arrays.stream(Fruit.values()).map(Enum::toString).collect(Collectors.toSet()).contains(s)).map(Fruit::valueOf).collect(Collectors.toList());
    }

    public void checkOut(List<Fruit> shoppingCart) {
        final int total = shoppingCart.stream().mapToInt(Fruit::getPrice).sum();
        System.out.println("=> £" + total / 100 + "." + String.format("%02d", total % 100));
    }
}
