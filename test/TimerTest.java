import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerTest {

    @Test
    void testSetMin() {
        Timer t = new Timer();
        assertTrue(t.setMin());
    }

    @Test
    void testSetSec() {
        Timer t = new Timer();
        assertTrue(t.setSec());
    }
}