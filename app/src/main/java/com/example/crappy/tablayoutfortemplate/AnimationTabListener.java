package com.example.crappy.tablayoutfortemplate;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TabHost;
import android.widget.Toast;

/**
 * Created by crappy on 12/12/17.
 */

public class AnimationTabListener implements TabHost.OnTabChangeListener {
    private Context context;
    private static final int ANIMATION_TIME = 240;
    private TabHost tabHost;
    private View previousView;
    private View currentView;
    private int currentTab;

    public AnimationTabListener(Context context, TabHost tabHost) {
        this.context = context;
        this.tabHost = tabHost;
        this.previousView = tabHost.getCurrentView();

    }

    @Override
    public void onTabChanged(String tabId) {
        Toast.makeText(context, tabId, Toast.LENGTH_SHORT).show();


        //Animation

        currentView = tabHost.getCurrentView();
        if (tabHost.getCurrentTab() > currentTab) {
            previousView.setAnimation(outToLeftAnimation());
            currentView.setAnimation(inFromRightAnimation());
        } else {
            previousView.setAnimation(outToRightAnimation());
            currentView.setAnimation(inFromLeftAnimation());
        }
        previousView = currentView;
        currentTab = tabHost.getCurrentTab();

    }

    private Animation inFromLeftAnimation() {
        Animation inFromLeft = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                -1.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f, Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(inFromLeft);
    }

    private Animation setProperties(Animation animation) {
        animation.setDuration(ANIMATION_TIME);
        animation.setInterpolator(new AccelerateInterpolator());
        return animation;
    }

    private Animation outToRightAnimation() {
        Animation outToRight = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                1.0f, Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(outToRight);
    }

    private Animation inFromRightAnimation() {
        Animation inFromRight = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                1.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f, Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(inFromRight);
    }

    private Animation outToLeftAnimation() {
        Animation outToLeft = new TranslateAnimation(Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                 -1.0f, Animation.RELATIVE_TO_PARENT,
                0.0f,
                Animation.RELATIVE_TO_PARENT,
                0.0f);
        return setProperties(outToLeft);
    }
}
