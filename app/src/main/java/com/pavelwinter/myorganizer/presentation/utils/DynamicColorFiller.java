package com.pavelwinter.myorganizer.presentation.utils;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;


/**
 * how to use: DynamicColorFiller dynamicColorFiller = new DynamicColorFiller();
 *     color    dynamicColorFiller .setColorItem(Color.parseColor("#f5a623"));
 *      width(height)   dynamicColorFiller .setWidthPercent((double)quontitesList .get(position));
 *      target   holder .viewStr .setBackground(dynamicColorFiller);
 * */


public class DynamicColorFiller extends Drawable {

    private int colorItem;
    private double widthPercent;
    private final Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Path mPath = new Path();

    public void setColorItem(int colorItem){
        this.colorItem=colorItem;
    }

    public void setWidthPercent(double widthPercent){
        this.widthPercent=widthPercent;
    }

    @Override
    public void draw(Canvas canvas) {
        mPaint.setColor(colorItem);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    public void setAlpha(int alpha) {
        mPaint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);
        double width = bounds.width();
        int height = bounds.height();
        mPath.reset();
        mPath.addRect(0,0,(float)width/100*(float)widthPercent,height, Path.Direction.CCW);
        mPath.close();
    }
}