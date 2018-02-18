import com.facade.DwarvenGoldmineFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.InMemoryAppender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DwarvenGoldmineFacadeTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setup() {
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown() {
        appender.stop();
    }

    @Test
    public void testFullWorkDay() {
        final DwarvenGoldmineFacade goldMine = new DwarvenGoldmineFacade();
        goldMine.startNewDay();

        assertTrue(appender.logContains("Dwarf gold digger wakes up."));
        assertTrue(appender.logContains("Dwarf cart operator wakes up."));
        assertTrue(appender.logContains("Dwarven tunnel digger wakes up."));

        assertTrue(appender.logContains("Dwarf gold digger goes to the mine."));
        assertTrue(appender.logContains("Dwarf cart operator goes to the mine."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes to the mine."));

        assertEquals(6, appender.getLogSize());

        goldMine.digOutGold();

        assertTrue(appender.logContains("Dwarf gold digger digs for gold."));
        assertTrue(appender.logContains("Dwarf cart operator moves gold chunks out of the mine."));
        assertTrue(appender.logContains("Dwarven tunnel digger creates another promising tunnel."));

        assertEquals(9, appender.getLogSize());

        goldMine.endDay();

        assertTrue(appender.logContains("Dwarf gold digger goes home."));
        assertTrue(appender.logContains("Dwarf cart operator goes home."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes home."));

        assertTrue(appender.logContains("Dwarf gold digger goes to sleep."));
        assertTrue(appender.logContains("Dwarf cart operator goes to sleep."));
        assertTrue(appender.logContains("Dwarven tunnel digger goes to sleep."));

        assertEquals(15, appender.getLogSize());
    }
}
