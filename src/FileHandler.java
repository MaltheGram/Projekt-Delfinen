/*
 * @author Mark "Massive Legend" Larsen
 * 19/05/2021 11.24
 *
 * DAT21V2-Projekt-Delfinen
 *
 */
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

            //VERSION 2.0
            /*
            FileOutputStream write = new FileOutputStream(new File(filename + ".txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);

            //Write in format
            for(Map.Entry<Integer,Member> m :map.entrySet()){
                o.writeObject(m)
            }
             */

            //Cleanup
            p.flush();
            p.close();
            write.close();
        } catch(Exception e) {}
    }
    public static HashMap<Integer,Member> readFile(String filename){
        try {
            File read = new File(filename + ".txt");
            FileInputStream f = new FileInputStream(read);
            Scanner sc = new Scanner(f);
            HashMap<Integer,Member> mapInFile = new HashMap<Integer,Member>();

            //CRAWLING IN MY SKIN, THESE WOUNDS THEY WILL NOT HEAL :^(
            String currentLine;
            while(sc.hasNextLine()) {
                currentLine= sc.nextLine();
                MemberIdGenerator memberIdGenerator2 = new MemberIdGenerator();

                //GET KEY AND USERDATA
                String[] member = currentLine.split("=");
                String[] memberData =member[1].split(",");

                String name = memberData[0];
                String birthDate = memberData[1];
                String address = memberData[2];
                boolean isActive = false;
                String membership = memberData[4];
                String phone = memberData[5];
                String ID = memberData[6];

                //RESTRUCTURE DATA TO FIT MEMBER-CONSTRUCTOR
                String birthDateSplit[] = birthDate.split("-");
                LocalDate birthFix = LocalDate.of(Integer.parseInt(birthDateSplit[0]), Integer.parseInt(birthDateSplit[1]), Integer.parseInt(birthDateSplit[2]));

                //if (memberData[3]=="true") {isActive = true;}

                //Member tmpMember = new Member(name,birthFix,address,phone,isActive,ID);
                //mapInFile.put(Integer.parseInt(member[0]),tmpMember);

                //Cleanup
                f.close();
                sc.close();
            }

            //VERSION 2.0
            /*
            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            boolean flag = true;
            while (flag) {
            try {
                Member tmpMember = (Member) oi.readObject();
                mapInFile.put(tmpMember.getID,tmpMember);
            } catch (Exception e) {
                flag = false;
            }
            */
            System.out.println(mapInFile);
            return mapInFile;

        } catch(Exception e) {
            HashMap<Integer,Member> mapInFile = new HashMap<Integer,Member>();
            return mapInFile;
        }
    }
}
