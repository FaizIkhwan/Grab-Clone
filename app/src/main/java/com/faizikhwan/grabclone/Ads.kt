package com.faizikhwan.grabclone

data class Ads(
    val title: String,
    val date: String,
    val type: Int
) {
    companion object {
        val TYPE_ONE = 1
        val TYPE_TWO = 2
    }
}
