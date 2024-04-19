import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;

/**
 * Класс, содержащий методы для работы с файлом и подсчета статистики по словам.
 */
public class WordFileStatistics {

    /**
     * Метод для чтения данных из файла и подсчета количества каждого слова.
     * @param map Map для хранения слов и их количества
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public static void printFileData(Map<String, Integer> map) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String key = word.toLowerCase();
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
            System.out.println("Список всех фруктов и овощей и их количество:");
            map.forEach((k, v) -> System.out.println(k + " = " + v));
        }
    }

    /**
     * Метод для определения самого длинного слова в файле.
     * @param map Map для хранения слов и их количества
     * @return самое длинное слово
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public static String longestWord(Map<String, Integer> map) throws IOException {
        String longestWord = "";
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word.toLowerCase();
                    }
                }
            }
        }
        return longestWord;
    }

    /**
     * Метод для подсчета общего количества слов в файле.
     * @param map Map для хранения слов и их количества
     * @return общее количество слов в файле
     * @throws IOException если возникает ошибка ввода-вывода
     */
    public static int countOfWords(Map<String, Integer> map) throws IOException {
        LinkedList<String> listOfWords = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                Collections.addAll(listOfWords, words);
            }
        }
        return listOfWords.size();
    }
}