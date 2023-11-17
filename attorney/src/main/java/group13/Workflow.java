package group13;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;
/**
 * The workflow class for the Attorney Request functional area
 */
public class Workflow{

    //By using Linked Lists as queues, handles easy head popping/peeking and adding.
    /**
     * The LinkedList containaing Integer values corresponding to AttorneyForm formId's that are ready for Approval.
     */
    public static LinkedList<Integer> readyToApprove = new LinkedList<Integer>();

    /**
     * The LinkedList containaing Integer values corresponding to AttorneyForm formId's that are ready for Approval.
     */
    public static LinkedList<Integer> readyToReview = new LinkedList<Integer>();
    //Having a static queue shares a single copy of each queue among all instances

    public static void sendToReview(Integer id){
        try{
            LinkedList<Integer> rQueue = getReviewQueue();
            FileOutputStream fileOutputStream = new FileOutputStream("attorney/src/main/java/group13/resources/reviewQueue.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            if(!rQueue.contains(id)){
                rQueue.add(id);
            }
            objectOutputStream.writeObject(rQueue);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public static void sendToApprove(Integer id){
        try{
            LinkedList<Integer> aQueue = getApproveQueue();
            FileOutputStream fileOutputStream = new FileOutputStream("attorney/src/main/java/group13/resources/approveQueue.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            if(!aQueue.contains(id)){
                aQueue.add(id);
            }
            objectOutputStream.writeObject(aQueue);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    /**This is a get method for the readyToApprove LinkedList.
     * 
     * @return A LinkedList of Integer numbers corresponding to AttorneyForm IDs.
     */
    public static LinkedList<Integer> getApproveQueue(){
        try{
            LinkedList<Integer> database = new LinkedList<Integer>();
            FileInputStream fileInputStream = new FileInputStream("attorney/src/main/java/group13/resources/approveQueue.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            database = (LinkedList<Integer>) objectInputStream.readObject();
            objectInputStream.close();
            return database;
        }
        catch(Exception e){ //If no queue / improper queue, make new
            try{
                LinkedList<Integer> database = new LinkedList<Integer>();
                FileOutputStream fileOutputStream = new FileOutputStream("attorney/src/main/java/group13/resources/approveQueue.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(database);
                objectOutputStream.flush();
                objectOutputStream.close();
                //Re-grab to make sure still valid
                FileInputStream fileInputStream = new FileInputStream("attorney/src/main/java/group13/resources/approveQueue.txt");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                database = (LinkedList<Integer>) objectInputStream.readObject();
                objectInputStream.close();
                return database;
            }
            catch(Exception f){
                return null;
            }
        }
    }

    /**This is a get method for the readyToReview LinkedList.
     * 
     * @return A LinkedList of Integer numbers corresponding to AttorneyForm IDs.
     */
    public static LinkedList<Integer> getReviewQueue(){
        try{
            LinkedList<Integer> database = new LinkedList<Integer>();
            FileInputStream fileInputStream = new FileInputStream("attorney/src/main/java/group13/resources/reviewQueue.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            database = (LinkedList<Integer>) objectInputStream.readObject();
            objectInputStream.close();
            return database;
        }
        catch(Exception e){ //If no queue / improper queue, make new
            try{
                LinkedList<Integer> database = new LinkedList<Integer>();
                FileOutputStream fileOutputStream = new FileOutputStream("attorney/src/main/java/group13/resources/reviewQueue.txt");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(database);
                objectOutputStream.flush();
                objectOutputStream.close();
                return database;
            }
            catch(Exception f){
                System.out.println(f);
                return null;
            }
        }
    }

    /**This method gets the next AttorneyForm id in the readyToReview LinkedList and removes it from the list.
     * 
     * @return A integer value corresponding to the form's ID.
     */
    public static AttorneyForm getNextReview(){
        LinkedList<Integer> reviewQueue = getReviewQueue();
        int id = reviewQueue.remove();
        //return DB.getForm(id)
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("attorney/src/main/java/group13/resources/reviewQueue.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(reviewQueue);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        return AttorneyForm.getForm(id);
    }
    
    /**This method gets the next AttorneyForm id in the readyToApprove LinkedList and removes it from the list.
     * 
     * @return A integer value corresponding to the form's ID.
     */
    public static AttorneyForm getNextApproval(){
        LinkedList<Integer> approveQueue = getApproveQueue();
        //return DB.getForm(id)
        int id = -1;
        try{
            id = approveQueue.remove();
            FileOutputStream fileOutputStream = new FileOutputStream("attorney/src/main/java/group13/resources/approveQueue.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(approveQueue);
            objectOutputStream.flush();
            objectOutputStream.close();
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
        return AttorneyForm.getForm(id);
    }

    public static void printQueues(){
        LinkedList<Integer> rQueue = getReviewQueue();
        LinkedList<Integer> aQueue = getApproveQueue();
        System.out.println("Review Queue:");
        for(Integer i : rQueue){
            System.out.println("\t" + i);
        }
        System.out.println("Approve Queue:");
        for(Integer i : aQueue){
            System.out.println("\t" + i);
        }
    }
}