package com.example.vpage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vpage.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    lateinit var views:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        views= ActivityMainBinding.inflate(layoutInflater)

        setContentView(views.root)

        val vp=views.vpager
        val tabs=views.tabs

        val lista:ArrayList<myScreen> = ArrayList()

        lista.add(myScreen("https://ichef.bbci.co.uk/news/640/cpsprodpb/BF0D/production/_106090984_2e39b218-c369-452e-b5be-d2476f9d8728.jpg","La Guerra del Infinito","Internet"))
        lista.add(myScreen("https://indiehoy.com/wp-content/uploads/2020/08/avengers-endgame-1200x900.jpg","Juego Final","Internet"))
        lista.add(myScreen("https://lumiere-a.akamaihd.net/v1/images/the_avengers_2012_poster_july_disney_plus_drops_d4bd9c6e.png?region=0,169,1152,1152","Avengers","Internet"))
        lista.add(myScreen("https://media.gq.com.mx/photos/5cbf9d3d9277d83d2ae23c09/4:3/w_1064,h_798,c_limit/avengers%20endgame%20sin%20post%20creditos.jpg","Avengers 2","Internet"))
        lista.add(myScreen("https://elcomercio.pe/resizer/CeehGdBkvjdJgXDSfP3bcFRSU6I=/400x0/smart/filters:format(jpeg):quality(75)/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/3EEG2MWXKVAVFN2XPHQGLVAXTE.jpg","Capitana Marvel","Internet"))

        val adaptador=adapterVP2(lista)

        vp.adapter=adaptador

        val admin=TabLayoutMediator(tabs,vp,TabLayoutMediator.TabConfigurationStrategy({ t: TabLayout.Tab, p:Int->
            when(p){
                0->t.text="A"
                1->t.text="B"
                2->t.text="C"
                3->t.text="D"
                4->t.text="E"
            }
        }))
        admin.attach()

    }
}