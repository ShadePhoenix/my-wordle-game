
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomWordSelect {
    public static void main(String[] args) {
        ParseWordList();
        System.out.println(wordList);
        System.out.println(GetWord());
    }

    private static List<String> wordList = new ArrayList<String>();

    private static List<String> usedWords = new ArrayList<String>();

    private static void ParseWordList() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("src/word-list.json")) {
            Object obj = jsonParser.parse(reader);
            JSONArray jsonWordList = (JSONArray) obj;
            wordList.addAll(jsonWordList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static String GetWord() {
        if (wordList.size() < 1)
            ParseWordList();
        Random random = new Random();
        String word = wordList.get(random.nextInt(wordList.size()));
        if (usedWords.contains(word))
            return GetWord();
        usedWords.add(word);
        return word;
    }
}
