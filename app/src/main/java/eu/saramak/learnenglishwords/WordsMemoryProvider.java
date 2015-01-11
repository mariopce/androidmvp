package eu.saramak.learnenglishwords;

import rx.Observable;

/**
 * Created by mario on 07.01.15.
 */
public class WordsMemoryProvider implements WordsDataStore {


    public Observable<Words> getWords(int page) {
        return Observable.just(new Words());
    }

}
