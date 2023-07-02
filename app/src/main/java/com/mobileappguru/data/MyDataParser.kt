package com.mobileappguru.data

import android.content.Context
import com.mobileappguru.androidtraining.R

class MyDataParser(private val context: Context) {
    fun parseData(): List<MyData> {
        val dataArray = context.resources.getStringArray(R.array.my_data_array)
        return dataArray.map { dataString ->
            val dataValues = dataString.split(",")
            val id = dataValues[0].toInt()
            val name = dataValues[1]
            val age = dataValues[2].toInt()
            MyData(id, name, age)
        }
    }
}