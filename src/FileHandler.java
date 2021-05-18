import Member.Member;
import Service.MemberIdGenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.*;

public class FileHandler {
    public void writeFile(HashMap<Integer,Member> map, String filename){
        try {
            File file = new File(filename + ".txt");
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter p = new PrintWriter(f);

            //Write in format
            for(Map.Entry<Integer,Member> m :map.entrySet()){
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
            File toRead = new File(filename + ".txt");
            FileInputStream f = new FileInputStream(toRead);
            Scanner sc = new Scanner(f);
            HashMap<Integer,Member> mapInFile = new HashMap<Integer,Member>();

            //CRAWLING IN MY SKIN, THESE WOUNDS THEY WILL NOT HEAL :^(
            String currentLine;
            while(sc.hasNextLine()) {
                currentLine= sc.nextLine();
                LocalDate MarkDate = LocalDate.of(1996, 10, 30);
                MemberIdGenerator memberIdGenerator2 = new MemberIdGenerator();
                Member Mark = new Member("Mark", MarkDate, "Lygten 37", "8888888", true, memberIdGenerator2);

                //GET KEY
                String[] memberKey = currentLine.split("=");

                //GET BIRTHDATE

                //GET NAME

                //GET ADDRESS

                //MEMBER ID

                //ACTIVE MEMBERSHIP

                mapInFile.put(Integer.parseInt(memberKey[0]),Mark);
            }

            System.out.println(mapInFile);

        } catch(Exception e) {}
    }
}
