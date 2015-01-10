package eu.saramak.learnenglishwords;

import android.view.View;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import rx.Observable;
import rx.Scheduler;
import rx.schedulers.TestScheduler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by mario on 07.01.15.
 */
@RunWith(RobolectricTestRunner.class)
@Config(manifest = "../app/src/main/AndroidManifest.xml")
public class WordsDisplayActivityTest {
    //@Test
    public void testWhenActivityCreatedHelloTextViewIsVisible() throws Exception {
        WordsDisplayActivity activity = new WordsDisplayActivity();

        ActivityController.of(activity).attach().create().resume();

        int visibility = activity.findViewById(R.id.container).getVisibility();
        assertEquals(visibility, View.VISIBLE);
    }

    @Test
    public void testWhenWeLoadWords() throws  Exception {

        final WordsSceenView view = mock(WordsSceenView.class);
        WordsPresenter presenter = new WordsMockPresenter(view);
//        presenter.setProvider(new WordsMemoryProvider());
        Scheduler.Worker worker = new TestScheduler().createWorker();
        WordsProvider prov = new SlowWordsProvider(){
            @Override
            public Observable<Words> getWords(int i) {
                return Observable.just(super.getWords(i).toBlocking().first());
            }
        }; //new WordsMemoryProvider();
        presenter.setProvider(prov);

        System.out.println("onResume 1");
        presenter.onResume();
        System.out.println("onResume 2");
        Robolectric.runUiThreadTasksIncludingDelayedTasks();
        verify(view).showProgress();
        verify(view).showWord(anyString());


    }
}
