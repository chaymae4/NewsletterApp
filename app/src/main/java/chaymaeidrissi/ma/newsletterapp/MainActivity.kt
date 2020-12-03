package chaymaeidrissi.ma.newsletterapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import chaymaeidrissi.ma.newsletterapp.fragment.ArticlesFragment
import chaymaeidrissi.ma.newsletterapp.util.ToolbarManager
import org.jetbrains.anko.find

class MainActivity : AppCompatActivity(), ToolbarManager{
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(ArticlesFragment())
    }

    override fun initMainToolBar() {
        initMainToolBar()
    }
     fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }
}



