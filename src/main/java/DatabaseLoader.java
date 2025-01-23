import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import service.JsonDatabaseInitializer;

@Component
public class DatabaseLoader implements CommandLineRunner {

    private final JsonDatabaseInitializer jsonDatabaseInitializer;

    public DatabaseLoader(JsonDatabaseInitializer jsonDatabaseInitializer) {
        this.jsonDatabaseInitializer = jsonDatabaseInitializer;
    }

    @Override
    public void run(String... args) {
        String jsonFilePath = "src/main/java/resources/device.json";
        jsonDatabaseInitializer.loadJsonData(jsonFilePath);
    }
}
