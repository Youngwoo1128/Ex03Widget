package com.mac_available.ex03widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //화면에 보여지는 View들을 제어하는 참조변수를 멤버변수로
    TextView tv;
    Button btn;
    EditText et;

    int num=0;
    TextView tv2;

    String[] qs = new String[]{"사과", "집", "자동차"};
    String[] as = new String[]{"apple", "house", "car"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //참조변수에 객체 연결해주기.. xml에서 만든 View객체를 찾아와서 첨조변수에 대입. 원래 자바에서는 stream만들어서 인풋했음
        //액티비티클래스 객체는 본인이 보여주는 xml의 뷰들을 찾아오는 메소드가 이미 보유되어있음.
        tv = this.findViewById(R.id.aa); //this 샐약가능
        btn = findViewById(R.id.bb);
        et = findViewById(R.id.et);
        tv2 = findViewById(R.id.tv);

        //첫번째 문제체줄
        tv.setText(qs[num]);

        //버튼 클릭되는 것을 듣는 리스너객체 생성 및 설정
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //EditText에 써있는 글씨를 얻어오기..
                String s = et.getText().toString();

                if (s.equals(as[num])){
                    tv2.setText("정답");
                    num++;
                    if (num>2)num=0;
                    tv.setText(qs[num]);
                    et.setText("");
                }else{
                    tv2.setText("오답");
                    et.setText("");
                }
                //얻어온 글씨를 TextView에 보여주기
                tv.setText(s);

                //EditText의 글씨를 지우고싶다면
                et.setText("");
            }
        });
    }
}