package com.bsrakdg.mvvmrecipeapp.presentation.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.TextField
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bsrakdg.mvvmrecipeapp.domain.model.Recipe
import com.bsrakdg.mvvmrecipeapp.presentation.components.RecipeCard
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val recipes = viewModel.recipes.value

                //  val query = remember { mutableStateOf("beef")} 1. it will lost when configuration changed
                // val _query = savedInstanceState { "beef" } 2. You can receive the from savedInstanceState when configuration changed, or you can use viewModel
                val query = viewModel.query.value

                Column {
                    TextField(
                        value = query,
                        onValueChange = { newValue ->
                            viewModel.onQueryChanged(newValue)
                        }
                    )

                    Spacer(modifier = Modifier.padding(10.dp))

                    LazyColumn {
                        itemsIndexed(
                            items = recipes
                        ) { index: Int, recipe: Recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }
            }
        }
    }

}