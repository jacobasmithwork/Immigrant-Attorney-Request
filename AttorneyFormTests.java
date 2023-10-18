import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class AttorneyFormTests{
    AttorneyForm af;
    @Before
    public void setUp(){
        af = new AttorneyForm("Bob", "5503 Main Street", "Jim Smith", 123, 8042413788L); //without 'L', treated as int.
    }

    @After
    public void cleanUp(){
        af = null;
    }
    @Test
    public void testGetters(){
        assertEquals(af.getName(), "Bob");
        assertEquals(af.getAddress(), "5503 Main Street");
        assertEquals(af.getAttorneyName(), "Jim Smith");
        assertEquals(af.getImmId(), 123);
        assertEquals(af.getPhoneNum(), 8042413788L);
    }
    
    @Test
    public void testSetters(){
        af.setName("Andre");
        af.setAddress("4122 Ox Drive");
        af.setAttorneyName("Blanche Diaz");
        af.setImmId(321);
        af.setPhoneNum(7744237844L);

        assertEquals(af.getName(), "Andre");
        assertEquals(af.getAddress(), "4122 Ox Drive");
        assertEquals(af.getAttorneyName(), "Blanche Diaz");
        assertEquals(af.getImmId(), 321);
        assertEquals(af.getPhoneNum(), 7744237844L);
    }

    @Test
    public void testSendToWf(){
        af.sendToWf(1);
        assertTrue("Did not add to review workflow.", Workflow.getReviewQueue().getLast() == af.formId);

        af.sendToWf(2);
        assertTrue("Did not add to approval workflow.", Workflow.getApproveQueue().getLast() == af.formId);
    }

    @Test
    public void testSendToDb(){
        af.sendToDb();
        //Once DB implemented, replace 'false' with DB.contains(formId)or contains(af)
        assertTrue("Did not add to database", false);
    }
    
    @Test
    public void testUpdateDb(){
        af.setPhoneNum(8039002322L);
        af.updateDb();
        //Once DB implemented, replace 'false' with DB.getForm(id).getPhoneNum == 8039002322L
        assertTrue("Did not add to database", false);
    }
}