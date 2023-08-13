import org.junit.jupiter.api.Test;

import com.example.Music;

import static org.junit.jupiter.api.Assertions.*;

class MusicTest {

    @Test
    void musicIsSetToBeautifulMistake() {
        Music m = new Music();
        assertEquals(m.setMusic(), "Beautiful Mistake - Maroon5");
    }

    @Test
    void musicIsSetToElectricLove() {
        Music m = new Music();
        assertEquals(m.setMusic(), "Electric Love - BØRNS");
    }

    @Test
    void musicIsSetToSurprise() {
        Music m = new Music();
        assertEquals(m.setMusic(), "Surprise!");
    }
}