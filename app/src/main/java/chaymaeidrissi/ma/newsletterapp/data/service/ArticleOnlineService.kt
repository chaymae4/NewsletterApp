package chaymaeidrissi.ma.newsletterapp.data.service

import chaymaeidrissi.ma.newsletterapp.models.Article
import chaymaeidrissi.ma.newsletterapp.models.ArticleResponse
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ArticleOnlineService : ArticleService {
    private val service: RetrofitApiService

    init {
        val retrofit = buildClient()
        //Init the api service with retrofit
        service = retrofit.create(RetrofitApiService::class.java)
    }

    /**
     * Configure retrofit
     */
    private fun buildClient(): Retrofit {
        val httpClient = OkHttpClient.Builder().apply {
            addLogInterceptor(this)
            addApiInterceptor(this)
        }.build()
        return Retrofit
            .Builder()
            .baseUrl(apiUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }

    /**
     * Add a logger to the client so that we log every request
     */
    private fun addLogInterceptor(builder: OkHttpClient.Builder) {
        val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        builder.addNetworkInterceptor(httpLoggingInterceptor)
    }

    /**
     * Intercept every request to the API and automatically add
     * the api key as query parameter
     */
    private fun addApiInterceptor(builder: OkHttpClient.Builder) {
        builder.addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val original = chain.request()
                val originalHttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apikey", apiKey)
                    .build()

                val requestBuilder = original.newBuilder()
                    .url(url)
                val request = requestBuilder.build()
                return chain.proceed(request)
            }
        })
    }

    override fun getArticles(q: String): ArticleResponse {
        TODO("Not yet implemented")
    }

    override fun getArticlesByCountry(country: String): ArticleResponse {
        return  service.listInitial(country).execute().body()!!
    }


    override fun getArticlesByCategory( country: String, category: String): ArticleResponse {
        return service.listByCategory(country, category).execute().body()!!
    }

    companion object {
        private const val apiKey = "7d6c49470a3a43cca225063d670558bf"
        private const val apiUrl = "https://newsapi.org/v2/"
    }

}