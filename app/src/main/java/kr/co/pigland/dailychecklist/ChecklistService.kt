package kr.co.pigland.dailychecklist

import retrofit2.Call
import retrofit2.http.GET

interface ChecklistService {
    @GET("checklist")
    fun checkContent(): Call<List<CheckItem>>
}