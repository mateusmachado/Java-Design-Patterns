import com.facade.DwarvenGoldmineFacade;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.InMemoryAppender;

public class DwarvenGoldmineFacadeTest {

    private InMemoryAppender appender;

    @BeforeEach
    public void setup(){
        appender = new InMemoryAppender();
    }

    @AfterEach
    public void tearDown(){
        appender.stop();
    }

    @Test
    public void testFullWorkDay(){
        final DwarvenGoldmineFacade goldMine = new DwarvenGoldmineFacade();
        goldMine.startNewDay();

    }

}
