package chaymaeidrissi.ma.newsletterapp.adapter

import chaymaeidrissi.ma.newsletterapp.models.Article

interface ListArticlesHandler {
    abstract fun getListArticlesFav(): List<Article>

}