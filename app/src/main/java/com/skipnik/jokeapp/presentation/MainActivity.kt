package com.skipnik.jokeapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.skipnik.jokeapp.JokesAndQuotesApp
import com.skipnik.jokeapp.R
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val screens = listOf(
        JokesFragment::class.java,
        QuotesFragment::class.java
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = (application as JokesAndQuotesApp).get(MainViewModel::class.java, this)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val tabChosen: (Int) -> Unit = { position ->
            viewModel.save(position)
        }
        tabLayout.addOnTabSelectedListener(TabListener(tabChosen))
        viewModel.observe(this) { position ->
            tabLayout.getTabAt(position)?.select()
            show(screens[position].newInstance())
        }
        viewModel.init()
    }

    private fun show(fragment: BaseFragment<*, *>) = with(supportFragmentManager) {
        if (fragments.isEmpty() || fragments.last().tag != fragment.tag())
            beginTransaction()
                .replace(R.id.container, fragment, fragment.tag())
                .commit()
    }
}

private class TabListener(private val tabChosen: (Int) -> Unit) : TabLayout.OnTabSelectedListener {
    override fun onTabSelected(tab: TabLayout.Tab?) = tabChosen.invoke(tab?.position ?: 0)
    override fun onTabUnselected(tab: TabLayout.Tab?) = Unit
    override fun onTabReselected(tab: TabLayout.Tab?) = Unit
}