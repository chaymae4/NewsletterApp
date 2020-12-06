package chaymaeidrissi.ma.newsletterapp.data.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import chaymaeidrissi.ma.newsletterapp.data.FavoriteDataBase
import chaymaeidrissi.ma.newsletterapp.models.ArticleFavorite
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class FavoriteArticleViewModel (application: Application) : AndroidViewModel(application) {

    val getAllFavoriteArticles: LiveData<List<ArticleFavorite>>
    val getAllFavoriteArticlesTitle: LiveData<MutableList<String>>
    private val repository: FavoriteDataBase

    init {
        val favoriteArticleDao = AppDatabase.getDatabase(application).favoriteArticleDAO()
        repository = FavoriteDataBase(favoriteArticleDao)
        getAllFavoriteArticles = repository.getFavoriteArticles()
        getAllFavoriteArticlesTitle = repository.getAllFavoriteArticlesTitle()
    }

    fun insert(favoriteArticle: ArticleFavorite) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertArticleIntoFavorites(favoriteArticle)
        }
    }

    fun deleteFavoriteArticle(favoriteArticle: ArticleFavorite) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavoriteArticle(favoriteArticle)
        }
    }

    fun deleteFavoriteByArticleTitle(articleTitle: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavoriteByArticleTitle(articleTitle)
        }
    }

}