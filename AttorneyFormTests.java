import org.junit.*;
import static org.junit.Assert.*;

public class AttorneyFormTests{
    @Test
    public void test1(){
        AttorneyForm af = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 42488273);
        assertEquals("Name Works.","Bob", af.getName());
    }
}