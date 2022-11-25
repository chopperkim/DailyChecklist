package kr.co.pigland.dailychecklist

import com.google.gson.annotations.SerializedName
import java.sql.Date

data class CheckItem(
    val seq: Int,
    val checkType: String,
    @SerializedName("content")
    val checkContent: String,
    @SerializedName("title")
    val typeTitle: String
) {
    private var createDate: Date? = null
    private var modifyDate: Date? = null
}