package com.example.flexzonecodepathgroupproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var tvMuscleNameDetail : TextView
    private lateinit var tvDescriptionDetail: TextView
    private lateinit var detailImageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvMuscleNameDetail = findViewById(R.id.tvMuscleNameDetail)
        tvDescriptionDetail = findViewById(R.id.tvDetailDescription)
        detailImageView = findViewById(R.id.detailImageView)

        val postMuscleDetail = intent.getParcelableExtra<StreamMuscle>(MUSCLE_EXTRA) as StreamMuscle
        tvMuscleNameDetail.text = postMuscleDetail.name
        tvDescriptionDetail.text = postMuscleDetail.description
        Glide.with(this).load(postMuscleDetail.mainImage?.file).into(detailImageView)
    }
}