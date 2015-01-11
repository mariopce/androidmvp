package eu.saramak.learnenglishwords;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import javax.inject.Inject;


public class WordsDisplayActivity extends FragmentActivity implements WordsSceenView {

    @Inject WordsPresenter presenter;
    private WordsDislpayerView wordDisplayerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_display);
        WordsAppComponent wm = Dagger_WordsMockPresenter$WordsAppComponent.builder().wordsProviderModule(new WordsProviderModule(this)).build();
        wm.init(this);
        if (savedInstanceState == null) {
            wordDisplayerFragment = new PlaceholderFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, (PlaceholderFragment) wordDisplayerFragment)
                    .commit();
        }


//        presenter.setDataStore(new SlowWordsProvider());
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_word_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void enableNextButton() {
        if (wordDisplayerFragment!=null)
        wordDisplayerFragment.enableButtons();
    }

    @Override
    public void enablePrevButton() {

    }

    @Override
    public void showWord(String text) {

    }

    @Override
    public void showProgress() {
        if (wordDisplayerFragment!=null)
        wordDisplayerFragment.disableButtons();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements WordsDislpayerView {

        private Button prevButton;
        private Button nextButton;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_word_display, container, false);
            prevButton = (Button) rootView.findViewById(R.id.prev_word_button);
            nextButton = (Button) rootView.findViewById(R.id.next_word_button);
            return rootView;
        }

        @Override
        public void disableButtons() {
            prevButton.setEnabled(false);
            nextButton.setEnabled(false);
        }

        @Override
        public void enableButtons() {
            prevButton.setEnabled(true);
            nextButton.setEnabled(true);
        }
    }
}
