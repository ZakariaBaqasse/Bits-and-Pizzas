package com.example.bitsandpizzas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class OrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_order, container, false)
        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{
            val radioGroup = view.findViewById<RadioGroup>(R.id.pizza_group)
            val selectedPizza = radioGroup.checkedRadioButtonId
            if(selectedPizza==-1)Toast.makeText(activity,"You haven't selected a pizza type!",Toast.LENGTH_SHORT).show()
            else{
                var text = when(selectedPizza){
                    R.id.radio_diavolo-> "Divalo pizza"
                    else->"Funghi Pizza"
                }
                val parmesan = view.findViewById<Chip>(R.id.parmesan)
                text+= if(parmesan.isChecked)", extra Parmesan" else ""
                val chiliOil = view.findViewById<Chip>(R.id.chili_oil)
                text+= if(chiliOil.isChecked)", extra Chili Oil" else ""
                Snackbar.make(fab,text,Snackbar.LENGTH_SHORT).show()
            }
        }
        return view
    }

}