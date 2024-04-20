import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testGetTotalPrice() {
        Order order = new Order("Mie Goreng", 100000.0, 2);
        double expectedTotalPrice = 2 * 10.0;
        double actualTotalPrice = order.getTotalPrice();
        assertEquals(expectedTotalPrice, actualTotalPrice, 0.01);
    }
}
