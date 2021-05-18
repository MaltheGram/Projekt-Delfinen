import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    public void writeFile(HashMap<Integer,Member.Member> map, String filename){
        try {
            File file = new File(filename + ".txt");
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter p = new PrintWriter(f);

            //Write in format
            for(Map.Entry<Integer,Member.Member> m :map.entrySet()){
                p.println(m.getKey()+"="+m.getValue());
            }

            //Cleanup
            p.flush();
            p.close();
            f.close();
        } catch(Exception e) {}
    }
    public void readFile(File filename){
        try {
            File toRead = new File("filename.txt");
            FileInputStream f = new FileInputStream(toRead);
            //DO SHIT

        } catch(Exception e) {}
    }
}
