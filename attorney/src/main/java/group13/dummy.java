package group13;

import java.io.IOException;

public class dummy {
    public static void main(String[] args){
        AttorneyForm af = new AttorneyForm("Anna Barnesey", "8293 Higberry Street", "Mable Hall", "Butler & Bryan", 321983211, 8039022322L);
        // System.out.println(af);
        
        af.addComment("Has a dumb name. (11/14/23 15:08)");
        af.addComment("Still has a dumb name. (11/14/23 15:10)");
        // System.out.println(af);
        af.sendToDb();
        // AttorneyForm.purgeDb();
        af.sendToWf(1);
        AttorneyForm.printAllForms();
        
        Workflow.printQueues();

    }
}
