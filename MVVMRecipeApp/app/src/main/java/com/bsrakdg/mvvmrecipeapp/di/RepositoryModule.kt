package com.bsrakdg.mvvmrecipeapp.di

import com.bsrakdg.mvvmrecipeapp.network.RecipeService
import com.bsrakdg.mvvmrecipeapp.network.model.RecipeDtoMapper
import com.bsrakdg.mvvmrecipeapp.repository.RecipeRepository
import com.bsrakdg.mvvmrecipeapp.repository.RecipeRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeMapper: RecipeDtoMapper,
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeService = recipeService,
            mapper = recipeMapper
        )
    }
}