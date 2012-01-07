import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

    @Before
    public void setup() {
        Fixtures.deleteAll();
    }

    @Test
    public void createAndRetrieveListElement() {
        // Create a new user and save it
        ListElement save = new ListElement("Ma super liste").save();

        // Retrieve the user with bob username
        ListElement read = ListElement.find("uuid", save.uuid).first();

        // Test 
        assertNotNull(read);
        assertEquals(save, read);
    }

}
