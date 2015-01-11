package eu.saramak.learnenglishwords;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 10.01.15.
 */
@Module(injects = WordsProvider.class)
public class WordsProviderModule {

    private WordsMockPresenter presenter;

    public WordsProviderModule(WordsMockPresenter presenter){
        this.presenter = presenter;
    }


    @Provides WordsProvider provideWordsProvider(){
        return new SlowWordsProvider();
    }
}
