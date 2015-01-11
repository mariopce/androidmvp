package eu.saramak.learnenglishwords;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mario on 11.01.15.
 */
@Singleton
@Component(modules = WordsProviderModule.class)
interface WordsAppComponent {
    void init(WordsMockPresenter presenter);
}