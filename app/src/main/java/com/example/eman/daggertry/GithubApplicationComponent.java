package com.example.eman.daggertry;

import com.example.eman.daggertry.network.GithubService;
import com.squareup.picasso.Picasso;

import dagger.Component;

@Component(modules = {GithubServiceModule.class, PicassoModule.class})
public interface GithubApplicationComponent {
    Picasso getPicasso();
    GithubService getGithubService();
}