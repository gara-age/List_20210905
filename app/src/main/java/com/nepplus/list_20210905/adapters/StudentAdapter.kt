package com.nepplus.list_20210905.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.nepplus.list_20210905.R
import com.nepplus.list_20210905.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext, resId, mList){


//    한 줄에 해당하는 xml + StudentData클래스의 정보 결합 -> 리스트뷰의 각 자리에 뿌려주자
//    xml로 그려둔 한 줄 모양을 => kt 안에서 활용할 수 있어야 한다.
//    용을 도와주는 도구도 필요하다.

        val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null){

            tempRow = mInflater.inflate(R.layout.student_list_item, null)


        }
//        tempRow 는 절대 null일 가능성이 없다 => 진짜 row 에 옮겨담자

        val row = tempRow!!

//        row가 결과로 나가기전에 -> 내부에 있는 텍스트뷰들을, 실제 데이터에 맞게 문구를 변경
//         최종 가공 후 결과로 나가자자

//        position의 값 : 위치에 맞는 데이터가, 누구의 데이터인지? 가져오자
        val data = mList[position]

//        row 내부에서 필요한 텍스트뷰 등 UI요소들을 가져오자
        val nameTxt = row.findViewById<TextView>(R.id.nameTxt)
        val addressTxt = row.findViewById<TextView>(R.id.addressTxt)
        val ageTxt = row.findViewById<TextView>(R.id.ageTxt)

        nameTxt.text = data.name
        addressTxt.text = data.address

        val age = 2021 - data.birthYear + 1
        ageTxt.text = "(${age}세)"

//      만들어진 row 를 getView 작업의 결과물로 지정

        return row

    }





}