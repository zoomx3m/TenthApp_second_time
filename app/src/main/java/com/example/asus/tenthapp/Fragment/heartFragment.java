package com.example.asus.tenthapp.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.asus.tenthapp.R;
import com.example.asus.tenthapp.Utils.AnimationHelper;

public class heartFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    private ImageView iv_heart_FH;

    private SeekBar skb_alfa;
    private SeekBar skb_rotate;
    private SeekBar skb_scale;

    private View v_img_alpha;
    private View v_img_rotate;
    private View v_img_Scale;

    private LinearLayout linlay_alpha;
    private LinearLayout linlay_rotate;
    private LinearLayout linlay_scale;

    private AnimationHelper animationHelper;

    private boolean alfaIsAnim = false;
    private boolean rotateIsAnim = false;
    private boolean scaleIsAnim = false;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heart, container, false);
        initElements(view);
        setOnClickListeners();
        setOnSeekBarChangeListeners();
        startHeartBeat();
        return view;

//        return super.onCreateView(inflater, container, savedInstanceState);
//        FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(R.id.workSpace);
//        frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.colorHeart);
//        initElements();
    }

//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        FrameLayout frameLayout = (FrameLayout) getActivity().findViewById(R.id.workSpace);
//        frameLayout.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.colorHeart));
////        initElements();
//    }

    private void startHeartBeat(){
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f,
                ScaleAnimation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        iv_heart_FH.startAnimation(scaleAnimation);
    }



    private void initElements (View view){

        iv_heart_FH = (ImageView) view.findViewById(R.id.iv_heart_FH);

        v_img_alpha = (View) view.findViewById(R.id.v_img_alpha);
        v_img_rotate = (View) view.findViewById(R.id.v_img_rotate);
        v_img_Scale = (View) view.findViewById(R.id.v_img_Scale);

        v_img_alpha.setOnClickListener(this);
        v_img_rotate.setOnClickListener(this);
        v_img_Scale.setOnClickListener(this);

        skb_alfa = (SeekBar) view.findViewById(R.id.skb_alfa);
        skb_rotate = (SeekBar) view.findViewById(R.id.skb_rotate);
        skb_scale = (SeekBar) view.findViewById(R.id.skb_scale);

        skb_alfa.setOnSeekBarChangeListener(this);
        skb_scale.setOnSeekBarChangeListener(this);
        skb_rotate.setOnSeekBarChangeListener(this);

        linlay_alpha = (LinearLayout) view.findViewById(R.id.linlay_alpha);
        linlay_rotate = (LinearLayout) view.findViewById(R.id.linlay_rotate);
        linlay_scale = (LinearLayout) view.findViewById(R.id.linlay_scale);

    }

    @Override
      public void onClick(View v) {
        float layoutWidth = linlay_scale.getWidth();
        long duration = 500;
        switch (v.getId()){
            case R.id.v_img_alpha:
                if (!alfaIsAnim){
                    squeezeView(skb_alfa, duration, 0.0f);
                    moveLeft(v_img_alpha, layoutWidth, duration);
                    alfaIsAnim =true;
                } else {
                    squeezeView(skb_alfa, duration, 1.0f);
                    moveLeft(v_img_alpha, layoutWidth, duration);
                    alfaIsAnim = false;
                }
                break;
            case R.id.v_img_rotate:
                if (!rotateIsAnim) {
                    squeezeView(skb_rotate,duration,0.0f);
                    moveRight(v_img_rotate, layoutWidth, duration);
                    rotateIsAnim = true;
                }
                break;
        }

    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
//
//    private void animateHeart() {
//        AnimationHelper animation = AnimationUtils.loadAnimation(getActivity(), R.anim.heart_animation);
//        ImageView iv_heart_FH;
////        iv_heart_FH.startAnimation(animation);
//    }


    private void moveRight(View view, float distance, long duration) {
        animationHelper.moveView(view, "x", distance, duration);
    }

    private void spreadView(View view, long duration,float pivotX) {
        view.setPivotX(pivotX);
        animationHelper.animationView(view, "scaleX", 0.0f, 1.5f, duration);
    }

    private void moveLeft(View view, float distance, long duration) {
//        animationHelper.animateView(view, "translationX", 0f, -distance, duration);
    }

    private void squeezeView(View view, long duration,float pivotX) {
        view.setPivotX(pivotX);
//        animationHelper.animateView(view, "scaleX", 1.0f, 0.0f, duration);
    }


    private void setOnSeekBarChangeListeners (){
//        skb_alfa.setOnSeekBarChangeListener(this);
//        skb_scale.setOnSeekBarChangeListener(this);
//        skb_rotate.setOnSeekBarChangeListener(this);
    }
    
    private void setOnClickListeners(){
//        v_img_alpha.setOnClickListener(this);
//        v_img_rotate.setOnClickListener(this);
//        v_img_Scale.setOnClickListener(this);
        
    }
    
}
