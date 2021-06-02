package itacademy.kg.weatherapp.ui.main.cities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import itacademy.kg.weatherapp.R
import itacademy.kg.weatherapp.adaptor.WeatherAdaptor
import itacademy.kg.weatherapp.databinding.FragmentCitiesBinding
import itacademy.kg.weatherapp.model.Weather
import itacademy.kg.weatherapp.ui.main.home.HomeViewModel


class CitiesFragment : Fragment() {
    private var _binding: FragmentCitiesBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: HomeViewModel
    lateinit var adaptor: RecyclerView
    lateinit var weatherAdaptor: WeatherAdaptor
    var list = mutableListOf<Weather>()


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitiesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.getListOfCities()

        viewModel.subscribeList().observe(viewLifecycleOwner) {
            for (i in it.listIterator()) {
                list.add(i)
            }
        }

        adaptor = view.findViewById(R.id.parent)
        adaptor.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        adaptor.setHasFixedSize(true)
        weatherAdaptor = WeatherAdaptor(list)
        adaptor.adapter =weatherAdaptor

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}