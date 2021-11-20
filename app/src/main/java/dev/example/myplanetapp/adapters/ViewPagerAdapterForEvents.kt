package dev.example.myplanetapp.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapterForEvents (val items: ArrayList<Fragment>, activity: Fragment) : FragmentStateAdapter(activity)
{
    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        return items[position]
    }
}