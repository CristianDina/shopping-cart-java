import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    @Test
    public void buyHappyPath() {
        Customer customer = new Customer();
        assertEquals(Arrays.asList(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple), customer.buy("[ Apple, Apple, Orange, Apple ]"));
    }

    @Test
    public void buyOnlyAvailableFruits() {
        Customer customer = new Customer();
        assertEquals(Arrays.asList(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple), customer.buy("[ Apple, Apple, Orange, Apple, Pie, Banana]"));
    }

    @Test
    public void buyDespiteChaoticInput() {
        Customer customer = new Customer();
        assertEquals(Arrays.asList(Fruit.Orange, Fruit.Apple), customer.buy("  \n  AppleApple, \tOrange\n, ApplePie \n \t \r Apple \f"));
    }

    @Test
    public void checkOutHappyPath() {
        Customer customer = new Customer();
        assertEquals(Fruit.Apple.getPrice() + Fruit.Orange.getPrice() * 2, customer.checkOut(Arrays.asList(Fruit.Apple, Fruit.Orange, Fruit.Orange, Fruit.Orange, Fruit.Apple)));
    }

    @Test
    public void checkOutOrangeSpecialOffer() {
        Customer customer = new Customer();
        int count = 3;
        assertEquals(getOrangesSpecialOffer(count), customer.checkOut(fillList(count, Fruit.Orange)));
    }

    @Test
    public void checkOutOrangeSpecialOfferOneExtraOrange() {
        Customer customer = new Customer();
        int count = 4;
        assertEquals(getOrangesSpecialOffer(count), customer.checkOut(fillList(count, Fruit.Orange)));
    }

    @Test
    public void checkOutOrangeSpecialOfferTwoExtraOrange() {
        Customer customer = new Customer();
        int count = 5;
        assertEquals(getOrangesSpecialOffer(count), customer.checkOut(fillList(count, Fruit.Orange)));
    }

    @Test
    public void checkOutAppleSpecialOffer() {
        Customer customer = new Customer();
        int count = 2;
        assertEquals(getApplesSpecialOffer(count), customer.checkOut(fillList(count, Fruit.Apple)));
    }

    @Test
    public void checkOutAppleSpecialOfferOneExtraApple() {
        Customer customer = new Customer();
        int count = 3;
        assertEquals(getApplesSpecialOffer(count), customer.checkOut(fillList(count, Fruit.Apple)));
    }

    private int getOrangesSpecialOffer(int count) {
        return Fruit.Orange.getPrice() * (count * 2 / 3 + count % 3);
    }

    private int getApplesSpecialOffer(int count) {
        return Fruit.Apple.getPrice() * (count / 2 + count % 2);
    }

    private List<Fruit> fillList(int count, Fruit fruit ){
        List<Fruit> list = new ArrayList<>();
        for(int i = 0 ; i< count; i++)
            list.add(fruit);
        return  list;
    }
}
