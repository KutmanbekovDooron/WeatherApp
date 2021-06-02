package itacademy.kg.weatherapp.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import itacademy.kg.weatherapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewMadel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewMadel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewMadel.getCurrentWeather()

        viewMadel.subscribeCity().observe(viewLifecycleOwner){
            binding.city.text = it.city
            binding.longtit.text = it.longitude.toString()
            binding.latit.text = it.latitude.toString()
            binding.tempFact.text = it.temparature.toString()
            binding.tempFeel.text = it.feelsLike.toString()
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}