package chaymaeidrissi.ma.newsletterapp.fragment

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
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
    private lateinit var politics: Button
    private lateinit var business: Button
    private lateinit var entertainment: Button
    private lateinit var general: Button
    private lateinit var health: Button
    private lateinit var science: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.articles, container, false)

        politics = view.findViewById(R.id.politics)
        business = view.findViewById(R.id.business)
        health = view.findViewById(R.id.health)
        science = view.findViewById(R.id.science)
        entertainment = view.findViewById(R.id.entertainment)
        general=view.findViewById(R.id.general)

        recyclerView=view.findViewById(R.id.articles_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticles()

        setHasOptionsMenu(true)

        politics.setOnClickListener {
            getArticlesByCategory("politics")
        }

       science.setOnClickListener {
            getArticlesByCategory("science")
        }
        business.setOnClickListener {
            getArticlesByCategory("business")
        }
        entertainment.setOnClickListener {
            getArticlesByCategory("entertainment")
        }
        general.setOnClickListener {
            getArticlesByCategory("general")
        }
        health.setOnClickListener {
            getArticlesByCategory("health")
        }
    }

   private fun getArticles() {
        lifecycleScope.launch (Dispatchers.IO){
            val articles = ArticleRepository.getInstance().getArticlesByCountry("fr")
            bindData(articles.articles)
        }

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