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
    @Inject WordsProvider provider;
    private Subscription sub;

    public WordsMockPresenter(WordsSceenView wordsSceenView) {
        view = wordsSceenView;
    }

    @Singleton
    @Component(modules = WordsProviderModule.class)
    interface WordsShop {
        void provide(WordsMockPresenter presenter);
    }


    public void setProvider(WordsProvider provider) {
        this.provider = provider;
    }

    @Override
    public void onResume() {
        WordsShop wm = Dagger_WordsMockPresenter$WordsShop.builder().wordsProviderModule(new WordsProviderModule(this)).build();
        wm.provide(this);
        view.showProgress();

        sub = provider.getWords(1).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Words>() {
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
