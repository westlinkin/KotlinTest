package com.lifeofcoding.kotlintest

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import android.widget.Toast
import com.lifeofcoding.java.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.simple_list_item_1.view.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val data: ArrayList<String> = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(this.toolbar)

        this.fab.setOnClickListener(View.OnClickListener { view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show() })

        for (i in 0..100) {
            this.data.add("item " + i)
        }

        this.recyclerView.setLayoutManager(LinearLayoutManager(this))
        this.recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST))
        this.recyclerView.adapter = Adapter(data)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    class Adapter(val data: ArrayList<String>) : RecyclerView.Adapter<ViewHolder>() {

        override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
            holder?.bind(data.get(position))
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
            val inflater = LayoutInflater.from(parent!!.getContext())
            val view = inflater.inflate(R.layout.simple_list_item_1, parent, false)

            val holder = ViewHolder(view)
            holder.itemView.text1.setOnClickListener(View.OnClickListener {
                val string = data.get(holder.adapterPosition)
                Toast.makeText(holder.itemView.context, string, Toast.LENGTH_SHORT).show()
            })
            return holder
        }

        override fun getItemCount(): Int {
            return data.count()
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(string: String) {
            itemView.text1.text = string
        }
    }
}
