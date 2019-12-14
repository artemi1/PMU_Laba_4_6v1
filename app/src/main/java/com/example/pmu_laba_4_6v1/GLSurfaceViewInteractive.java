package com.example.pmu_laba_4_6v1;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.KeyEvent;
import android.view.MotionEvent;

public class GLSurfaceViewInteractive extends GLSurfaceView
{
    GLRendererTextureInteractive renderer;

    private final float TOUCH_SCALE_FACTOR = 180.0f / 320.0f;
    private float previousX;
    private float previousY;


    public GLSurfaceViewInteractive(Context context)
    {
        super(context);
        renderer = new GLRendererTextureInteractive(context);
        this.setRenderer(renderer);
        this.requestFocus();
        this.setFocusableInTouchMode(true);
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent evt)
    {
        switch(keyCode) {
            case KeyEvent.KEYCODE_DPAD_LEFT:
                renderer.speedY -= 0.1f;
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                renderer.speedY += 0.1f;
                break;
            case KeyEvent.KEYCODE_DPAD_UP:
                renderer.speedX -= 0.1f;
                break;
            case KeyEvent.KEYCODE_DPAD_DOWN:
                renderer.speedX += 0.1f;
                break;
            case KeyEvent.KEYCODE_A:
                renderer.z -= 0.2f;
                break;
            case KeyEvent.KEYCODE_Z:
                renderer.z += 0.2f;
                break;
        }
        return true;
    }


    @Override
    public boolean onTouchEvent(final MotionEvent evt)
    {
        float currentX = evt.getX();
        float currentY = evt.getY();
        float deltaX, deltaY;
        switch (evt.getAction())
        {
            case MotionEvent.ACTION_MOVE:

                deltaX = currentX - previousX;
                deltaY = currentY - previousY;
                renderer.angleX += deltaY * TOUCH_SCALE_FACTOR;
                renderer.angleY += deltaX * TOUCH_SCALE_FACTOR;
        }

        previousX = currentX;
        previousY = currentY;
        return true;  // Event handled
    }
}