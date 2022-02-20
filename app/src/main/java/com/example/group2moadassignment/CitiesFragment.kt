package com.example.group2moadassignment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass representing a set of buttons for selecting a particular city
 */
class CitiesFragment : Fragment() {
    /**
     * The parent activity, which is supposed to implement the [CityChanger] interface to enable it
     * to be communicated to by the [CitiesFragment] whenever the user changes to another city
     */
    private var cityChanger: CityChanger? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        cityChanger = context as CityChanger
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_cities, container, false)

        view.findViewById<Button>(R.id.button_lilongwe).setOnClickListener {
            this.cityChanger?.changeToCity(City.Lilongwe)
        }

        view.findViewById<Button>(R.id.button_blantyre).setOnClickListener {
            this.cityChanger?.changeToCity(City.Blantyre)
        }

        view.findViewById<Button>(R.id.button_mzuzu).setOnClickListener {
            this.cityChanger?.changeToCity(City.Mzuzu)
        }

        view.findViewById<Button>(R.id.button_zomba).setOnClickListener {
            this.cityChanger?.changeToCity(City.Zomba)
        }

        return view
    }

    /**
     * An interface meant to be implemented by the parent activity to enable it to be communicated 
     * to by the [CitiesFragment] whenever the user changes to another city by calling the
     * [changeToCity] function
     */
    interface CityChanger {
        fun changeToCity(city: City)
    }
}