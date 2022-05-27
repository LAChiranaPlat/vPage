package com.example.vpage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vpage.databinding.ItemBinding

class adapterVP2(var screen:ArrayList<myScreen>):RecyclerView.Adapter<adapterVP2.Contenedor>() {

    lateinit var ctx:Context

    class Contenedor(vista:ItemBinding):RecyclerView.ViewHolder(vista.root) {

        val img: ImageView
        val txtName:TextView
        val txtAutor:TextView

        init {
            img=vista.imgAvatar
            txtName=vista.txtName
            txtAutor=vista.txtAutor
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterVP2.Contenedor {
        ctx=parent.context

        val contenedor=ItemBinding.inflate(LayoutInflater.from(ctx),parent,false)
        return Contenedor(contenedor)

    }

    override fun onBindViewHolder(holder: adapterVP2.Contenedor, position: Int) {

        val regCurrent=screen.get(position)

        holder.apply {

            txtName.text=regCurrent.name
            txtAutor.text=regCurrent.autor

            Glide
                .with(ctx)
                .load(regCurrent.image)
                .centerCrop()
                .placeholder(R.drawable.lga)
                .into(img);

        }

    }

    override fun getItemCount()=screen.size

}