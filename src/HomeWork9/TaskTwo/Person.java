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
        //Считываем данные с файла
        Scanner scanner = new Scanner(new File("file.txt"));
        //Лист для записи данных
        List<String> list = new ArrayList<>();
        //Добавление элементов файла в лист
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        //Удаление лишнего
        list.remove(0);


        //Второй лист
        List<User> users = new ArrayList<>();
        //Цикл в котором всё мероприятие под каждого человека ... Alice ...
        for (String str : list) {
            String[] array = str.split(" ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            users.add(new User(name, age));
        }
        //Перевод в json формат
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);

        System.out.println(json);

    }
}

