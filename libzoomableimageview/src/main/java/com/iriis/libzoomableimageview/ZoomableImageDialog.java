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
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;

import com.nostra13.universalimageloader.core.ImageLoader;

import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * To show zoomable image in a dialog.
 */

public class ZoomableImageDialog extends Dialog {

    // Image view which will take pan, zoom actions.
    private ImageViewTouch mIvZoom;

    // Main root View of Zoomable Image View.
    private View mRootView;

    public ZoomableImageDialog(@NonNull Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_zoomable_image);
        mIvZoom = (ImageViewTouch) findViewById(R.id.iv_zoomable);
        mRootView = findViewById(android.R.id.content);
    }

    /**
     * To set image which is going to display on Zoomable View.
     * @param imageUrl Url of an image which is going to display.
     */
    public void setImage(@NonNull final String imageUrl) {
        ImageLoader.getInstance().displayImage(imageUrl, mIvZoom);
    }

    /**
     * To set background color of a Zoomable View.
     * @param bgColor Background color for Zoomable View.
     */
    public void setBackgroundColor(@ColorInt int bgColor) {
        mRootView.setBackgroundColor(bgColor);
    }

}
