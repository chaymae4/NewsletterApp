package chaymaeidrissi.ma.newsletterapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import chaymaeidrissi.ma.newsletterapp.NavigationListener
import chaymaeidrissi.ma.newsletterapp.R

class AcceuilFragment : Fragment(), RadioGroup.OnCheckedChangeListener{

    private lateinit var button: Button
    private lateinit var li: RadioGroup
    private lateinit var Fr: RadioButton
    private lateinit var An: RadioButton
    private lateinit var Us: RadioButton
    private lateinit var Ch: RadioButton
    private lateinit var Mr: RadioButton






    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.acceuil, container, false)

        button = view.findViewById(R.id.button)

        li = view.findViewById(R.id.rg_lan)

        Fr = view.findViewById(R.id.Fr)
        An = view.findViewById(R.id.An)
        Us = view.findViewById(R.id.Us)
        Ch = view.findViewById(R.id.Ch)
        Mr = view.findViewById(R.id.Mr)





        li.setOnCheckedChangeListener(this)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button.setOnClickListener {
            (activity as? NavigationListener)?.let {
                if (Fr.isChecked)   it.changeFragment(FranceFragment( ))
                if (An.isChecked)   it.changeFragment(AngleterreFragment())
                if (Us.isChecked)   it.changeFragment(UsFragment())
                if (Ch.isChecked)   it.changeFragment(ChineFragment())
                if (Mr.isChecked)   it.changeFragment(MarocFragment())




            }
        }

    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        button.isEnabled = Fr.isChecked || An.isChecked|| Us.isChecked|| Ch.isChecked|| Mr.isChecked
    }


}
