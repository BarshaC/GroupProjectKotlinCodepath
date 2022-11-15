package com.example.flexzonecodepathgroupproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.parse.ParseQuery

open class StreakFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_streak, container, false)
        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = StreakFragment().apply {  }
    }
    protected open fun queryStreakUser() {
        val query = ParseQuery.getQuery(User::class.java)
        query.include(User.KEY_STREAK);
    }


}