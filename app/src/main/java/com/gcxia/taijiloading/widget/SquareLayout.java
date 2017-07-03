package com.gcxia.taijiloading.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author gcxia
 * @date 2017/6/27
 * @description
 */

public class SquareLayout extends LinearLayout {
    private final Paint _paint = new Paint();

    public SquareLayout(Context context) {
        super(context);
        init();
    }

    public SquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SquareLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
        init();
    }

    private void init() {
        _paint.setAntiAlias(true);//使用抗锯齿功能
        _paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int x = getWidth();
        int y = getHeight();

        _paint.setColor(Color.parseColor("#000000"));
        RectF rectf_head = new RectF(0, 0, x, y);//确定外切矩形范围
        canvas.drawArc(rectf_head, 0, -180, false, _paint);//绘制圆弧，不含圆心
        _paint.setColor(Color.parseColor("#ffffff"));
        RectF rectf_foot = new RectF(0, 0, x, y);//确定外切矩形范围
        canvas.drawArc(rectf_foot, 0, 180, false, _paint);//绘制圆弧，不含圆心
        super.onDraw(canvas);
    }
}
