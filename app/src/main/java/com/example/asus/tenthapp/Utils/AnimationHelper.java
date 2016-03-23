package com.example.asus.tenthapp.Utils;

import android.animation.ObjectAnimator;
import android.view.View;

public class AnimationHelper {

    public void animationView(View view, String animationType, float x, float y, long duration){
        ObjectAnimator scaleAnimator = ObjectAnimator.ofFloat(view, animationType, x, y);
        scaleAnimator.setDuration(duration);
        scaleAnimator.start();
    }

    public void moveView (View view, String type, float distance, long duration){
        ObjectAnimator animation = ObjectAnimator.ofFloat(view, type, distance);
        animation.setDuration(duration);
        animation.start();
    }

    public void rotateVoid (View view, int from, int to, long duration){
        ObjectAnimator rotateAnimator = ObjectAnimator.ofFloat(view, "roration", from, to);
        rotateAnimator.setDuration(duration);
        rotateAnimator.start();
    }
}
