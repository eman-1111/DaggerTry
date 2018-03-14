package com.example.eman.daggertry.screens;


import com.example.eman.daggertry.GithubApplicationComponent;
import com.example.eman.daggertry.network.GithubService;
import com.example.eman.daggertry.screens.home.AdapterRepos;

import dagger.Component;

@HomeActivityScope
@Component(modules = HomeActivityModule.class, dependencies = GithubApplicationComponent.class)
public interface HomeActivityComponent {
     AdapterRepos adapterRepos();
     GithubService getGithubService();
}
