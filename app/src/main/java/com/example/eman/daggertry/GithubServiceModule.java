package com.example.eman.daggertry;

import com.example.eman.daggertry.network.DateTimeConverter;
import com.example.eman.daggertry.network.GithubService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Eman on 3/13/2018.
 */

@Module(includes = NetworkModule.class)
public class GithubServiceModule {

    @Provides
    public GithubService getGithubService(Retrofit gitHubRetrofit){
        return gitHubRetrofit.create(GithubService.class);
    }

    @Provides
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(DateTime.class, new DateTimeConverter());
        return gsonBuilder.create();
    }

    @Provides
    public Retrofit getRetrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://api.github.com/")
                .build();

    }
}
