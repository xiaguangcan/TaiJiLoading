package com.gcxia.taijiloading.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.gcxia.taijiloading.R;

/**
 * @author gcxia
 * @date 2017/6/27
 * @description
 */

public class CircleLayout extends FrameLayout {

    public static int WHITE_TYPE = 1;
    public static int BLACK_TYPE = 2;

    private int circleType;
    private final Paint _whitePaint = new Paint();
    private final Paint _blackPaint = new Paint();

    public CircleLayout(Context context) {
        super(context);
        init();
    }

    public CircleLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray attr = context.obtainStyledAttributes(attrs,
                R.styleable.CircleLayout, 0, 0);
        circleType = attr.getInt(R.styleable.CircleLayout_CircleType, 1);
        init();
    }

    private void init() {
        _whitePaint.setColor(Color.parseColor("#ffffff"));
        _whitePaint.setAntiAlias(true);//使用抗锯齿功能
        _whitePaint.setStyle(Paint.Style.FILL);

        _blackPaint.setColor(Color.parseColor("#000000"));
        _blackPaint.setAntiAlias(true);//使用抗锯齿功能
        _blackPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int x = getWidth();
        int y = getHeight();
        canvas.drawCircle(x / 2, y / 2, x / 2, circleType == WHITE_TYPE ? _whitePaint : _blackPaint);
        canvas.drawCircle(x / 2, y / 2, x / 5, circleType == WHITE_TYPE ? _blackPaint : _whitePaint);
        super.onDraw(canvas);
    }
}
