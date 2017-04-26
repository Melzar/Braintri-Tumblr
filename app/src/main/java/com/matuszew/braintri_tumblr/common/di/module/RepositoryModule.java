package com.matuszew.braintri_tumblr.common.di.module;

import com.matuszew.data.posts.PostsRepository;
import com.matuszew.data.posts.RetrofitPostsRepository;
import com.matuszew.data.posts.RetrofitPostsRest;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by matuszewski on 26/04/2017.
 */

@Module(includes = NetworkApiModule.class)
public class RepositoryModule {

    @Provides
    @Singleton
    @Named("remote")
    public PostsRepository provideRemotePostsRepository(Retrofit retrofit){
        return new RetrofitPostsRepository(retrofit.create(RetrofitPostsRest.class));
    }

}
