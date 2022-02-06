package HomeWork9.TaskTree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class WordsCounter {

    public static void main(String[] args) throws IOException {

        String name = "words.txt";
        String content = reader(name);
        //Делаю одну строку
        content = content.replaceAll("\r", " ");
        //Убераю все двойные пробелы
        content = content.replaceAll("\\s+", " ");
        //Проверка на пробелы в начале и конце
        content = content.trim();

        //Делаю массив из слов
        String[] words = content.split(" ");
        System.out.println(Arrays.toString(words));

        //Считаем кол повторяющихся слов
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            if (hashMap.containsKey(word)) {
                int count = hashMap.get(word);
                hashMap.put(word, count + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        System.out.println(hashMap);
    }


    private static String reader(String lines) throws IOException {
        return new String(Files.readAllBytes(Paths.get(lines)));
    }
}
