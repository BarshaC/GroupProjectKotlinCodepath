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
    private lateinit var tvWorkout1: TextView
    private lateinit var ivImageWk1: ImageView
    private lateinit var tvWorkout2 : TextView
    private lateinit var ivImageWk2 : ImageView
    private lateinit var tvWorkout3 : TextView
    private lateinit var  ivImageWk3 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        tvMuscleNameDetail = findViewById(R.id.tvMuscleNameDetail)
        tvDescriptionDetail = findViewById(R.id.tvDetailDescription)
        detailImageView = findViewById(R.id.detailImageView)
        tvWorkout1 = findViewById(R.id.tvWorkout1)
        ivImageWk1 = findViewById(R.id.ivWorkOut1)
        tvWorkout2 = findViewById(R.id.tvWorkout2)
        ivImageWk2 = findViewById(R.id.ivWorkout2)
        tvWorkout3 = findViewById(R.id.tvWorkout3)
        ivImageWk3 = findViewById(R.id.ivWorkout3)

        val postMuscleDetail = intent.getParcelableExtra<StreamMuscle>(MUSCLE_EXTRA) as StreamMuscle
        tvMuscleNameDetail.text = postMuscleDetail.name
        tvDescriptionDetail.text = postMuscleDetail.description
        Glide.with(this).load(postMuscleDetail.mainImage?.file).into(detailImageView)
        tvWorkout1.text = postMuscleDetail.wk1
        Glide.with(this).load(postMuscleDetail.workout1Img?.file).into(ivImageWk1)
        tvWorkout2.text = postMuscleDetail.wk2
        Glide.with(this).load(postMuscleDetail.workout2Img?.file).into(ivImageWk2)
        tvWorkout3.text = postMuscleDetail.wk3
        Glide.with(this).load(postMuscleDetail.workout3Img?.file).into(ivImageWk3)
    }
}