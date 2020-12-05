package chaymaeidrissi.ma.newsletterapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import chaymaeidrissi.ma.newsletterapp.R

class AboutusFragment: Fragment() {

    companion object {
        fun newInstance(aboutus: String): aboutusFragment{
            return aboutusFragment().apply {}
        }
    }
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            setHasOptionsMenu(true)
            val view = inflater.inflate(R.layout.aboutus, container, false)
            return view
        }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

        }





}
