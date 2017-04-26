package com.matuszew.braintri_tumblr.common.di.module;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.matuszew.braintri_tumblr.BuildConfig;
import com.matuszew.braintri_tumblr.R;
import com.matuszew.braintri_tumblr.common.di.container.BraintriTumblrApplication;
import com.matuszew.braintri_tumblr.common.util.SessionUtil;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by matuszewski on 24/04/2017.
 */

@Module
public class NetworkApiModule {


    @Singleton
    @Provides
    public Retrofit providesRetrofit(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Request.Builder builder = request.newBuilder();
                builder.url(request.url().toString()
                       .replace(BraintriTumblrApplication.getApplication().getString(R.string.url_placeholder),
                       SessionUtil.getSessionValue(R.string.tumblr_user_session)));
                request = builder.method(request.method(), request.body()).build();

                Response response = chain.proceed(request);

                MediaType contentType = response.body().contentType();
                ResponseBody body = ResponseBody.create(contentType,response.body().string()
                        .replace(BraintriTumblrApplication.getApplication()
                                .getString(R.string.tumblr_json_body_prefix), ""));

                return response.newBuilder().body(body).build();
            }
        });

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
