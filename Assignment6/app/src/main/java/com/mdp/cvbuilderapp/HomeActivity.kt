package com.mdp.cvbuilderapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(HomeFragment(), "Home")
        adapter.addFragment(AboutMeFragment(), "About me")
        adapter.addFragment(WorkFragment(), "Work")
        adapter.addFragment(ContactFragment(), "Contact")

        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

//        toolbar.setOnMenuItemClickListener{ menuItem -> {
//            when(menuItem.itemId){
//                R.id.menu_linkedin ->{
//                    val intent = Intent(this, WebActivity::class.java)
//                    intent.putExtra("url", R.string.contact_linkedIn)
//                    startActivity(intent)
//                    return@setOnMenuItemClickListener true
//                }
//                R.id.menu_logout ->{
//                    finish()
//                    return@setOnMenuItemClickListener true
//                }
//                else -> false
//            }
//        }}


    }

    @SuppressLint("RestrictedApi")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_menu, menu)
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        when(item.itemId){
            R.id.menu_linkedin ->{
                val intent = Intent(this, WebActivity::class.java)
                intent.putExtra("url", getString(R.string.contact_linkedIn))
                startActivity(intent)
            }
            R.id.menu_github ->{
                val intent = Intent(this, WebActivity::class.java)
                intent.putExtra("url", getString(R.string.contact_github))
                startActivity(intent)
            }
            R.id.menu_logout ->{
                finishAffinity();
            }
        }
        return super.onOptionsItemSelected(item)
    }
}