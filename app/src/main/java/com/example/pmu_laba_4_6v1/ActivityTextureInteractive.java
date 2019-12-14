package com.example.pmu_laba_4_6v1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTextureInteractive extends AppCompatActivity
{
    private GLSurfaceViewInteractive glView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceViewInteractive(this);
        setContentView(glView);
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
