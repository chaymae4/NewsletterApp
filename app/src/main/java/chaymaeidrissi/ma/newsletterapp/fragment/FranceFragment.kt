package chaymaeidrissi.ma.newsletterapp.fragment

import android.content.ClipData
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import chaymaeidrissi.ma.newsletterapp.R
import chaymaeidrissi.ma.newsletterapp.adapter.ListArticlesAdapter
import chaymaeidrissi.ma.newsletterapp.adapter.ListArticlesHandler
import chaymaeidrissi.ma.newsletterapp.data.ArticleRepository
import chaymaeidrissi.ma.newsletterapp.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FranceFragment: Fragment(),ListArticlesHandler{
    private lateinit var recyclerView: RecyclerView
    private lateinit var politics: ClipData.Item
    private lateinit var business: ClipData.Item
    private lateinit var health: ClipData.Item
    private lateinit var science: ClipData.Item

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.articles, container, false)

        politics = view.findViewById(R.id.Politique)
        business = view.findViewById(R.id.Business)
        health = view.findViewById(R.id.Health)
        science = view.findViewById(R.id.Science)

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getArticles()

        setHasOptionsMenu(true)
        getArticlesByCategory("politics")

       /* politics.setOnClickListener {
            getArticlesByCategory("politics")} */

       /* science.setOnClickListener {
            getArticlesByCategory("science")
        }*/
    }
        override fun getArticles(query: String, fragment: String) {
        TODO("Not yet implemented")
    }

    override fun showDetails(article: Article) {
        TODO("Not yet implemented")
    }
        private fun getArticlesByCategory(category:String){
            lifecycleScope.launch(Dispatchers.IO) {
                val articles = ArticleRepository.getInstance().getArticlesByCategory("fr",category)
                bindData(articles.articles)
            }
        }
    private fun bindData(articles: List<Article>){
        val adapter = ListArticlesAdapter(articles,this)
        lifecycleScope.launch(Dispatchers.Main) {
            recyclerView.adapter = adapter
        }
    }

}