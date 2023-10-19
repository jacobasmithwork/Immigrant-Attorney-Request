import java.util.LinkedList;

public class Workflow{
    //By using Linked Lists as queues, handles easy head popping/peeking and adding.
    public static LinkedList<Integer> readyToApprove = new LinkedList<>();
    public static LinkedList<Integer> readyToReview = new LinkedList<>();
    //Having a static queue shares a single copy of each queue among all instances

    public static LinkedList<Integer> getApproveQueue(){
        return readyToApprove;
    }

    public static LinkedList<Integer> getReviewQueue(){
        return readyToReview;
    }

    public static AttorneyForm getNextReview(){
        int id = readyToReview.remove();
        //return DB.getForm(id)
        return null;
    }
    
    public static AttorneyForm getNextApproval(){
        int id = readyToReview.remove();
        //return DB.getForm(id)
        return null;
    }
}