package com.example.pmu_laba_4_6v1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;


public class PrimitiveSquare
{
    private FloatBuffer vertexBuffer;

    private float[] vertices = {
            -1.0f, -1.0f,  0.0f,
            1.0f, -1.0f,  0.0f,
            -1.0f,  1.0f,  0.0f,
            1.0f,  1.0f,  0.0f
    };

    public PrimitiveSquare()
    {
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void draw(GL10 gl)
    {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
        gl.glDrawArrays(GL10.GL_TRIANGLE_STRIP, 0, vertices.length / 3);
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
    }
}
