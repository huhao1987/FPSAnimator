package com.daasuu.library.parabolicmotion;

import android.graphics.Canvas;
import android.graphics.Paint;


import com.daasuu.library.callback.AnimCallBack;

public class ParabolicMotionText extends ParabolicMotion {

    private String mText;
    private float mAdjustTextMesureY;

    public ParabolicMotionText(String text, Paint paint) {
        this.mText = text;
        this.mPaint = paint;
        mAdjustTextMesureY = mPaint.getTextSize();
    }

    public ParabolicMotionText setTransform(float x, float y) {
        mAnimParameter.x = x;
        mAnimParameter.y = y;
        return this;
    }

    public ParabolicMotionText frequency(int frequency) {
        mFrequency = frequency;
        return this;
    }

    public ParabolicMotionText initialVelocityY(float velocityY) {
        mInitialVelocityY = velocityY;
        return this;
    }

    public ParabolicMotionText accelerationY(float accelerationY) {
        mAccelerationY = accelerationY;
        return this;
    }

    public ParabolicMotionText accelerationX(float accelerationX) {
        mAccelerationX = accelerationX;
        return this;
    }

    public ParabolicMotionText coefficientRestitutionY(float coefficientRestitutionY) {
        mCoefficientRestitutionY = coefficientRestitutionY;
        return this;
    }

    public ParabolicMotionText coefficientRestitutionX(float coefficientRestitutionX) {
        mCoefficientRestitutionX = coefficientRestitutionX;
        return this;
    }

    public ParabolicMotionText coefficientBottom(boolean coefficientBottom) {
        mCoefficientBottom = coefficientBottom;
        return this;
    }

    public ParabolicMotionText coefficientLeft(boolean coefficientLeft) {
        mCoefficientLeft = coefficientLeft;
        return this;
    }

    public ParabolicMotionText coefficientRight(boolean coefficientRight) {
        mCoefficientRight = coefficientRight;
        return this;
    }

    public ParabolicMotionText bottomHitCallback(AnimCallBack animCallBack) {
        setBottomHitCallback(animCallBack);
        return this;
    }

    public ParabolicMotionText leftHitCallback(AnimCallBack animCallBack) {
        setLeftHitCallback(animCallBack);
        return this;
    }

    public ParabolicMotionText rightHitCallback(AnimCallBack animCallBack) {
        setRightHitCallback(animCallBack);
        return this;
    }

    private void setBaseLength(Canvas canvas) {
        mBottomBase = canvas.getHeight() - mAdjustTextMesureY;
        mRightSide = canvas.getWidth() - mPaint.measureText(mText);
    }

    @Override
    public void draw(Canvas canvas) {
        if (mText == null) return;
        setBaseLength(canvas);
        updatePosition();
        canvas.drawText(mText, mAnimParameter.x, mAnimParameter.y + mAdjustTextMesureY, mPaint);
    }


}