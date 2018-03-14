package com.example.eman.daggertry;

import android.app.Activity;
import android.app.Application;

import com.example.eman.daggertry.network.GithubService;
import com.squareup.picasso.Picasso;

import timber.log.Timber;

/**
 * Created by Eman on 3/13/2018.
 */

public class GithubApplication extends Application {

    //   Activity

    //GithubService   picasso

    //retrofit    OkHttp3Downloader

    //gson      okhttp

    //      logger    cache

    //      timber           file

    public static GithubApplication get(Activity activity) {
        return (GithubApplication) activity.getApplication();
    }

    private GithubService githubService;

    private Picasso picasso;


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        GithubApplicationComponent component = DaggerGithubApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        githubService = component.getGithubService();
        picasso = component.getPicasso();
    }

    public Picasso getPicasso() {
        return picasso;
    }
    public GithubService getGithubService() {
        return githubService;
    }

}
