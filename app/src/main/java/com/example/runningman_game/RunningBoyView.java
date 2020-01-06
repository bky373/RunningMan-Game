package com.example.runningman_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class RunningBoyView extends View {

    Bitmap backGround;
    Bitmap mountain;

    static Context context;
    private MyThread mThread;
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
    int whichScreen = 1;
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
        this.context = context;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Display display = ((WindowManager) this.context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        Point p11 = new Point();

        display.getSize(p11);
        Height = p11.y;
        Width = p11.x;
        gameTime = Width;
        scoreBasic = Width / 14; // 점수 나오는 시간 조정

        Bitmap imgLeft = BitmapFactory.decodeResource(getResources(), R.drawable.btnleft);
        imgLeft = Bitmap.createScaledBitmap(imgLeft, Width / 11, Width / 11, true);

        Bitmap imgRight = BitmapFactory.decodeResource(getResources(), R.drawable.ball);

        // 공
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        ball = Bitmap.createScaledBitmap(ball, Width / 9, Width / 9, true);

        bWidth = ball.getWidth() / 2;
        bHeight = bWidth;
        ball_x = 100;
        ball_y = -200;

        // 배경 - 버스
        schoolBus = BitmapFactory.decodeResource(getResources(), R.drawable.minibus);
        schoolBus = Bitmap.createScaledBitmap(schoolBus, Width / 4, Width / 9, true);
        schoolBus_x = Width * 2 / 3;
        schoolBus_y = Height / 2;

        // 배경 그림
        backGround = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        backGround = Bitmap.createScaledBitmap(schoolBus, Width / 4, Width / 9, true);

        // 화면 배치 등에 사용된 버튼 크기의 기본값 설정
        basicUnit = imgLeft.getWidth();
        basicUnit2 = Height / 10;
        btnLeft = new MyButton(imgLeft, 0, Height - basicUnt - basicUnit / 2);
        btnRight = new MyButton(imgRight, Width - btnLeft.w, Height - basicUnit - basicUnit / 2);

        // 게임 중 나가기 버튼
        exit = BitmapFactory.decodeResource(context.getResources(), R.drawable.exit);
        exit_x = Width * 3 / 5;
        exit_y = basicUnit / 4;
        exit_width = exit.getWidth();
        exit_height = exit.getHeight();

        help = BitmapFactory.decodeResource(context.getResources(), R.drawable.help);
        help = Bitmap.createScaledBitmap(help, Width / 9, Width / 9, true);
        help_x = Width - help.getWidth() - basicUnit / 6;
        help_y = basicUnit / 4 + help.getWidth() + basicUnit / 8;

        button_width = help.getHeight();

        btnStart = BitmapFactory.decodeResource(context.getResources(), R.drawable.btnstart);
        btnStart = Bitmap.createScaledBitmap(btnStart, Width / 4, Width / 13, true);
        btnStart_width = btnStart.getWidth();
        btnStart_height = btnStart.getHeight();

        btnStart_x = Width / 2 - btnStart_width / 2;
        btnStart_y = Height * 3 / 4;

        mountain = BitmapFactory.decodeResource(context.getResources(), R.drawable.mountain);
        mountain = Bitmap.createScaledBitmap(mountain, Width, Height / 2, true);

        timeImage = BitmapFactory.decodeResource(context.getResources(), R.drawable.timeimage);
        timeImage = Bitmap.createScaledBitmap(timeImage, Width / 7, basicUnit / 2, true);
        timeImage_w = timeImage.getWidth();

        sRunningBoy = new RunningBoy(context, Height);

        if (mThread == null) {
            mThread = new MyThread();
            mThread.start();
        }

        p1 = new Paint();
        p1.setColor(Color.WHITE);

        paintRed.setColor(Color.RED);
        paintRed.setTextSize(30);

        pAlpha = new Paint();
        pAlpha.setAlpha(85);
    }

    void moveBall() {

        ball_y += Height / 70;
        if(ball_y>Height + 100) makeBall();
    }
    //TODO 학원일이 쉽지 않다..
}
