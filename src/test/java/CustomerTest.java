import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

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
        assertEquals("Because of the special offers you have received 2 extra Apples and 1 extra Oranges\n=> £1.95", customer.checkOut(Arrays.asList(Fruit.Apple, Fruit.Orange, Fruit.Orange, Fruit.Orange, Fruit.Apple)));
    }
}
