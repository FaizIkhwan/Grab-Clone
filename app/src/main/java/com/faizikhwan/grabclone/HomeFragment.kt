package com.faizikhwan.grabclone


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var items: MutableList<Ads> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        val gridLayoutManager = GridLayoutManager(context, 2)

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

        rv_data_ads.layoutManager = gridLayoutManager
        rv_data_ads.setHasFixedSize(true)
        rv_data_ads.adapter = adsAdapter
    }
}
