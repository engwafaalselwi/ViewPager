package com.example.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var tabLayout: TabLayout
    lateinit var tabViewPager : ViewPager2


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabLayout = findViewById(R.id.tabs)
        tabViewPager = findViewById(R.id.viewPager) as ViewPager2
        //tabViewPager.setPageTransformer(false,PageTransformer)2

        val colors= listOf(
            R.color.orange,
            R.color.blue,
            R.color.red)

        val adpter=ViewpagerAdpter(colors)
        tabViewPager.adapter=adpter

        tabViewPager.setPageTransformer (ViewPager2.PageTransformer { PageTransformer, position -> Float })

        tabViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Toast.makeText(this@MainActivity,"This Page is  ${position + 1}",Toast.LENGTH_LONG).show()
            }

        })

     //   tabViewPager.adapter = object : FragmentStateAdapter(this){

         //   override fun getItemCount(): Int {
          //      return 3
        //    }
//


//            override fun createFragment(position: Int): Fragment {
//                return when(position ){
//                    0 -> FirstFragment.newInstance("first" , "fragment")
//
//                    1 -> SecondFragment.newInstance("second" , "fragment")
//                    2 -> ThirdFragment.newInstance("third" , "fragment")
//
//                    else->SecondFragment.newInstance("First","fragment")
//
//                }
//
//            }


     //   }

        TabLayoutMediator(tabLayout , tabViewPager){
            tab, position ->
            tab.text = when(position){

            0 -> "Personality"
            1 -> "Call"
            2 -> "Attach"

            else -> null
        }

        }.attach()

        setUpTabs()

    }

    private fun setUpTabs() {
    tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_accessibility_24)
    tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_add_ic_call_24)

    tabLayout.getTabAt(2)!!.setIcon(R.drawable.ic_baseline_attachment_24)


}
}



