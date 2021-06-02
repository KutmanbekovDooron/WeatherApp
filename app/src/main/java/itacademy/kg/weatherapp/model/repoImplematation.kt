package itacademy.kg.weatherapp.model

interface RepoImplematation {
    fun getCurrentWeather() : Weather
    fun getWeatherForAWeak() : List<Weather>
}