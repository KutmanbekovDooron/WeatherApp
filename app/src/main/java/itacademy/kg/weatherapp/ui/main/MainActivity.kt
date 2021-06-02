package itacademy.kg.weatherapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import itacademy.kg.weatherapp.R
import itacademy.kg.weatherapp.databinding.ActivityMainBinding
import itacademy.kg.weatherapp.ui.main.cities.CitiesFragment
import itacademy.kg.weatherapp.ui.main.home.HomeFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.currentLocation -> setFragment(HomeFragment())
                R.id.listOfCities -> setFragment(CitiesFragment())
            }
            true
        }
    }

    private fun setFragment(fragment: Fragment){
        binding.containerFragment.visibility = View.VISIBLE
        binding.hello.visibility = View.GONE
        binding.welcome.visibility = View.GONE
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container_fragment,fragment)
            commit()
        }
    }


}