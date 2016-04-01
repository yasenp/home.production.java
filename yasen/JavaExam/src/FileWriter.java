import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Yassen on 3/30/2016.
 */
public class FileWriter implements Runnable {

    private Institution institution;

    public FileWriter(Institution institution) {this.institution=institution;}

    public void run() {
        System.out.println(this.institution);
        for (int i = 0; i < 1000; i++)
            writeToFile(this.institution);
    }

    void writeToFile(Institution institution) {
        //  String threadName =
        //    Thread.currentThread().getName();
        try {
            Files.write(Paths.get("output.txt"), institution.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }
}
