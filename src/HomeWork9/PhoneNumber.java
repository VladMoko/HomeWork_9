package HomeWork9;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    FileInputStream fis;

    public List<String> readLines() {
        //Место куда будем записывать значения
        List<String> reader = new ArrayList<>();

        //Вводим данные
        try {
            fis = new FileInputStream("Text.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Берём входящие данные и заносим их в лист
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("Text.txt"))) {
            for (String str; (str = bufferedReader.readLine()) != null; ) {
                reader.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    //Параметры отбора номеров
    public boolean isPhone(String number) {
        Pattern patternFirst = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");
        Pattern patternSecond = Pattern.compile("\\(\\d{3}\\)\\s\\d{3}-\\d{4}");

        Matcher matcher = patternFirst.matcher(number);
        Matcher matcher1 = patternSecond.matcher(number);

        return matcher.matches() || matcher1.matches();
    }

    //Вывод номеров
    public void printNumber() {
        List<String> list = readLines();
        for (int i = 0; i < list.size(); i++) {
            if (isPhone(readLines().get(i))) {
                System.out.println(readLines().get(i));
            }
        }
    }
}
