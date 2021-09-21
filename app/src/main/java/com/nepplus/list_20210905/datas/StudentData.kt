package com.nepplus.list_20210905.datas

class StudentData(
    val name: String,
    val birthYear: Int,
    val address: String) {

//    이 사람의 나이를 계산해 주는 기능
//    연도를 넣으면 그 해의 나이를 계산
    fun getKoreanAge(year : Int ) : Int{
        val koreanAge = year - this.birthYear + 1

            return koreanAge
    }
}