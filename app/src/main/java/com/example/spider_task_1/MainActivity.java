package com.example.spider_task_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private int stones[] = {R.id.power_stone, R.id.mind_stone, R.id.soul_stone, R.id.space_stone, R.id.time_stone, R.id.reality_stone};
    private float stoneStatus[] = {0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout mainView = (LinearLayout) findViewById(R.id.main_view);
        mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reverseGravity((int) Math.floor(Math.random() * stones.length), v.getHeight());
            }
        });
    }

    private void reverseGravity(int stone_id, int mainViewHeight) {
        ImageView stone = (ImageView) findViewById(stones[stone_id]);
        float toYValue = stoneStatus[stone_id] == 0? 1 - (1f*stone.getHeight()/mainViewHeight): 0;
        Animation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, stoneStatus[stone_id], Animation.RELATIVE_TO_PARENT, toYValue);
        stoneStatus[stone_id] = toYValue;
        animation.setFillAfter(true);
        animation.setDuration(1000);
        stone.startAnimation(animation);
    }


}
