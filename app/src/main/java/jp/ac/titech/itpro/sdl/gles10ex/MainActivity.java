package jp.ac.titech.itpro.sdl.gles10ex;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;


public class MainActivity extends Activity implements SeekBar.OnSeekBarChangeListener {
    private final static String TAG = "MainActivity";

    private GLSurfaceView glView;
    private SimpleRenderer renderer;
    private SeekBar rotationBarX, rotationBarY, rotationBarZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        setContentView(R.layout.activity_main);
        glView = (GLSurfaceView) findViewById(R.id.glview);
        renderer = new SimpleRenderer(new Pyramid(), new Cube());
        glView.setRenderer(renderer);
        rotationBarX = (SeekBar)findViewById(R.id.rotation_bar_x);
        rotationBarY = (SeekBar)findViewById(R.id.rotation_bar_y);
        rotationBarZ = (SeekBar)findViewById(R.id.rotation_bar_z);
        rotationBarX.setOnSeekBarChangeListener(this);
        rotationBarY.setOnSeekBarChangeListener(this);
        rotationBarZ.setOnSeekBarChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
        glView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
        glView.onPause();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar == rotationBarX)
            renderer.setRotationX(progress);
        else if (seekBar == rotationBarY)
            renderer.setRotationY(progress);
        else if (seekBar == rotationBarZ)
            renderer.setRotationZ(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {}

}