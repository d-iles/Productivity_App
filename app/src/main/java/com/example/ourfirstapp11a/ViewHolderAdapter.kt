package com.example.ourfirstapp11a

/*import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_view_pager.view.*
//import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewHolderAdapter(pages: Int) : RecyclerView.Adapter<ViewHolderAdapter.ViewBindingExampleHolder>() {
    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    val pages1 = pages

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pages1
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.itemView.text1.text = "" + position
    }

    /* override fun createFragment(position: Int): Fragment {
         // Return a NEW fragment instance in createFragment(int)
         val fragment = DemoObjectFragment()
         fragment.arguments = Bundle().apply {
             // Our object is just an integer :-P
             putInt(ARG_OBJECT, position + 1)
         }
         return fragment
     }*/
}*/