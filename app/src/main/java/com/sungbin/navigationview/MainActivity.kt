package com.sungbin.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import com.sungbin.navigationview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer(GravityCompat.START)
        }

        binding.naviView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.access -> Toast.makeText(this, "접근성", Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(this, "이메일", Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(this, "메세지", Toast.LENGTH_SHORT).show()

        }
        binding.layoutDrawer.closeDrawers() // 네비게이션 뷰 닫기
        return false
    }

    override fun onBackPressed() {
        if (binding.layoutDrawer.isDrawerOpen(GravityCompat.START)) {
            binding.layoutDrawer.closeDrawers()
        }
        else super.onBackPressed()
    }
}