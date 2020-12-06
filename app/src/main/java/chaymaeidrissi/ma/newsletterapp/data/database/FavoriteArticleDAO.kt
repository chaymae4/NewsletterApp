package chaymaeidrissi.ma.newsletterapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import chaymaeidrissi.ma.newsletterapp.models.ArticleFavorite

@Dao
interface FavoriteArticleDAO {
    @Query("SELECT * FROM ArticleFavorite ORDER BY id DESC")
    fun getAll(): LiveData<List<ArticleFavorite>>

    @Query("SELECT title FROM ArticleFavorite")
    fun getAllFavoriteArticlesTitle(): LiveData<MutableList<String>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(favoriteArticle: ArticleFavorite)

    @Delete
    suspend fun delete(favoriteArticle: ArticleFavorite)

    @Query("DELETE FROM ArticleFavorite WHERE title = :articleTitle")
    suspend fun deleteFavoriteByArticleTitle(articleTitle: String)
}
