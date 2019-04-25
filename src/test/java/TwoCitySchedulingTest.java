import org.junit.Test;
import twocityscheduling.TwoCityScheduling;

import static org.junit.Assert.assertEquals;

public class TwoCitySchedulingTest {
    @Test
    public void should_return_110() {
        int[][] costs = new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}};
        TwoCityScheduling twoCityScheduling = new TwoCityScheduling();
        assertEquals(110, twoCityScheduling.twoCitySchedCost(costs));
    }
}
