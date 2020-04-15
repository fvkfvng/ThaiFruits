package th.ac.su.manita.thaifruits.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.list_item_fruit.view.*
import th.ac.su.manita.thaifruits.R
import java.util.zip.Inflater

class FruitAdapter(private val context: Context,
                   private val dataSource: ArrayList<Fruit>) : BaseAdapter(){

        private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item_fruit,null)

        rowView.tvTitle.text = dataSource[position].fruitName
        rowView.tvSubtitle.text = dataSource[position].caption

        val res = context.resources
        val drawableId:Int =
            res.getIdentifier(dataSource[position].imageFile,"drawable",context.packageName)

        rowView.imgThumbnail.setImageResource(drawableId)


        return rowView
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

}