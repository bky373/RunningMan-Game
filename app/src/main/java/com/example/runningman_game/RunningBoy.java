package com.example.runningman_game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class RunningBoy {

    int imageCount = 0;
    int imageCount2 = 0;
    static int direction = 1; // 1 오른쪽으로, 2 왼쪽으로 주인공 움직임

    private float mSpeed; // 스피드
    public int x, y;
    Bitmap imgBoy[] = new Bitmap[16];

    // 현재 이미지
    public Bitmap image;
    public int w, h;
    int imageNum;
    int imageNum2 = 8;

    public RunningBoy(Context context, int height) {
        this.y = height / 2;
        for (int i = 0; i < 16; i++) {

            imgBoy[i] = BitmapFactory.decodeResource(context.getResources(), R.drawable.boy00 + i);

            int xWidth = RunningBoyView.Width / 9;
            int yWidth = RunningBoyView.Width / 7;

            imgBoy[i] = Bitmap.createScaledBitmap(imgBoy[i], xWidth, yWidth, true);

        }

        w = imgBoy[0].getWidth() / 2;
        h = imgBoy[0].getHeight() / 2;

        image = imgBoy[0];
        init();
    }

    private void init() {
        direction = 1; //오른쪽으로 이동
    }

//    else if(diretion ==1) image = imgBoy[imageNum];

    


}
