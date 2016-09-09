package com.rasi.loadingimageview.widget;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.rasi.loadingimageview.R;
import com.rasi.loadingimageview.dialog.ZoomableImageDialog;

import static android.widget.ImageView.ScaleType.CENTER_CROP;

public class LoadingImageView extends RelativeLayout implements View.OnClickListener {

    private ProgressBar mSpinner;

    private ImageView mImageView;

    private String mImagePath;

    private ZoomableImageDialog mDialog;

    public LoadingImageView(Context context) {
        this(context, null);
    }

    public LoadingImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadingImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intializeViews(context);
    }

    private void intializeViews(final Context context) {
        initializeImageHolder(context);
        initializeProgressBar(context);
    }

    private void loadImage() {
        ImageLoader.getInstance().displayImage(mImagePath, mImageView, new SimpleImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                mImageView.setImageResource(0);
                mSpinner.setVisibility(View.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                Log.w("LoadingImageView", failReason.getCause());
                mSpinner.setVisibility(View.GONE);
                mImageView.setImageResource(R.drawable.warning);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                mSpinner.setVisibility(View.GONE);
                mImageView.setVisibility(VISIBLE);
                mImageView.setOnClickListener(LoadingImageView.this);
            }
        });
    }

    private void initializeImageHolder(final Context context) {
        mImageView = new ImageView(context);
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        mImageView.setLayoutParams(layoutParams);
        mImageView.setScaleType(CENTER_CROP);
        addView(mImageView);
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType){
        mImageView.setScaleType(scaleType);
    }

    private void initializeProgressBar(final Context context) {
        mSpinner = new ProgressBar(context);
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        mSpinner.setLayoutParams(layoutParams);
        addView(mSpinner);
    }

    public void setImageBackground(final int imgResID) {
        mImageView.setBackgroundResource(imgResID);
    }

    public void setImageResource(final int imgResID) {
        mSpinner.setVisibility(View.GONE);
        mImageView.setImageResource(imgResID);
    }

    @Override
    public void onClick(View v) {
        if (mDialog == null) {
            initializeZoomableDialog(v.getContext());
        }
        mDialog.show();
        mDialog.setImage(mImagePath);
    }

    private void initializeZoomableDialog(final Context context) {
        mDialog = new ZoomableImageDialog(context);
    }

    public void setPath(String imgPath){
        this.mImagePath = imgPath;
        loadImage();
    }
}
