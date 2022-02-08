package HomeWork9.TaskTree;

import java.io.*;
import java.util.*;

class Reader {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        reader.counter();
    }

    public String readerLines() throws IOException {
        //Считываем файл
        BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt"));
        //Мутим с строками
        StringBuilder str = new StringBuilder();
        // Добавляем элементы файла в СтрингБилдер
        for (String line; (line = bufferedReader.readLine()) != null; ) {
            str.append(line).append(" ");
        }
        return str + "";
    }

    public List<String> toArrayList() throws IOException {
        return Arrays.asList(readerLines().replaceAll("\\s+", " ").split(" "));
    }

    public void counter() throws IOException {

        HashSet<String> hList = new HashSet<>(toArrayList());
        List<String> sList = new ArrayList<>(hList);
        List<List<String>> result = new ArrayList<>();

        int count = 0;

        for (String value : sList) {
            for (String element : toArrayList()) {
                if (element.equals(value)) {
                    count++;
                }
            }
            result.add(Arrays.asList(String.valueOf(count), value, value + " " + count));
            count = 0;
        }
        result.sort(Comparator.comparing(o -> o.get(0)));

        Collections.reverse(result);

        for (List<String> strings : result) {
            System.out.println(strings.get(2));
        }
    }
}
