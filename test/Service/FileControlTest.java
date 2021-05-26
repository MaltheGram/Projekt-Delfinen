/*
 * @author Mark "Massive Legend" Larsen
 * 19/05/2021 11.24
 *
 * DAT21V2-Projekt-Delfinen
 *
 */

package Service;

import Finance.Payment;
import Finance.PaymentLog;
import Member.Member;
import Member.MemberList;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.*;
import java.util.HashMap;
import java.io.File;
import java.io.FilenameFilter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class FileControlTest {
    static String filename;
    static String filename2;

    @BeforeEach
    void setup() {
        filename = "testSerializableEmpty";
        filename2 = "testSerializableDetails";

    }
    @Test
    void readSerializableFromEmptyFile() {
        //method acts differently based on if it finds preexisting file, here is both
        //if there is no file, generates file and returns new hashmap
        var serializable =FileControl.readSerializableFromFile(filename, new HashMap<>());
        assertTrue(serializable.isEmpty());

        //file now exists, reads file
        var serializable2 =FileControl.readSerializableFromFile(filename, new HashMap<>());
        assertTrue(serializable2.isEmpty());
    }
    @Test
    void ReadAndWriteSerializableFromFileTest() {
        HashMap serializableObjectEmpty = new HashMap<>();
        HashMap serializableObjectData = new HashMap<String,String>();
        serializableObjectData.put("hej","farvel");

        FileControl.writeSerializableToFile(serializableObjectData,filename2);

        //if files exist, file data is returned, if not, serializableObjectEmpty is returned
        HashMap<String,String> readObject = (HashMap<String, String>) FileControl.readSerializableFromFile(filename2,serializableObjectEmpty);
        HashMap<String,String> readObject2 = (HashMap<String, String>) FileControl.readSerializableFromFile(filename,serializableObjectEmpty);

        assertFalse(readObject.isEmpty());
        assertTrue(readObject.size()==1);

        assertTrue(readObject2.isEmpty());

    }

    @AfterAll
    public static void cleanUp(){
        File f = new File(filename + ".ser");
        f.delete();
        File f2 = new File(filename2 + ".ser");
        f2.delete();
        assertFalse(f.exists());
        assertFalse(f2.exists());
    }

}