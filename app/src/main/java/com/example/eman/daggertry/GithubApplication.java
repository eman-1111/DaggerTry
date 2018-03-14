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

    private GithubApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

         component = DaggerGithubApplicationComponent.builder()
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

    public GithubApplicationComponent component(){
        return component;
    }

}
