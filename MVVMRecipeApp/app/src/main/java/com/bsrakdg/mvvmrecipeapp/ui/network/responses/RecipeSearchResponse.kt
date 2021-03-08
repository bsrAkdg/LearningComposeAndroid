package com.bsrakdg.mvvmrecipeapp.ui.network.responses

import com.bsrakdg.mvvmrecipeapp.ui.network.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeNetworkEntity>,
)