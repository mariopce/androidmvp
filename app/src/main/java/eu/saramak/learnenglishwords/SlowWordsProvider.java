package eu.saramak.learnenglishwords;

import java.util.concurrent.TimeUnit;

import rx.Observable;

/**
 * Created by mario on 07.01.15.
 */
public class SlowWordsProvider implements WordsDataStore {
    @Override
    public Observable<Words> getWords(int page) {
        Words w = new Words();
        if (page == 1) {
            w.addWord("Mariusz");
            w.addWord("Agnieszka");
            w.addWord("Niewiem");
        }
        if (page == 2) {
            w.addWord("Mariusz 2");
            w.addWord("Agnieszka 2");
            w.addWord("Sara");
        } 
        return Observable.just(w).delay(5, TimeUnit.SECONDS);
    }
}
