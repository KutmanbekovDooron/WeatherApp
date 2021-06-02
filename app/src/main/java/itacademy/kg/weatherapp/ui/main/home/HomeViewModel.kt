package itacademy.kg.weatherapp.ui.main.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import itacademy.kg.weatherapp.model.Repository
import itacademy.kg.weatherapp.model.Weather

class HomeViewModel : ViewModel() {
    private var liveDataForCurrent =  MutableLiveData<Weather>()
    private var liveDataForList = MutableLiveData<List<Weather>>()

    val repository = Repository()

    fun getCurrentWeather(){
        liveDataForCurrent.value = repository.getCurrentWeather()
    }

    fun getListOfCities(){
        liveDataForList.value = repository.getWeatherForAWeak()
    }

    fun subscribeCity() : MutableLiveData<Weather>{
        return liveDataForCurrent
    }

     fun subscribeList() : MutableLiveData<List<Weather>>{
        return liveDataForList
     }



}