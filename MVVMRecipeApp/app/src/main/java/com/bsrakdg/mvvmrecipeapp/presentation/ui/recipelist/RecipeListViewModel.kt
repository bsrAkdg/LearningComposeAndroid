package com.bsrakdg.mvvmrecipeapp.presentation.ui.recipelist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bsrakdg.mvvmrecipeapp.domain.model.Recipe
import com.bsrakdg.mvvmrecipeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val repository: RecipeRepository,
    @Named("auth_token") private val token: String
) : ViewModel() {

    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query = mutableStateOf("Chicken")

    init {
        searchRecipes()
    }

    private fun searchRecipes() {
        viewModelScope.launch {
            val result = repository.search(token, 1, "chicken")
            recipes.value = result
        }
    }

    fun onQueryChanged(query: String) {
        this.query.value = query
    }
}