package com.github.johnnysc.coremvvm.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import com.github.johnnysc.coremvvm.R
import com.github.johnnysc.coremvvm.presentation.FragmentFactory
import com.github.johnnysc.coremvvm.sl.ProvideViewModel
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity(), ProvideViewModel {

    private lateinit var viewModel: MainViewModel

    private lateinit var fragmentFactory: FragmentFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragmentFactory = BaseFragmentFactory(R.id.container, supportFragmentManager)

        viewModel = provideViewModel(MainViewModel::class.java, this)

        viewModel.observeNavigation(this) { navigationScreen ->
            fragmentFactory.fragment(navigationScreen)
        }

        val progress = findViewById<View>(R.id.progressLayout)

        viewModel.observeProgress(this) { visibility ->
            visibility.apply(progress)
        }

        viewModel.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        tabLayout.addOnTabSelectedListener(object : SimpleTabSelectedListener() {
            override fun onTabSelected(tab: TabLayout.Tab) = viewModel.chooseTab(tab.position)
        })
    }

    override fun <T : ViewModel> provideViewModel(clazz: Class<T>, owner: ViewModelStoreOwner): T =
        (application as ProvideViewModel).provideViewModel(clazz, owner)
}