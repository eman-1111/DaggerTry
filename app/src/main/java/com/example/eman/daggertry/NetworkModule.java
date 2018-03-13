package com.example.eman.daggertry;

import android.content.Context;

import java.io.File;

import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;


public class NetworkModule {

    @Provides
    public OkHttpClient okHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    public Cache cache(File cacheFile) {
        return new Cache(cacheFile, 10 * 1000 * 1000); //10MB Cahe
    }
    @Provides
    public File cacheFile(Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }


}
