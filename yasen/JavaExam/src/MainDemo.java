import java.util.ArrayList;

/**
 * Created by Yassen on 3/30/2016.
 */
public class MainDemo {


    public static void main(String[] args) {


        ArrayList<Institution> institutions = Institution.getInstitutionFromXMLFile();

        try {
            for (int i = 0; i < institutions.size(); i++) {

                Thread t = new Thread(new FileWriter(institutions.get(i)));
                t.run();


                long startTime = System.currentTimeMillis();

                while (t.isAlive()) {
                    System.out.println("Here");
                    if (((System.currentTimeMillis() - startTime) > 2000)
                            && t.isAlive()) {
                        t.interrupt();
                        // Shouldn't be long now
                        // -- wait indefinitely
                        t.join();
                    }
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }
}
