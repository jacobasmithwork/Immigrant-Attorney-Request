

import java.util.LinkedList;
/**
 * The workflow class for the Attorney Request functional area
 */
public class Workflow{

    //By using Linked Lists as queues, handles easy head popping/peeking and adding.
    /**
     * The LinkedList containaing Integer values corresponding to AttorneyForm formId's that are ready for Approval.
     */
    public static LinkedList<Integer> readyToApprove = new LinkedList<>();

    /**
     * The LinkedList containaing Integer values corresponding to AttorneyForm formId's that are ready for Approval.
     */
    public static LinkedList<Integer> readyToReview = new LinkedList<>();
    //Having a static queue shares a single copy of each queue among all instances

    /**This is a get method for the readyToApprove LinkedList.
     * 
     * @return A LinkedList of Integer numbers corresponding to AttorneyForm IDs.
     */
    public static LinkedList<Integer> getApproveQueue(){
        return readyToApprove;
    }

    /**This is a get method for the readyToReview LinkedList.
     * 
     * @return A LinkedList of Integer numbers corresponding to AttorneyForm IDs.
     */
    public static LinkedList<Integer> getReviewQueue(){
        return readyToReview;
    }

    /**This method gets the next AttorneyForm id in the readyToReview LinkedList and removes it from the list.
     * 
     * @return A integer value corresponding to the form's ID.
     */
    public static AttorneyForm getNextReview(){
        int id = readyToReview.remove();
        //return DB.getForm(id)
        return null;
    }
    
    /**This method gets the next AttorneyForm id in the readyToApprove LinkedList and removes it from the list.
     * 
     * @return A integer value corresponding to the form's ID.
     */
    public static AttorneyForm getNextApproval(){
        int id = readyToReview.remove();
        //return DB.getForm(id)
        return null;
    }
}