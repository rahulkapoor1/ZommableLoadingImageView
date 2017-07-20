package com.iriis.libzoomableimageview;

/**
 * Copyright (c) 2017 Rasi Mobile
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

/**
 * Custom view which will be used to load and zoom image.
 * Created by rahulkapoor on 22/04/17.
 */
public class ZoomableImageView extends RelativeLayout implements View.OnClickListener {

    private ProgressBar mSpinner;

    private ImageView mImageView;

    private String mImagePath;

    private ZoomableImageDialog mDialog;

    private int mWarningImgIcon;

    private int mZoomableImageBackground;

    public ZoomableImageView(Context context) {
        this(context, null);
    }

    public ZoomableImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZoomableImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ZoomableImageView, defStyleAttr, 0);

        final String imageUrl;

        try {
            mWarningImgIcon = ta.getResourceId(R.styleable.ZoomableImageView_error_icon, R.drawable.warning);
            mZoomableImageBackground = ta.getColor(R.styleable.ZoomableImageView_zoomable_image_background,
                    ContextCompat.getColor(context, android.R.color.white));
            imageUrl = ta.getString(R.styleable.ZoomableImageView_image_url);
        } finally {
            ta.recycle();
        }

        initImageLoader(context);
        intializeViews(context);

        if (imageUrl != null) {
            setPath(imageUrl);
        }
    }

    private void intializeViews(final Context context) {
        initializeImageHolder(context);
        initializeProgressBar(context);
    }

    /**
     * To set image url path and to display image on Ui.
     *
     * @param imgPath Url of ImageView.
     */
    public void setPath(String imgPath) {
        this.mImagePath = imgPath;
        loadImage();
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
                mImageView.setImageResource(mWarningImgIcon);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                mSpinner.setVisibility(View.GONE);
                mImageView.setVisibility(VISIBLE);
                mImageView.setOnClickListener(ZoomableImageView.this);
            }
        });
    }

    private void initializeImageHolder(final Context context) {
        mImageView = new ImageView(context);
        final RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        mImageView.setLayoutParams(layoutParams);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(mImageView);
    }

    public void setScaleType(@NonNull ImageView.ScaleType scaleType) {
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
        mDialog.setBackgroundColor(mZoomableImageBackground);
    }

    private void initializeZoomableDialog(final Context context) {
        mDialog = new ZoomableImageDialog(context);
    }

    /**
     * To initialize Image loader with default configurations. This method will called once.
     *
     * @param context Context of View.
     */
    private void initImageLoader(Context context) {

        // If configuration is not set then set it right away
        if (!ImageLoader.getInstance().isInited()) {

            DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                    .resetViewBeforeLoading(true)
                    .build();

            final ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
            config.threadPriority(Thread.NORM_PRIORITY - 2);
            config.denyCacheImageMultipleSizesInMemory();
            config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
            config.diskCacheSize(50 * 1024 * 1024);
            config.writeDebugLogs();
            config.memoryCache(new WeakMemoryCache());
            config.defaultDisplayImageOptions(defaultOptions);
            config.tasksProcessingOrder(QueueProcessingType.LIFO);

            // Initialize ImageLoader with configuration.
            ImageLoader.getInstance().init(config.build());
        }
    }

}
