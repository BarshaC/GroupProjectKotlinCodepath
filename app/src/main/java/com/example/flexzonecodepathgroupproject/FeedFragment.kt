package com.example.flexzonecodepathgroupproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.parse.ParseQuery

open class FeedFragment : Fragment() {
    private val TAG = this.javaClass.simpleName
    var allPosts: ArrayList<StreamMuscle> = ArrayList()
    private val postsAdapter by lazy { StreamAdapter(requireContext(), allPosts) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvPosts = view.findViewById<RecyclerView>(R.id.rvStream)
        rvPosts.adapter = postsAdapter
        rvPosts.layoutManager = LinearLayoutManager(requireContext())
        queryStreamPosts()

    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment().apply {  }
    }

    protected open fun queryStreamPosts() {
        val query = ParseQuery.getQuery(StreamMuscle::class.java)
        query.include(StreamMuscle.KEY_NAME)
        query.include(StreamMuscle.KEY_DESCRIPTION)
        query.include(StreamMuscle.KEY_MAIN_PIC)
        query.addAscendingOrder(StreamMuscle.KEY_CREATED_AT)
        query.findInBackground { posts, e ->
            if (e != null) {
                Log.e(TAG, "Issue with getting the stream",e)
                return@findInBackground
            }
            postsAdapter.clear()
            postsAdapter.addAll(posts as ArrayList<StreamMuscle>)
            postsAdapter.notifyDataSetChanged()
        }
    }

}