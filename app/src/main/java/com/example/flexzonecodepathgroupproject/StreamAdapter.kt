package com.example.flexzonecodepathgroupproject

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val MUSCLE_EXTRA = "MUSCLE_EXTRA"
class StreamAdapter(val context: Context, val streamPosts: ArrayList<StreamMuscle>):
    RecyclerView.Adapter<StreamAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val tvMusclename = itemView.findViewById<TextView>(R.id.tvMuscleName)
        private val ivImage = itemView.findViewById<ImageView>(R.id.imageView)
        private val tvDescription = itemView.findViewById<TextView>(R.id.tvDescription)
        fun bind(muscle: StreamMuscle) {
            tvMusclename.text = muscle.name
            tvDescription.text = muscle.description
            Glide.with(context).load(muscle.mainImage?.file).into(ivImage)

        }
        init {itemView.setOnClickListener(this)
        }
        override fun onClick(v: View?){
            val streamPost = streamPosts[adapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MUSCLE_EXTRA,streamPost)
            context.startActivity(intent)
        }



        }
    fun clear() {
        streamPosts.clear()
        notifyDataSetChanged()
    }
    fun addAll(streamMuscles: ArrayList<StreamMuscle>) {
        streamPosts.addAll(streamMuscles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_stream_page, parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = streamPosts[position]
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return streamPosts.size
    }

}

