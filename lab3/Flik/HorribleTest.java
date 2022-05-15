import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HorribleTest {

    @Test
    public void testSomeNumbers() {
        int[][] nums = new int[][] {
            {127,127},
            {128,128},
            {-128,-128}
        };
        for (int[] num : nums) {
            boolean res = Flik.isSameNumber(num[0],num[1]);
            assertEquals("Something strange happened",true, res);
        }
    }
}
