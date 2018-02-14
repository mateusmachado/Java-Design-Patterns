import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        IvoryTower ivoryTower1 = IvoryTower.getInstance();
        IvoryTower ivoryTower2 = IvoryTower.getInstance();
        LOGGER.info("ivoryTower1={}", ivoryTower1);
        LOGGER.info("ivoryTower2={}", ivoryTower2);

        EnumIvoryTower enumIvoryTower1 = EnumIvoryTower.INSTANCE;
        EnumIvoryTower enumIvoryTower2 = EnumIvoryTower.INSTANCE;
        LOGGER.info("enumIvoryTower1={}", enumIvoryTower1);
        LOGGER.info("enumIvoryTower2={}", enumIvoryTower2);
    }
}
