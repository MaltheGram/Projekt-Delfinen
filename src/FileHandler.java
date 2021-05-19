import Member.Member;
import Service.MemberIdGenerator;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileHandler {
    public void writeFile(HashMap<Integer,Member> map, String filename){
        try {
            FileOutputStream write = new FileOutputStream(new File(filename + ".txt"));
            PrintWriter p = new PrintWriter(write);

            //Write in format
            for(Map.Entry<Integer,Member> m :map.entrySet()){
                p.println(m.getKey()+"="+m.getValue());
            }

            //Cleanup
            p.flush();
            p.close();
            write.close();
        } catch(Exception e) {}
    }
    public static HashMap<Integer,Member> readFile(File filename){
        try {
            File read = new File(filename + ".txt");
            FileInputStream f = new FileInputStream(read);
            Scanner sc = new Scanner(f);
            HashMap<Integer,Member> mapInFile = new HashMap<Integer,Member>();

            //CRAWLING IN MY SKIN, THESE WOUNDS THEY WILL NOT HEAL :^(
            String currentLine;
            while(sc.hasNextLine()) {
                currentLine= sc.nextLine();
                //LocalDate MarkDate = LocalDate.of(1996, 10, 30);
                MemberIdGenerator memberIdGenerator2 = new MemberIdGenerator();
                //Member Mark = new Member("Mark", MarkDate, "Lygten 37", "8888888", true, memberIdGenerator2);

                //GET KEY AND USERDATA
                String[] member = currentLine.split("=");
                String[] memberData =member[1].split(",");

                String name = memberData[0];
                String birthDate = memberData[1];
                String address = memberData[2];
                String isActive = memberData[3];
                String membership = memberData[3];
                String phone = memberData[5];
                String ID = memberData[6];

                //String birthDate[] = birth.split["-"];
                LocalDate birthFix = LocalDate.of(9999, 1, 30);

                Member tmpMember = new Member(name,birthFix,address,phone,false,memberIdGenerator2);
                mapInFile.put(Integer.parseInt(member[0]),tmpMember);

            }

            System.out.println(mapInFile);
            return mapInFile;

        } catch(Exception e) {
            HashMap<Integer,Member> mapInFile = new HashMap<Integer,Member>();
            return mapInFile;
        }
    }
}
