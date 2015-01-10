package eu.saramak.learnenglishwords;

import rx.Observable;

/**
 * Created by mario on 07.01.15.
 */
public interface WordsProvider {
    public Observable<Words> getWords(int page);
}
