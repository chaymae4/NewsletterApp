package chaymaeidrissi.ma.newsletterapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import chaymaeidrissi.ma.newsletterapp.R
import chaymaeidrissi.ma.newsletterapp.fragment.FranceFragment
import chaymaeidrissi.ma.newsletterapp.models.Article
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


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
    

   //     override fun onBindViewHolder(holder:ViewHolder, position: Int) {
    //        val article: Article = mArticle[position]

    //        holder.title.text = article.title
    //        holder.content.text = article.content

            //val context = holder.itemView
      //  }
            override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                val article: Article = mArticle[position]
                holder.title.text = article.title
                holder.content.text = article.content
                val context = holder.itemView

                Glide.with(context)
                    .load(article.urlToImage)
                    .apply(RequestOptions.circleCropTransform())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .skipMemoryCache(false)
                    .into(holder.image)

            }



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
