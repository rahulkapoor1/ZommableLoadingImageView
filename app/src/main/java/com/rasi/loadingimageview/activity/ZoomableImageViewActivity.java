package com.rasi.loadingimageview.activity;

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

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.iriis.libzoomableimageview.ZoomableImageView;
import com.rasi.loadingimageview.R;
import com.rasi.loadingimageview.model.ImageModel;

import java.util.List;
import java.util.Random;

/**
 * Activity to demonstrate use of Zoomable ImageView with an Activity.
 */
public class ZoomableImageViewActivity extends Activity implements View.OnClickListener {

    private ZoomableImageView mZoomableImageView;

    private List<ImageModel> mImages;

    private Random mRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoomable_view);

        mImages = ImageModel.getDummyImages();
        mRandom = new Random();

        mZoomableImageView = (ZoomableImageView) findViewById(R.id.iv_zoomable);
        findViewById(R.id.btn_random_image).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_random_image:
                // Get random number
                final int randomIndex = mRandom.nextInt(mImages.size() - 1);

                // set image url on Zoomable imageView
                mZoomableImageView.setPath(mImages.get(randomIndex).getPath());
                break;

        }
    }
}
