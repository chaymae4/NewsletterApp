package chaymaeidrissi.ma.newsletterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import chaymaeidrissi.ma.newsletterapp.R
import chaymaeidrissi.ma.newsletterapp.fragment.ArticlesFragment
import chaymaeidrissi.ma.newsletterapp.models.Article



class ListArticlesAdapter(
    items: List<Article>,
    val handler: ListArticlesHandler
) : RecyclerView.Adapter<ListArticlesAdapter.ViewHolder>(){

        private val mArticle: List<Article> = items

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)

            return ViewHolder(view)

        }

        override fun onBindViewHolder(holder:ViewHolder, position: Int) {
            val article: Article = mArticle[position]

            holder.title.text = article.title
            holder.content.text = article.content

            //val context = holder.itemView

        }

   //     fun isArticleFav(article: Article):Boolean{
      //      for (item: Article in handler.getListArticlesFav()){
     //           if (item.url == article.url) return true
//
     //       }
        ///    return false

    //    }

        override fun getItemCount(): Int {
            return mArticle.size
        }

        class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
            val title: TextView
            val content: TextView
            val image: ImageView
            val favorits: Button
            init {
                title = view.findViewById(R.id.title)
                content = view.findViewById(R.id.content)
                image = view.findViewById(R.id.image)
                favorits = view.findViewById(R.id.btn_favoris)
            }
        }


}
