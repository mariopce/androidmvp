package eu.saramak.learnenglishwords;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario on 10.01.15.
 */
@Module(injects = WordsDataStore.class)
public class WordsProviderModule {

    @Provides
    WordsDataStore provideWordsProvider(){
        return new SlowWordsProvider();
    }
}
