import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WorkflowTest{
    @Test
    public void testGetNextReview(){
        AttorneyForm nextReview = new AttorneyForm("May Evans", "8806 Chain Bridge Blvd", "Elsie Pierce", 812, 7063398823L, 8351);
        Workflow.readyToReview.add(8351);
        //Replace second 'nextReview' with DB.getForm(8351)
        assertEquals("GetNextReview not working.", nextReview, nextReview);
    }
    
    @Test
    public void testGetNextApproval(){
        AttorneyForm nextApproval = new AttorneyForm("Mark Douglas", "4602 Chain Bridge Rd", "Violet Drake", 904, 7266028841L, 9541);
        Workflow.readyToReview.add(9541);
        //Replace second 'nextApproval' with DB.getForm(9541)
        assertEquals("GetNextReview not working.", nextApproval, nextApproval);
    }
}