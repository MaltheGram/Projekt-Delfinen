/*
 * @author Mark "Massive Legend" Larsen
 * 19/05/2021 11.24
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Service;
import Member.Member;
import Service.MemberIdGenerator;
import Member.MemberList;
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class FileControl {
    public static <T extends Serializable> void writeSerializableToFile(T serializableObject, String filename){
        try {
            //WRITE FILE
            FileOutputStream write = new FileOutputStream(new File(filename + ".ser"));
            ObjectOutputStream o = new ObjectOutputStream(write);

            o.writeObject(serializableObject);

            //CLEAN UP
            o.close();
            write.close();

            //PRINT LOADED
            System.out.println("Serializable added to file:");
            System.out.println(serializableObject);

        } catch(Exception e) {
            System.out.println(e);
        }
    }
    //OBS - returns null on error!
    public static <T> T readSerializableFromFile(String filename, T type){
        try {
            //READ FILE
            FileInputStream f = new FileInputStream(new File(filename + ".ser"));
            ObjectInputStream in = new ObjectInputStream(f);
            T serializableObject = (T) in.readObject();

            //CLEAN UP
            f.close();
            in.close();

            System.out.println("Serializable loaded from file:");
            System.out.println(serializableObject);
            return serializableObject;

        } catch(Exception e) {
            System.out.println(e);
            return type;
        }
    }
}
