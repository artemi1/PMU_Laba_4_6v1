package com.example.pmu_laba_4_6v1;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTexture extends AppCompatActivity
{
    private GLSurfaceView glView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceView(this);
        glView.setRenderer(new GLRendererTexture(this));
        this.setContentView(glView);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        glView.onPause();
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        glView.onResume();
    }
}
