package com.bsrakdg.mvvmrecipeapp.di

import com.bsrakdg.mvvmrecipeapp.network.RecipeService
import com.bsrakdg.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.bsrakdg.mvvmrecipeapp.util.Constants
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeDtoMapper = RecipeDtoMapper()

    @Singleton
    @Provides
    fun provideRecipeService(): RecipeService = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()
        .create(RecipeService::class.java)

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken(): String = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
}