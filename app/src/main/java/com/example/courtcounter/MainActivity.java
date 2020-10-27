package com.example.courtcounter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private  final  int scoreArray[]={1,2,3};
    private  int lastScore_a,lastScore_b,score_a,score_b;
    private Button button,button2,button3,button4,button5,button6;
    private Button button7;
    private TextView textView2,textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    private void inintView() {
        //获取按钮id
        button=findViewById(R.id.button);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        button4=findViewById(R.id.button4);
        button5=findViewById(R.id.button5);
        button6=findViewById(R.id.button6);


        //得分情况和清零
        button7=findViewById(R.id.button7);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);

        //按钮实现监听
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                scoreAdd(0,scoreArray[0]);

                break;
            case R.id.button2:
                scoreAdd(0,scoreArray[1]);

                break;
            case R.id.button:
                scoreAdd(0,scoreArray[2]);

                break;
            case  R.id.button6:
                scoreAdd(1,scoreArray[0]);

                break;
            case  R.id.button5:
                scoreAdd(1,scoreArray[1]);

                break;
            case  R.id.button4:
                scoreAdd(1,scoreArray[2]);

                break;
            case  R.id.button7:
                reset();
                break;
            default:
                break;
        }
    }

    //取消上次加分操作
    private void cancel() {
        if (score_a!=0&&score_a-lastScore_a>=0){
            score_a-=lastScore_a;
        }
        if (score_b!=0&&score_b-lastScore_b>=0){
            score_b-=lastScore_b;
        }
        ShowText();
    }

    //重置功能,弹出提示框
    private void reset() {

        textView2.setText("0");
        textView3.setText("0");
                       // score_a=0;
                       // score_b=0;
                        //ShowText();

                    }



    //进行加分
    private   void  scoreAdd(int Tage,int score){
        //Tage:   0:a  1:b
        if (Tage==0||Tage==1){
            if (Tage==0){
                //表示a进行加分
                lastScore_b=0;
                lastScore_a=score;
                score_a+=lastScore_a;
            }else if (Tage==1){
                //表示对b进行加分
                lastScore_a=0;
                lastScore_b=score;
                score_b+=lastScore_b;
            }
            ShowText();
        }
    }
    //进行显示
    private  void ShowText(){
        textView2.setText(Integer.toString(score_a));
        textView3.setText(Integer.toString(score_b));
    }
}