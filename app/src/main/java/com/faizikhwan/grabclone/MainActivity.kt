package com.faizikhwan.grabclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Ads> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMockAdsData()
        setupRecyclerView()
    }

    fun createMockAdsData() {
        items.add(Ads("Shop, feast, clean and more this CNY!", "Until 06 Feb", Ads.TYPE_ONE))
        items.add(Ads("Enjoy up to RM3000 worth of benefits", "1 min read", Ads.TYPE_ONE))
        items.add(Ads("Watch & Earn 10 Pts", "Sponsored by Hong Leong Bank", Ads.TYPE_TWO))
        items.add(Ads("Over 50 Yee Sang choinces on GrabFood", "Until 09 Feb", Ads.TYPE_ONE))
        items.add(Ads("Get 50% off on you GrabFood feast!", "1 min read", Ads.TYPE_ONE))
    }

    fun setupRecyclerView() {
        val adsAdapter = AdsAdapter(items)
        val gridLayoutManager = GridLayoutManager(this, 2)

        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                val viewType = adsAdapter.getItemViewType(position)
                if (viewType == adsAdapter.ONE_ADS_TYPE) {
                    return  1
                }
                else {
                    return 2
                }
            }
        }

        rv_data.layoutManager = gridLayoutManager
        rv_data.setHasFixedSize(true)
        rv_data.adapter = adsAdapter
    }
}
