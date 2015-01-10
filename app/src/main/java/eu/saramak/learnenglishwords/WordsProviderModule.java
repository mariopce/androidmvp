package eu.saramak.learnenglishwords;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 10.01.15.
 */
@Module
public class WordsProviderModule {
    @Provides WordsProvider provideWordsProvider(){
        return new SlowWordsProvider();
    }
}
