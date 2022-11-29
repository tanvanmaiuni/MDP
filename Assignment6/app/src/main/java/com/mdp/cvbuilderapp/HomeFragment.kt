package com.mdp.cvbuilderapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mdp.cvbuilderapp.model.User


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    val user = User("Tan Mai", "image", "Software Engineer",
        "Completed on-campus studies and currently taking distance education courses to complete Master's Degree in Computer Science (Available full-time, W-2 employment).",
        "Language: Java, Kotlin \n Frameworks: Spring Boot, Hibernate, React"
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}