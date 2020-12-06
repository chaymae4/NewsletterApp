package chaymaeidrissi.ma.newsletterapp.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import chaymaeidrissi.ma.newsletterapp.NavigationListener
import chaymaeidrissi.ma.newsletterapp.R
import chaymaeidrissi.ma.newsletterapp.adapter.ListArticlesAdapter
import chaymaeidrissi.ma.newsletterapp.adapter.ListArticlesHandler
import chaymaeidrissi.ma.newsletterapp.data.FavoriteDataBase
import chaymaeidrissi.ma.newsletterapp.models.Article
import chaymaeidrissi.ma.newsletterapp.models.ArticleFavorite


class favorits: Fragment() {
      lateinit var recyclerView: RecyclerView
       companion object {
           fun newInstance(favorits: String): favorits {
              return favorits().apply {}
         }
 }

   override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
           savedInstanceState: Bundle?
       ): View? {
           return inflater.inflate(R.layout.favorits, container, false)
   }

   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
          super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recycler_view)
        val articlesfavorits = listOf<Article>()
         recyclerView.layoutManager = LinearLayoutManager(view.context)
      }
    }
