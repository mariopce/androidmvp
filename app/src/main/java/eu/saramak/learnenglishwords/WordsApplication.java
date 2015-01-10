package eu.saramak.learnenglishwords;

import android.app.Application;
import android.location.LocationManager;
import android.util.Log;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mario on 10.01.15.
 */
public class WordsApplication extends Application {

    private static final String TAG = "Words";

    @Singleton
    @Component(modules = AndroidModule.class) interface ApplicationComponent {
        void inject(WordsApplication application);
        void inject(WordsDisplayActivity activity);
        void inject(WordsMockPresenter presenter);
    }

    @Inject
    LocationManager locationManager; // for some reason.

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = Dagger_WordsApplication$ApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();

        component().inject(this);

        List<String> providers = locationManager.getAllProviders();
        for(String prov : providers){
            Log.d(TAG, "provider " + prov);
        }
    }

    public ApplicationComponent component() {
        return component;
    }
}
