package com.example.pmu_laba_4_6v1;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


public class GLRendererTextureInteractive implements GLSurfaceView.Renderer
{
    private Context context;
    private FigureCubeTextured cube;

    float angleX = 0;
    float angleY = 0;
    float speedX = 0;
    float speedY = 0;
    float z = -6.0f;


    public GLRendererTextureInteractive(Context context)
    {
        this.context = context;
        cube = new FigureCubeTextured();
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config)
    {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glClearDepthf(1.0f);
        gl.glEnable(GL10.GL_DEPTH_TEST);
        gl.glDepthFunc(GL10.GL_LEQUAL);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glDisable(GL10.GL_DITHER);

        cube.loadTexture(gl, context);
        gl.glEnable(GL10.GL_TEXTURE_2D);
    }


    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height)
    {
        if (height == 0) height = 1;
        float aspect = (float) width / height;

        gl.glViewport(0, 0, width, height);

        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f);

        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity();

    }


    @Override
    public void onDrawFrame(GL10 gl)
    {
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, z);
        gl.glRotatef(angleX, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(angleY, 0.0f, 1.0f, 0.0f);
        cube.draw(gl);

        angleX += speedX;  // (NEW)
        angleY += speedY;  // (NEW)
    }
}