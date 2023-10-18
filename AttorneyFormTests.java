import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class AttorneyFormTests{
    @Test
    public void test1(){
        AttorneyForm af = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
        assertEquals(af.getName(), "Bob");
    }
}