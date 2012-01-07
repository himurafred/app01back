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
		assertEquals("Ma super liste", read.text);
    }

    @Test
    public void addElementsToListElement() {
        // Create a new user and save it
        ListElement save = new ListElement("Ma super liste");
		Element e1 = new Element("e1").save();
		Element e2 = new Element("e2").save();
		List<Element> elements = new ArrayList<Element>();
		elements.add(e1);
		elements.add(e2);
		save.elements=elements;
		save.save();
        // Retrieve the user with bob username
        ListElement read = ListElement.find("uuid", save.uuid).first();

        // Test 
        assertNotNull(read);
        assertEquals(save, read);
		assertEquals(2, read.elements.size());
		for(Element e:read.elements){
			assertNotNull(e);
		}
    }

}
