package Competition;


import Service.UserInput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static void TeamCreation() throws FileNotFoundException {
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
