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
    @Component(modules = AndroidModule.class)
    interface ApplicationComponent {
        void inject(WordsApplication application);
    }

    @Inject
    LocationManager locationManager;


    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationComponent component = Dagger_WordsApplication$ApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();


        component.inject(this);

        List<String> providers = locationManager.getAllProviders();
        for(String prov : providers){
            Log.d(TAG, "dataStore " + prov);
        }
    }
}
