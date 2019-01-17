package com.arouter.javapoet.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.arouter.javapoet.R;

public class BitmapView extends View {
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    // 环形渐变渲染
    private Shader mRadialGradient = null;
    private Bitmap bitmap;
    public BitmapView(Context context) {
        this(context, null);
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmap= BitmapFactory.decodeResource(getContext().getResources(), R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRadialGradient=new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        mPaint.setShader(mRadialGradient);
       // canvas.drawRect(new Rect(0,0,getWidth()/2,getHeight()/2),mPaint);
        canvas.drawOval(new RectF(0,0,getWidth(),getHeight()),mPaint);
    }
}
