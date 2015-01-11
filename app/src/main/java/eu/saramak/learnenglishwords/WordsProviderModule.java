package eu.saramak.learnenglishwords;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 10.01.15.
 */
@Module(injects = WordsDataStore.class)
public class WordsProviderModule {

    private final WordsSceenView view;

    public WordsProviderModule(WordsSceenView view){
        this.view = view;
    }

    @Provides
    WordsSceenView provideWordsSceenView(){
        return view;
    }

    @Provides
    WordsDataStore provideWordsProvider(){
        return new SlowWordsProvider();
    }

    @Provides
    WordsPresenter providerWordsPresenter(WordsMockPresenter impl){
        return impl;
    }

}
