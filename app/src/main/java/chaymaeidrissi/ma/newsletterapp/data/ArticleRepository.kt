package chaymaeidrissi.ma.newsletterapp.data

import chaymaeidrissi.ma.newsletterapp.data.service.ArticleOnlineService
import chaymaeidrissi.ma.newsletterapp.models.ArticleResponse

class ArticleRepository {
    private val apiService: ArticleOnlineService = ArticleOnlineService()

    //fun getArticles(): ArticleResponse = apiService.getArticles()

    fun getArticlesByCategory(country: String, category: String) = apiService.getArticlesByCategory(country, category)
    fun getArticlesByCountry(country:String): ArticleResponse = apiService.getArticlesByCountry(country)

    companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository()
            }
            return instance!!
        }
    }
}