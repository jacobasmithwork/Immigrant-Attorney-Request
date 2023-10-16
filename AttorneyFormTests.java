import static org.junit.Assert.*;

import org.junit.*;

public class AttorneyFormTests{
    @Test
    public void getName(){
        AttorneyForm af = new AttorneyForm("Bob", "5503 Main Street", 
        "Jim Smith", 123, 42488273);
        assertEquals("Bob", af.getName());
    }
}