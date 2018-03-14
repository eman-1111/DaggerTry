package com.example.eman.daggertry.screens;


import com.example.eman.daggertry.GithubApplicationComponent;

import dagger.Component;

@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {
     void injectHomeActivity(HomeActivity homeActivity);
}
