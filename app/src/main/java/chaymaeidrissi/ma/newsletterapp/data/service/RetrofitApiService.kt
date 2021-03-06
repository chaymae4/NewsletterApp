package chaymaeidrissi.ma.newsletterapp.data.service

import chaymaeidrissi.ma.newsletterapp.models.ArticleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitApiService {
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    // @GET("everything")
//    fun list(@Query("q") q:String): Call<ArticleResponse>


    @GET("top-headlines")
    fun listByCategory(@Query("country") country: String, @Query("category") category: String ): Call<ArticleResponse>

    @GET("top-headlines")
    fun listInitial(@Query("country") country: String): Call<ArticleResponse>
}