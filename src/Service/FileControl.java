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
            FileOutputStream write = new FileOutputStream(filename + ".ser");

            try (write; ObjectOutputStream o = new ObjectOutputStream(write)) {
                //WRITE & PRINT LOADED
                o.writeObject(serializableObject);
                System.out.println("\nSerializable added to file \"" + filename + ".ser\"");
                System.out.println(serializableObject);
            }
            //CLEANUP

        }  catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static <T extends Serializable> T readSerializableFromFile(String filename, T defaultReturn) {
        try {
            //READ FILE
            FileInputStream f = new FileInputStream(filename + ".ser");
            ObjectInputStream in = new ObjectInputStream(f);
            T serializableObject = defaultReturn;

            try {
                //READ AND PASTE OBJECT
                serializableObject = (T) in.readObject();
                System.out.println("\nSerializable loaded from \"" + filename+".ser\":");
                System.out.println(serializableObject);
            } finally {
                //CLEAN UP
                f.close();
                in.close();
            }

            return serializableObject;

        } catch(FileNotFoundException e) {
            System.out.println("\n\"" + filename +".ser\" file not found. Creating...");

            writeSerializableToFile(defaultReturn,filename);

            return defaultReturn;

        } catch(IOException | ClassCastException | ClassNotFoundException e) {
            e.printStackTrace();
            return defaultReturn;
        }
    }
}
