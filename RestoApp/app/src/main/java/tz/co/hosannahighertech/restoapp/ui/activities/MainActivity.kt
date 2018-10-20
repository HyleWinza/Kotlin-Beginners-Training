package tz.co.hosannahighertech.restoapp.ui.activities

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import tz.co.hosannahighertech.restoapp.R
import tz.co.hosannahighertech.restoapp.ui.fragments.HotelsFragment
import tz.co.hosannahighertech.restoapp.ui.fragments.MyOrdersFragment
import tz.co.hosannahighertech.restoapp.ui.viewmodels.HotelsViewModel

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter
        tabs.setupWithViewPager(container)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.action_refresh ->{
                ViewModelProviders.of(this).get(HotelsViewModel::class.java).loadHotels()
            }
        }

        return super.onOptionsItemSelected(item)
    }


    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return when(position)
            {
                0-> HotelsFragment.newInstance()
                else -> MyOrdersFragment.newInstance()
            }
        }

        override fun getCount(): Int {
            return 2
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return when(position)
            {
                0-> "Hotels"
                else -> "My Orders"
            }
        }
    }

    fun showProgress(isProgress: Boolean?) {
        if(isProgress != null)
        {
            if(isProgress)
            {
                main_content.visibility = View.GONE
                progressBar.visibility = View.VISIBLE
            }
            else
            {

                progressBar.visibility = View.GONE
                main_content.visibility = View.VISIBLE
            }
        }
    }
}
