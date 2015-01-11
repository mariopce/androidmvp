package eu.saramak.learnenglishwords;

import rx.Observable;

/**
 * Created by mario on 07.01.15.
 */
public interface WordsDataStore {
    public Observable<Words> getWords(int page);
}
