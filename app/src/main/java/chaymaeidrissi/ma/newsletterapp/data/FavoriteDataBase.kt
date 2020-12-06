package chaymaeidrissi.ma.newsletterapp.data

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.lifecycle.LiveData
import chaymaeidrissi.ma.newsletterapp.data.database.FavoriteArticleDAO
import chaymaeidrissi.ma.newsletterapp.models.ArticleFavorite

class FavoriteDataBase(private val favoriteArticleDAO: FavoriteArticleDAO) {

    fun getFavoriteArticles(): LiveData<List<ArticleFavorite>> = favoriteArticleDAO.getAll()

    fun getAllFavoriteArticlesTitle(): LiveData<MutableList<String>> = favoriteArticleDAO.getAllFavoriteArticlesTitle()

    suspend fun insertArticleIntoFavorites(favoriteArticle: ArticleFavorite) = favoriteArticleDAO.insert(favoriteArticle)

    suspend fun deleteFavoriteArticle(favoriteArticle: ArticleFavorite) = favoriteArticleDAO.delete(favoriteArticle)

    suspend fun deleteFavoriteByArticleTitle(articleTitle: String) = favoriteArticleDAO.deleteFavoriteByArticleTitle(articleTitle)

}