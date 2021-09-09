package com.nepplus.list_20210905

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nepplus.list_20210905.adapters.StudentAdapter
import com.nepplus.list_20210905.datas.StudentData
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

//    변수만 만들고, 대입은 나중에 => lateinit var
    lateinit var mAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        임시방편 : 코드에 타이핑해서, 학생 데이터 추가
        mStudentList.add(StudentData("조경진", 1988, "서울시 동대문구"))
        mStudentList.add(StudentData("김기만", 1972, "서울시 성북구"))
        mStudentList.add(StudentData("김성은", 1992, "서울시 중랑구"))
        mStudentList.add(StudentData("박광현", 1995, "서울시 동작구"))
        mStudentList.add(StudentData("유순정", 1992, "서울시 중랑구"))
        mStudentList.add(StudentData("이승엽", 1993, "경기도 고양시"))
        mStudentList.add(StudentData("전상효", 1996, "서울시 구로구"))
        mStudentList.add(StudentData("이진호", 1991, "서울시 동대문구"))
        mStudentList.add(StudentData("김다은", 1992, "서울시 동대문구"))
        mStudentList.add(StudentData("차수나", 1966, "서울시 동대문구"))
        mStudentList.add(StudentData("최민서", 2000, "서울시 동대문구"))

//        미뤄놨던 mAdapter의 대입을 해주자
        mAdapter = StudentAdapter(this, R.layout.student_list_item,mStudentList)

//        리스트뷰의 어댑터로 -> mAdapter가 역할을 하도록 연결시키자
        studentListView.adapter = mAdapter

//        리스트뷰의 각 줄이 눌렸을때 이벤트 처리

        studentListView.setOnItemClickListener { adapterView, view, position, l ->

//            세번째 변수 : position or i
//            Log.d("리스트뷰 눌린 줄",position.toString())

//            클릭된 사람의 이름을 토스트로 띄워보자

            val clickedStudent = mStudentList[position]

            Toast.makeText(this,clickedStudent.name,Toast.LENGTH_SHORT).show()
        }

        studentListView.setOnItemLongClickListener { adapterView, view, position, l ->
//            ~~가 길게 눌림. 토스트 출력

//            길게 눌린 학생 -> 목록(mStudentList)에서 제거 => 리스트뷰에서도 빠지게
            val clickedStudent = mStudentList[position]

//            Toast.makeText(this,"${clickedStudent.name}이(가) 길게 눌림",Toast.LENGTH_SHORT).show()

//            정말 그 학생을 삭제할건지? 물어보고 -> 확인을 눌렀을때만 삭제

            val alert = AlertDialog.Builder(this)
            alert.setTitle("학생 삭제 확인")
            alert.setMessage("정말 ${clickedStudent.name} 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialogInterface, i ->

//                확인까지 누르면 실행해줄 코드

                //            실제로 목록에서 제거시키기
                mStudentList.remove(clickedStudent)

//            리스트뷰의 어댑터에 -> 변경사항 확인 공지
                mAdapter.notifyDataSetChanged()

            })

            alert.setNegativeButton("취소",null)

            alert.show()



//            마지막에 결과로 true/ false로 지정 필요

            return@setOnItemLongClickListener true

        }



    }
}