package chaymaeidrissi.ma.newsletterapp.util

import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import chaymaeidrissi.ma.newsletterapp.R

interface ToolbarManager {
    val toolbar:Toolbar
    //initialisation le toolbar
    fun initMainToolBar(){
        toolbar.title = "Newsletter"
        toolbar.inflateMenu(R.menu.main)
        println("did it")
       /* toolbar.setOnMenuItemClickListener(object  :Toolbar.OnMenuItemClickListener{
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                when(item?.itemId){
                    R.id.setting->{

                    }
                }
            }

        })*/
    }
}