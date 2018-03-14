package com.example.eman.daggertry;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Eman on 3/13/2018.
 */

@Module
public class ContextModule {
    private final Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Provides
    public Context context(){
        return context;
    }
}
