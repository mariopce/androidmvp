package eu.saramak.learnenglishwords;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by mario on 07.01.15.
 */
public class WordsMockPresenter implements WordsPresenter {
    private WordsSceenView view;
    @Inject
    WordsDataStore dataStore;
    private Subscription sub;

    public WordsMockPresenter(WordsSceenView wordsSceenView) {
        view = wordsSceenView;
    }

    @Singleton
    @Component(modules = WordsProviderModule.class)
    interface WordsAppComponent extends eu.saramak.learnenglishwords.WordsAppComponent {
        void init(WordsMockPresenter presenter);
    }


    public void setDataStore(WordsDataStore dataStore) {
        this.dataStore = dataStore;
    }

    @Override
    public void onResume() {
        WordsAppComponent wm = Dagger_WordsMockPresenter$WordsAppComponent.builder().wordsProviderModule(new WordsProviderModule()).build();
        wm.init(this);
        view.showProgress();

        sub = dataStore.getWords(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Words>() {
            @Override
            public void call(Words words) {
                view.enableNextButton();
                view.enablePrevButton();
                view.showWord("dfs");
            }
        });

    }

    @Override
    public void onPause() {
        sub.unsubscribe();
    }

    @Override
    public void nextWord() {

    }

    @Override
    public void prevWord() {

    }

    @Override
    public String getWord() {
        return null;
    }
}
