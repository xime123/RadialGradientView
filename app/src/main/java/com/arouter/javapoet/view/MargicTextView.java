package com.arouter.javapoet.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class MargicTextView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // 环形渐变渲染
    private Shader mRadialGradient = null;

    public MargicTextView(Context context) {
        this(context, null);
    }

    public MargicTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MargicTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ValueAnimator animator=ValueAnimator.ofInt(getMeasuredWidth());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(3000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                x = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    int x;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = new Matrix();
        matrix.setTranslate(x,0);
        mRadialGradient = new LinearGradient(-getMeasuredHeight(), 300, 0, 0, 0xffff0000, 0xff0000ff, Shader.TileMode.REPEAT);
        mRadialGradient.setLocalMatrix(matrix);
        mPaint.setShader(mRadialGradient);
        mPaint.setTextSize(50);
        canvas.drawText("恒大智慧科技有限公司",getWidth()/2,getHeight()/2,mPaint);
    }
}
