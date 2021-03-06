package com.codingwithmitch.mvvmrecipeapp.di

import com.codingwithmitch.mvvmrecipeapp.network.RecipeService
import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeMapper {
        return RecipeMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeService(): RecipeService {
        return Retrofit.Builder()
            .baseUrl("https://recipesapi.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }

}
















