package chaymaeidrissi.ma.newsletterapp

import android.view.View
import androidx.core.view.ViewCompat

class Splashactivity:ViewPropertyAnimatorListener {
    fun getLayoutId(){
        
    }
    fun initData(){
        val v: View = findViewById(R.id.imageview)
        ViewCompat.animate(v).scaleX(1.0f).scaleY(1.0f).setduration(2000)
    }

}