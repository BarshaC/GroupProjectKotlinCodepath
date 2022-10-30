package com.example.flexzonecodepathgroupproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.ParseUser

class MainActivity : AppCompatActivity() {
    val TAG = this.javaClass.simpleName
    private val bottomNavigation: BottomNavigationView by lazy {findViewById(R.id.bottomNavigationView)}
    private val fragmentManager: FragmentManager = supportFragmentManager
    private val feedFragment by lazy { FeedFragment.newInstance() }
    //private val streakFragment by lazy { StreakFragment.newInstance() }
    //private val profileFragment by lazy { ProfileFragment() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener {
            var fragment: Fragment = feedFragment
            when (it.itemId){
                R.id.streamTab -> {
                    fragment = feedFragment
                    Log.d(TAG, "Feed clicked")
                }
                R.id.streakTab -> {
                    fragment = feedFragment
                    Log.d(TAG, "Streak clicked")
                }

            }
            fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit()
            true
        }
        bottomNavigation.selectedItemId = R.id.streamTab
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "onOptionsSelected")
        when(item.itemId) {
            R.id.btnLogout -> {
                ParseUser.logOut()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return true
    }
}