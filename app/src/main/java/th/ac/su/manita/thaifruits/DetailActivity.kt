package th.ac.su.manita.thaifruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_detail.tvTitle
import kotlinx.android.synthetic.main.activity_detail.tvCaption
import kotlinx.android.synthetic.main.activity_detail.tvDetail


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageDetail = intent.getStringExtra("imageDetail")
        val caption = intent.getStringExtra("caption")



        tvTitle.setText(title)
        tvCaption.setText(caption)
        tvDetail.setText(description)

//
//
        val res = resources
        val drawableId:Int = res.getIdentifier(imageDetail,"drawable",packageName)

        imgView.setImageResource(drawableId)

    }
}