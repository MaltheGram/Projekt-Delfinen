/*
 * @author Malthe
 * 20/05/2021 12.29
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Service;/*
 * @author Mark "Massive Legend" Larsen
 * 19/05/2021 11.24
 *
 * DAT21V2-Projekt-Delfinen
 *
 */
import Member.Member;
import Service.MemberIdGenerator;
import Member.MemberList;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileControl {
    public static void writeObjectToFile(MemberList serializableObject, String filename){
        try {
            //WRITE FILE
            FileOutputStream write = new FileOutputStream(new File(filename + ".ser"));
            ObjectOutputStream o = new ObjectOutputStream(write);

            o.writeObject(serializableObject);

            //CLEAN UP
            o.close();
            write.close();

        } catch(Exception e) {
            System.out.println(e);
        }
    }
    public static MemberList readMemberListfromFile(String filename){
        MemberList mapInFile = new MemberList();
        try {
            //READ FILE
            FileInputStream f = new FileInputStream(new File(filename + ".ser"));
            ObjectInputStream in = new ObjectInputStream(f);
            mapInFile = (MemberList)in.readObject();

            //CLEAN UP
            f.close();
            in.close();

            System.out.println(mapInFile);
            return mapInFile;

        } catch(Exception e) {
            System.out.println(e);
            return mapInFile;
        }
    }
}
