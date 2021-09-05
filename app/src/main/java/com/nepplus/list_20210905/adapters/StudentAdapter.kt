package com.nepplus.list_20210905.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.nepplus.list_20210905.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext, resId, mList){
}