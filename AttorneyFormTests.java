import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.Transient;

import org.junit.*;

public class AttorneyFormTests{

    //Initiate blank Attorney Forms
    AttorneyForm aa = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
    AttorneyForm ab = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
    AttorneyForm ac = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
    AttorneyForm ad = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);


    @Test
    public void test1(){ //get methods

        //Set attorney forms
        AttorneyForm aa = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
        AttorneyForm ab = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
        AttorneyForm ac = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);
        AttorneyForm ad = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 123123);

        assertEquals(aa.getName(), "");
        assertEquals(ab.getName(), "");
        assertEquals(ac.getName(), "");
        assertEquals(ad.getName(), "");

        assertEquals(aa.getAddress(), "");

        assertEquals(aa.getAttorneyName(), "");

        assertEquals(aa.getPhoneNum(), "");

        assertEquals(aa.getImmId(), "");

        assertEquals(aa.getStatus(), "");

        assertEquals(aa.getComments(), "");
    }

    @Test
    public void test2(){ //set methods?
        //Do this
    }
}