package th.ac.su.manita.thaifruits

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import th.ac.su.manita.thaifruits.Utils.getJsonDataFromAsset
import th.ac.su.manita.thaifruits.data.Fruit
import th.ac.su.manita.thaifruits.data.FruitAdapter

class MainActivity : AppCompatActivity() {

    var itemList:ArrayList<Fruit> = ArrayList<Fruit>()
    lateinit var arrayAdapter:ArrayAdapter<Fruit>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString = getJsonDataFromAsset(applicationContext,"fruit_data.json")

//        Log.i("data",jsonFileString)

        val gson = Gson()
        val listItemType = object : TypeToken<ArrayList<Fruit>>(){}.type

        var fruitList : ArrayList<Fruit> = gson.fromJson(jsonFileString,listItemType)

//        Log.i("data",fruitList[0].fruitName)

        itemList = fruitList
        val adapter = FruitAdapter(this@MainActivity, itemList)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->

            var intent = Intent(this@MainActivity,DetailActivity::class.java)

            intent.putExtra("title",itemList[position].fruitName)
            intent.putExtra("caption",itemList[position].caption)
            intent.putExtra("imageFile",itemList[position].imageFile)

            startActivity(intent)

        }
    }
}
