package chaymaeidrissi.ma.newsletterapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import chaymaeidrissi.ma.newsletterapp.R

class AboutusFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater,
                          container: ViewGroup?,
                          savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.aboutus, container, false)
        // Set up the toolbar.
        //(activity as AppCompatActivity).setSupportActionBar(view.app_bar2)
        return view
    }


}