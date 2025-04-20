package com.example.newbalance.models

import androidx.annotation.DrawableRes

data class Shoes(
    var name : String ,
    var price : String ,
    @DrawableRes var image : Int ,
    var rate : Float ,
    var liked : Boolean
)
