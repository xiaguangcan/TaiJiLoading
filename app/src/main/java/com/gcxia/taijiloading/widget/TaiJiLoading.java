package com.gcxia.taijiloading.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.gcxia.taijiloading.R;

/**
 * @author gcxia
 * @date 2017/6/28
 * @description
 */

public class TaiJiLoading extends LinearLayout {

    private AnimationSet set;

    public TaiJiLoading(Context context) {
        super(context);
        init(context);
    }

    public TaiJiLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TaiJiLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    /**
     * 保证太极是一个正方形
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    public void init(Context context){
        View.inflate(context, R.layout.view_taiji_loading, this);
        SquareLayout sl_square_layout = (SquareLayout) findViewById(R.id.sl_square_layout);
        CircleLayout cl_circle_1 = (CircleLayout) findViewById(R.id.cl_circle_1);
        CircleLayout cl_circle_2 = (CircleLayout) findViewById(R.id.cl_circle_2);

        ScaleAnimation zoomOutAnimation = (ScaleAnimation) AnimationUtils.loadAnimation(context, R.anim.circle_scale_1);
        cl_circle_1.setAnimation(zoomOutAnimation);
        ScaleAnimation zoomOutAnimation2 = (ScaleAnimation) AnimationUtils.loadAnimation(context, R.anim.circle_scale_2);
        cl_circle_2.setAnimation(zoomOutAnimation2);
        RotateAnimation rotateAnimation = (RotateAnimation) AnimationUtils.loadAnimation(context, R.anim.square_rotate);
        sl_square_layout.setAnimation(rotateAnimation);

        set = new AnimationSet(true);
        set.addAnimation(zoomOutAnimation);
        set.addAnimation(zoomOutAnimation2);
        set.addAnimation(rotateAnimation);
    }

    public void startTaiJi(){
        set.start();
    }

}
