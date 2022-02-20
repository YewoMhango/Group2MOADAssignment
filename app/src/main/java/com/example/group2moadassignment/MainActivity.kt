package com.example.group2moadassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle


/**
 * Represents either one of the four main cities in Malawi
 */
enum class City {
    Blantyre,
    Lilongwe,
    Zomba,
    Mzuzu;

    override fun toString(): String {
        return when(this) {
            Blantyre -> "Blantyre"
            Lilongwe -> "Lilongwe"
            Zomba -> "Zomba"
            Mzuzu -> "Mzuzu"
        }
    }

    companion object {
        /**
         * Produces a new [City] enum value from a given string
         */
        fun fromString(string: String?): City {
            return when(string) {
                "Blantyre" -> Blantyre
                "Lilongwe" -> Lilongwe
                "Zomba" -> Zomba
                "Mzuzu" -> Mzuzu
                else -> Lilongwe
            }
        }
    }
}


class MainActivity : AppCompatActivity(), CitiesFragment.CityChanger {
    var city: City = City.Lilongwe
    var cityFragment: CityFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            this.city = City.fromString(savedInstanceState.getString("city"))
        }

        setContentView(R.layout.activity_main)

        this.cityFragment = CityFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainerView2, cityFragment!!)
            commit()
        }

        this.changeToCity(this.city)
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        if (savedInstanceState != null) {
            this.changeToCity(City.fromString(savedInstanceState.getString("city")))
            super.onRestoreInstanceState(savedInstanceState)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("city", this.city.toString())
    }

    /**
     * Changes the current city to the one matching the `city` parameter
     */
    override fun changeToCity(city: City) {
        this.city = city
        this.onSaveInstanceState(Bundle())
        cityFragment?.changeCityTo(city)
    }
}