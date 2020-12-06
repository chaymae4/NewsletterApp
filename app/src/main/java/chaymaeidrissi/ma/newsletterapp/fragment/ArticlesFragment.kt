package chaymaeidrissi.ma.newsletterapp.fragment

import android.os.Bundle
import android.view.*
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

class ArticlesFragment: Fragment(),ListArticlesHandler {
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
     ): View? {
        val view = inflater.inflate(R.layout.articles, container, false)

        recyclerView = view.findViewById(R.id.articles_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )

        // Set cut corner background for API 23+
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            view.product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
//        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        getArticles("business")
    }

    /**kkll
     * Récupère la liste des articles dans un thread secondaire
     */
    private fun getArticles(category: String) {
        lifecycleScope.launch(Dispatchers.IO) {

            val articles = ArticleRepository.getInstance().getArticlesByCategory("fr", category)
            bindData(articles.articles)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.main, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }

    /**
     * Rempli le recyclerview avec les données récupérées dans le web service
     * Cette action doit s'effectuer sur le thread principale
     * Car on ne peut mas modifier les éléments de vue dans un thread secondaire
     */
    private fun bindData(articles: List<Article>){
        val adapter = ListArticlesAdapter(articles,this)
        lifecycleScope.launch(Dispatchers.Main) {

            recyclerView.adapter = adapter
        }
    }

    override fun getListArticlesFav(): List<Article> {
        TODO("Not yet implemented")
    }


}