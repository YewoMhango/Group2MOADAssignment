package com.example.group2moadassignment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


/**
 * A simple [Fragment] subclass representing a view of the details of a particular city
 */
class CityFragment : Fragment() {
    private var city: City = City.Lilongwe

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.render()
        // It's necessary to call this.render in onViewCreated 
        // because the changeToCity function gets called before
        // the onCreateView, so the changes made by this.render
        // in changeToCity get overwritten
    }

    /**
     * Change the content displayed in the fragment to match the specified city
     */
    fun changeCityTo(city: City) {
        this.city = city
        this.render()
    }

    /**
     * This sets the content displayed in the fragment's view based on the value of [city]
     */
    private fun render() {
        this.view?.findViewById<ImageView>(R.id.mainImage)
            ?.setImageResource(getImageResource())

        this.view?.findViewById<ImageView>(R.id.mainImage)
            ?.contentDescription = getCityName()

        this.view?.findViewById<TextView>(R.id.cityName)
            ?.text = getCityName()

        this.view?.findViewById<TextView>(R.id.cityDescription)
            ?.text = getCityDescription()

        this.view?.findViewById<TextView>(R.id.mustSeeAndDo)
            ?.text = getCityMustSeeAndDo()

        this.view?.findViewById<ImageView>(R.id.mapImage)
            ?.setImageResource(getMapResource())

        this.view?.findViewById<ImageView>(R.id.mapImage)
            ?.contentDescription = getCityMapDescription()
    }

    /**
     * Returns an image resource for the current city
     */
    private fun getImageResource(): Int {
        return when(this.city) {
            City.Zomba -> R.drawable.zomba_chancellor_college
            City.Lilongwe -> R.drawable.lilongwe_large
            City.Blantyre -> R.drawable.blantyre_large
            City.Mzuzu -> R.drawable.mzuzu_rbm
        }
    }
    
    /**
     * Returns the name of the current city
     */
    private fun getCityName(): String {
        return getString(when(this.city) {
            City.Zomba -> R.string.zomba_name
            City.Lilongwe -> R.string.lilongwe_name
            City.Blantyre -> R.string.blantyre_name
            City.Mzuzu -> R.string.mzuzu_name
        })
    }

    /**
     * Returns a description of the current city
     */
    private fun getCityDescription(): String {
        return getString(when(this.city) {
            City.Zomba -> R.string.zomba_description
            City.Lilongwe -> R.string.lilongwe_description
            City.Blantyre -> R.string.blantyre_description
            City.Mzuzu -> R.string.mzuzu_description
        })
    }

    /**
     * Returns a description of the "Must See and Do" for the current city
     */
    private fun getCityMustSeeAndDo(): String {
        return getString(when(this.city) {
            City.Zomba -> R.string.zomba_must_see_and_do
            City.Lilongwe -> R.string.lilongwe_must_see_and_do
            City.Blantyre -> R.string.blantyre_must_see_and_do
            City.Mzuzu -> R.string.mzuzu_must_see_and_do
        })
    }

    /**
     * Returns an image resource of the map for the current city
     */
    private fun getMapResource(): Int {
        return when(this.city) {
            City.Zomba -> R.drawable.zomba_map
            City.Lilongwe -> R.drawable.lilongwe_map
            City.Blantyre -> R.drawable.blantyre_map
            City.Mzuzu -> R.drawable.mzuzu_map
        }
    }

    /**
     * Returns a description of the map for the current city
     */
    private fun getCityMapDescription(): String {
        return getString(when(this.city) {
            City.Zomba -> R.string.zomba_map
            City.Lilongwe -> R.string.lilongwe_map
            City.Blantyre -> R.string.blantyre_map
            City.Mzuzu -> R.string.mzuzu_map
        })
    }
}