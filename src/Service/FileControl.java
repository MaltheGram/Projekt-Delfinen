/*
 * @author Mark "Massive Legend" Larsen
 * 19/05/2021 11.24
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Service;

import java.io.*;

public class FileControl {
    public static <T extends Serializable> void writeSerializableToFile(T serializableObject, String filename){
        try {
            //WRITE FILE
            FileOutputStream write = new FileOutputStream(new File(filename + ".ser"));
            ObjectOutputStream o = new ObjectOutputStream(write);

            o.writeObject(serializableObject);

            // TODO: move closing statements to finally, because closing can also go wrong. Example below.
            //CLEAN UP
            https://stackoverflow.com/questions/2699209/java-io-ugly-try-finally-block
            o.close();
            write.close();

            //PRINT LOADED
            System.out.println("Serializable added to file:");
            System.out.println(serializableObject);

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static <T extends Serializable> T readSerializableFromFile(String filename, T defaultReturn) {
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

        } catch(IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
            return defaultReturn;
        }
    }
}
