package chaymaeidrissi.ma.newsletterapp.models

data class ArticleResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)

data class Article(
    val author: String,
    val title: String,
    val description: String,
    val urlToImage: String,
    val url:String,
    val publishedAt: String,
    val content: String
)