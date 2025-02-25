package com.raflis.game_of_thrones.ui.feature.home.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.raflis.game_of_thrones.data.model.GoTCharacter
import com.raflis.game_of_thrones.data.repository.GoTCharacterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: GoTCharacterRepository) : ViewModel() {
    private val _groupedCharacters = MutableStateFlow(
        repository.getGoTCharacters()
            .sortedBy { it.name }
    )
    val groupedCharacters: StateFlow<List<GoTCharacter>> get() = _groupedCharacters

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedCharacters.value = repository.searchCharacters(_query.value)
            .sortedBy { it.name }
    }
}

class ViewModelFactory(private val repository: GoTCharacterRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}