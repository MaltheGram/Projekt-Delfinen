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

        //first iteration: no file exists, creates file and loads with premade serializable
        //second iteration: file exists, reads file and loads serializable
        for(int i = 0; i < 2; ++i) {
            var serializable =FileControl.readSerializableFromFile(filename, new HashMap<>());
            assertTrue(serializable.isEmpty());
        }

    }
    @Test
    void ReadAndWriteSerializableFromFileTest() {
        //delete all files beforehand
        cleanUp();

        HashMap serializableObjectEmpty = new HashMap<>();
        HashMap serializableObjectData = new HashMap<String,String>();
        serializableObjectData.put("hej","farvel");

        //first iteration: filename/filename2 does not exist, writeSerializableToFile creates new files.
        //second iteration: filename/filename2 does exist, writing overwrites old file
        for(int i = 0; i < 2; ++i) {
            //write map with data
            FileControl.writeSerializableToFile(serializableObjectData,filename2);

            //read it
            HashMap<String,String> readObject = (HashMap<String, String>) FileControl.readSerializableFromFile(filename2,serializableObjectEmpty);

            assertFalse(readObject.isEmpty());
            assertTrue(readObject.size()==1);

            //write map without data
            FileControl.writeSerializableToFile(serializableObjectEmpty,filename);

            //read it
            HashMap<String,String> readObject2 = (HashMap<String, String>) FileControl.readSerializableFromFile(filename,serializableObjectEmpty);

            assertTrue(readObject2.isEmpty());
        }
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