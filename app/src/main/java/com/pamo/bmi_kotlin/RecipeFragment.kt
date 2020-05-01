package com.pamo.bmi_kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_recipe.*

class RecipeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var items: Array<String> = this.resources.getStringArray(R.array.ingridientsList)
        val adapter: ArrayAdapter<String> =
            ArrayAdapter(context!!, android.R.layout.simple_list_item_1, items)
        ingridientListView.setAdapter(adapter)
    }
}
