package eu.saramak.learnenglishwords;

/**
 * Created by mario on 07.01.15.
 */
public interface WordsPresenter {

    public void onResume();

    public void onPause();

    public void nextWord();

    public void prevWord();

    public String getWord();

    public void setProvider(WordsProvider wordsProvider);
}
