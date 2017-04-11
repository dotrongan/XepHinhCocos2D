package com.andnhephinh.xephinh;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;

public class MainActivity extends AppCompatActivity {

    protected CCGLSurfaceView glSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON, WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        glSurfaceView = new CCGLSurfaceView(this);
        setContentView(glSurfaceView);

        CCDirector ccDirector = CCDirector.sharedDirector();
        ccDirector.attachInView(glSurfaceView);
        ccDirector.setDeviceOrientation(CCDirector.kCCDeviceOrientationLandscapeLeft);
        ccDirector.setAnimationInterval(1.0f/60.0f);
        ccDirector.setDisplayFPS(true);

        CCScene scene = GameLayer.scene();
        ccDirector.runWithScene(scene);
    }

    @Override
    protected void onPause() {
        super.onPause();
        CCDirector.sharedDirector().pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        CCDirector.sharedDirector().resume();
    }

    @Override
    protected void onStop() {
        super.onStop();
        CCDirector.sharedDirector().end();
    }
}
