package com.dygak.landmarkbookkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.dygak.landmarkbookkotlin.databinding.ActivityDetailsBinding
import com.dygak.landmarkbookkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        //Data
        val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
        val colosseum = Landmark("Colosseum", "Italy",R.drawable.colosseum)
        val eiffel = Landmark("Eiffel", "France",R.drawable.eiffel)
        val londonBridge = Landmark("London Bridge","UK",R.drawable.bridge)

        landmarkList.add(pisa)
        landmarkList.add(colosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        //Mapping: bir veriyi başka bir veriye benzetme
        //Adapter : Layout & Data'yı birbirine bağlayan ve aynı zamanda listview recyclerview gibi
        //veri setlerini göstereceğimiz görünümlere bağlanıp kullanıcıya bunları göstermemize olanak tanıyan yardımcı bir yapı

        //böylelikle xml ve yukarıdaki listeyi birbirine bağlamış olduk
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,landmarkList.map{landmark -> landmark.name})
        binding.listView.adapter = adapter
        
        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(MainActivity@this,DetailsActivity::class.java)
            intent.putExtra("landmark",landmarkList.get(position))
            startActivity(intent)
        }


    }


}