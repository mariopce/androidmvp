package eu.saramak.learnenglishwords;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 07.01.15.
 */
public class Words {

    private List<String> words = new ArrayList<>();
    public void addWord(String word){
        words.add(word);
    }
    public String get(int k) {
        return words.get(k);
    }
}
