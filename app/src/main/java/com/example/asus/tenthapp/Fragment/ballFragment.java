package com.example.asus.tenthapp.Fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.asus.tenthapp.R;


public class ballFragment extends Fragment implements View.OnClickListener {
    ImageView imageViewBall;
    DisplayMetrics displayMetrics;
    RelativeLayout parentLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ball, container, false);
        imageViewBall = (ImageView)view.findViewById(R.id.iv_ball_FB);
        displayMetrics = getActivity().getResources().getDisplayMetrics();
        parentLayout = (RelativeLayout)view.findViewById(R.id.parent_layout);
        imageViewBall.setOnClickListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {

        float density = displayMetrics.density;
        float parentHeight = parentLayout.getHeight()/density;
        float parentWidth = parentLayout.getWidth()/density;
        float childWidth = imageViewBall.getWidth()/density;
        float scaleFactor = parentWidth/childWidth;
        float transitionValue = 0;

        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            transitionValue = parentHeight - parentWidth;
        } else {
            transitionValue = parentHeight /scaleFactor;
        }

        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, scaleFactor, 1.0f, scaleFactor,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setInterpolator(new AccelerateInterpolator());
        scaleAnimation.setRepeatCount(1);
        scaleAnimation.setRepeatMode(Animation.REVERSE);

        //translates ball to the bottom of the screen
        TranslateAnimation transAnim = new TranslateAnimation(0, 0, 0, transitionValue);
        transAnim.setInterpolator(new BounceInterpolator());
        transAnim.setRepeatCount(1);
        transAnim.setRepeatMode(Animation.REVERSE);


//      //switch animation effects
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setStartOffset(500);
        animationSet.setDuration(1500);
        animationSet.addAnimation(transAnim);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setFillAfter(true);

//        animationSet.setInterpolator(getActivity(), R.anim.boun);

        imageViewBall.startAnimation(animationSet);


    }
}
