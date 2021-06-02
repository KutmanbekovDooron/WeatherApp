package itacademy.kg.weatherapp.model

class Repository :RepoImplematation {
    override fun getCurrentWeather(): Weather {
        //TODO Мы должны сделать запрос для палоучение данных о погоде
        return Weather("Moscow",55.78, 22.44 , 24, 23)
    }

    override fun getWeatherForAWeak(): List<Weather> {
        val weatherList = mutableListOf<Weather>()
         weatherList.add(Weather("Moscow",20.78, 23.64 , 43, 23))
         weatherList.add(Weather("Moscow",25.78, 73.74 , 13, 28))
         weatherList.add(Weather("Moscow",70.78, 25.68 , 25, 30))
         weatherList.add(Weather("Moscow",25.78, 15.68 , 85, 20))
         weatherList.add(Weather("Moscow",40.58, 24.60 , 20, 24))
        return weatherList
    }
}