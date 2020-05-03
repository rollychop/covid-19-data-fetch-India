package data

import com.google.gson.annotations.SerializedName

class CovidCases(@field:SerializedName("state_name") val state: String, @field:SerializedName("confirm_cases") val confirmedCases: String, @field:SerializedName("active_cases") val activeCases: String, @field:SerializedName("total_recovered") val totalRecovered: String, @field:SerializedName("total_deaths") val totalDeaths: String, @field:SerializedName("till_date") private val mDate: String, @field:SerializedName("till_time") private val mTime: String) {

    fun getmDate(): String {
        return mDate
    }

    fun getmTime(): String {
        return mTime
    }
}