package com.example.runningman_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class RunningBoyView extends View {

    Bitmap backGround;
    Bitmap mountain;

    static Context sContext;
    private MyThread mMyThread;
    static int Width, Height;
    Bitmap ball;
    int ball_x, ball_y;
    int bWidth, bHeight;

    static public RunningBoy sRunningBoy;

    Bitmap schoolBus;
    int schoolBus_x, schoolBus_y;

    // 버튼
    MyButton btnLeft;
    MyButton btnRight;

    Bitmap btnStart;

    int btnStart_x;
    int btnStart_y;
    int btnStart_width;
    int btnStart_height;

    Bitmap timeImage;
    int timeImage_w;

    Bitmap exit; // 게임 안에서 나가기
    Bitmap help;
    int help_x, help_y;
    int button_width;

    int exit_x, exit_y;
    int exit_width;
    int exit_height;

    int gameTime;

    // 0이면 게임 시작 화면, 1이면 게임 시작 전 화면, 2이면 게임 결과 화면
    int whichScreen =1;
    int basicUnit;
    int basicUnit2; // 기기 세로 크기 Height을 기준으로 단위 크기 만들기

    int scoreBasic = 0;
    int player1Score;

    Paint paint = new Paint();
    Paint paintQuestion = new Paint();
    Paint paintB = new Paint();
    Paint paintBS = new Paint();

    Paint paintTitle = new Paint();

    Paint p1;
    Paint pAlpha;
    Paint paintRed = new Paint(); // 시간 표시에 사용

    public RunningBoyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.sContext= context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Display
    }



}
