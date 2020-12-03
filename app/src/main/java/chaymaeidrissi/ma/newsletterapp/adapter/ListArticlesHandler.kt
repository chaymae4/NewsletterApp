package chaymaeidrissi.ma.newsletterapp.adapter

import chaymaeidrissi.ma.newsletterapp.models.Article

interface ListArticlesHandler {
    fun getArticles(query: String, fragment: String)
    fun showDetails(article: Article)
}