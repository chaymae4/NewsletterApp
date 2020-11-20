package chaymaeidrissi.ma.newsletterapp.data.service

import chaymaeidrissi.ma.newsletterapp.models.Article
import chaymaeidrissi.ma.newsletterapp.models.ArticleResponse

interface ArticleService {
    fun getArticlesByCountry(country: String): ArticleResponse
    fun getArticlesByCategory(country: String, category: String): ArticleResponse
}