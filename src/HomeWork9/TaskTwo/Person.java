package HomeWork9.TaskTwo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Person {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.txt"));
        List<String> list = new ArrayList<>();

        while (scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }
        list.remove(0);

        List<User> users = new ArrayList<>();
        for (String str : list){
            String [] array = str.split(" ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            users.add(new User(name,age));

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(users);
            System.out.println(json);
        }
    }
}

