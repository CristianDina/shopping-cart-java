import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Customer {

    public List<Fruit> buy(String inputShoppingList) {
        return Arrays.stream(inputShoppingList.split("\\W")).filter(s -> !s.isEmpty() && Arrays.stream(Fruit.values()).map(Enum::toString).collect(Collectors.toSet()).contains(s)).map(Fruit::valueOf).collect(Collectors.toList());
    }

    public String checkOut(List<Fruit> shoppingCart) {
        final int total = shoppingCart.stream().mapToInt(Fruit::getPrice).sum();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(checkOutSpecialOffers(shoppingCart));
        stringBuilder.append("=> £" + total / 100 + "." + String.format("%02d", total % 100));
        return stringBuilder.toString();
    }

    private String checkOutSpecialOffers(List<Fruit> shoppingCart) {
        long appleCounter = shoppingCart.stream().filter(fruit -> fruit.equals(Fruit.Apple)).count();
        long orangeCounter = shoppingCart.stream().filter(fruit -> fruit.equals(Fruit.Orange)).count();
        return "Because of the special offers you have received " + appleCounter + " extra Apples and " + orangeCounter/2 + " extra Oranges\n";
    }
}
