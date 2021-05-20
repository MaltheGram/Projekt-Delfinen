package Competition;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamCreation {
    public TeamCreation() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("list"));

        ArrayList<String> crawlteam = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("list"))) {
            while (br.ready()) {
                crawlteam.add(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

