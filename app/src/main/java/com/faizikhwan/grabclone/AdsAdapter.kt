package com.faizikhwan.grabclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_ads.view.*

internal class AdsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivAdsImage = itemView.iv_ads_image
    val tvAdsTitle = itemView.tv_ads_title
    val ivTypeImage = itemView.iv_type_image
    val tvDate = itemView.tv_date
}

class AdsAdapter(val items: MutableList<Ads>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val ONE_ADS_TYPE = 1
    val TWO_ADS_TYPE = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AdsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AdsViewHolder) {
            val ads = items[position]

            holder.tvAdsTitle.text = ads.title
            holder.tvDate.text = ads.date
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (items[position].type == ONE_ADS_TYPE) {
            return ONE_ADS_TYPE
        } else {
            return TWO_ADS_TYPE
        }
    }
}