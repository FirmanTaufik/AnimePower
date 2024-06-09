package com.app.animepower.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.jsoup.Connection
import org.jsoup.Jsoup
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ModuleApp {



    @Singleton
    @Provides fun provideJsoupImple( ): JsoupImpl {
        return  JsoupImpl()
    }

}