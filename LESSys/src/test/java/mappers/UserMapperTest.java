package mappers;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features", glue = ""
)
public class UserMapperTest {

    @BeforeClass
    public static void setupDB() {
    }
}