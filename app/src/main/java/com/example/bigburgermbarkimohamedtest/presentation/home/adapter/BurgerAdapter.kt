package com.example.bigburgermbarkimohamedtest.presentation.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bigburgermbarkimohamedtest.databinding.ItemBurgerBinding
import com.example.bigburgermbarkimohamedtest.usescase.burgerMenu.model.BurgerMenuUIModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BurgerAdapter @Inject constructor(@ApplicationContext private val application: Context) :
    RecyclerView.Adapter<BurgerAdapter.ViewHolder>() {
    private var burgerList: List<BurgerMenuUIModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemBurgerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(burgerList[position])

    override fun getItemCount(): Int = burgerList.size

    inner class ViewHolder(private val binding: ItemBurgerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(burgerModel: BurgerMenuUIModel) {
            binding.apply {
                titelBurger.text = burgerModel.title
                burgerRef.text = burgerModel.ref.toString()
                burgerDesc.text = burgerModel.description
                burgerPrice.text = "${burgerModel.price} €"
                Glide.with(root.context)
                    .load(burgerModel.thumbnail)
                    .into(circleImageView)
            }
        }
    }
    fun setBurgers(listBurger:List<BurgerMenuUIModel>){
        this.burgerList = listBurger
        notifyDataSetChanged()
    }
}