package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import group13.AttorneyForm;
import group13.Workflow;

public class WorkflowTest{
    @Test
    public void testGetNextReview(){
        AttorneyForm nextReview = new AttorneyForm("May Evans", "8806 Chain Bridge Blvd", "Elsie Pierce","Cool Guy Firm", 812, 7063398823L, 8351);
        Workflow.readyToReview.add(8351);
        //Replace second 'nextReview' with DB.getForm(8351)
        assertEquals("GetNextReview not working.", nextReview, nextReview);
    }
    
    @Test
    public void testGetNextApproval(){
        AttorneyForm nextApproval = new AttorneyForm("Mark Douglas", "4602 Chain Bridge Rd", "Violet Drake", "Cool Guy Firm", 904, 7266028841L, 9541);
        Workflow.readyToReview.add(9541);
        //Replace second 'nextApproval' with DB.getForm(9541)
        assertEquals("GetNextReview not working.", nextApproval, nextApproval);
    }

    @Test
    public void testGetReviewQueue(){
        AttorneyForm A = new AttorneyForm("Mark Douglas", "4602 Chain Bridge Rd", "Violet Drake", "Cool Guy Firm", 904, 7266028841L, 9541);
        AttorneyForm B = new AttorneyForm("Shmerle Smoothie", "7832 Driveway Dr", "Charles Dude", "Cool Guy Firm", 712, 7035442594L, 7723);
        AttorneyForm C = new AttorneyForm("Jesser Pinkguy", "1234 ThisStreet Dr", "Mr Laywer Man", "Cool Guy Firm", 984, 4153467782L, 1235);
        AttorneyForm D = new AttorneyForm("Walt White", "308 Negra Arroyo Ln", "Saul Gman", "Cool Guy Firm", 143, 5051178987L, 8888);

        AttorneyForm[] formQueue = {A,B,C,D};
        //Add all forms to review queue
        for(AttorneyForm af : formQueue){
            int id = af.sendToWf(1);
            System.out.println(id);
            af.setFormId(id);
        }

        //For each form, check if id matches (only works on blank queue), then purge garbage forms from DB
        for(int i=0; i < formQueue.length; i++){
            int test = formQueue[i].formId;
            int id = Workflow.getNextReview().getFormId();
            assertEquals(("GetReviewQueue Error: mismatching formId: " + test +" : "+ id), test, id);
            formQueue[i].removeFromDb();
        }
        
    }

    @Test
    public void testGetApprovalQueue(){
        AttorneyForm A = new AttorneyForm("Mark Douglas", "4602 Chain Bridge Rd", "Violet Drake", "Cool Guy Firm", 904, 7266028841L, 9541);
        AttorneyForm B = new AttorneyForm("Shmerle Smoothie", "7832 Driveway Dr", "Charles Dude", "Cool Guy Firm", 712, 7035442594L, 7723);
        AttorneyForm C = new AttorneyForm("Jesser Pinkguy", "1234 ThisStreet Dr", "Mr Laywer Man", "Cool Guy Firm", 984, 4153467782L, 1235);
        AttorneyForm D = new AttorneyForm("Walt White", "308 Negra Arroyo Ln", "Saul Gman", "Cool Guy Firm", 143, 5051178987L, 8888);

        AttorneyForm[] formQueue = {A,B,C,D};
        for(AttorneyForm af : formQueue){
            af.sendToWf(2);
        }
        // Workflow.readyToReview.addAll(formQueue);

        for(int i=0; i<formQueue.length; i++){
            int test = formQueue[i].formId;
            int id = Workflow.getNextApproval().getFormId();
            assertEquals(("GetReviewQueue Error: mismatching formId: " + test +" : "+ id), test, id);
        }
        
    }

}