package com.example.attila.mobilszoftlab.mock;

import com.example.attila.mobilszoftlab.network.NetworkConfig;
import com.example.attila.mobilszoftlab.network.book.BookApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {


    @Provides
    @Singleton
    public Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(NetworkConfig.ENDPOINT_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public BookApi provideBookApi(Retrofit retrofit) {
        return new MockBookApi();
    }

}
