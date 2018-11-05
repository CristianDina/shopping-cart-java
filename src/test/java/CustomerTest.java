import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class CustomerTest {

    @Test
    public void extractionHappyPath() {
        Customer customer = new Customer();
        assertEquals(Arrays.asList(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple), customer.buy("[ Apple, Apple, Orange, Apple ]"));
    }

    @Test
    public void extractionOfOnlyAvailableFruits() {
        Customer customer = new Customer();
        assertEquals(Arrays.asList(Fruit.Apple, Fruit.Apple, Fruit.Orange, Fruit.Apple), customer.buy("[ Apple, Apple, Orange, Apple, Pie, Banana]"));
    }

    @Test
    public void extractionDespiteChaoticInput() {
        Customer customer = new Customer();
        assertEquals(Arrays.asList(Fruit.Orange, Fruit.Apple), customer.buy("  \n  AppleApple, \tOrange\n, ApplePie \n \t \r Apple \f"));
    }

}
