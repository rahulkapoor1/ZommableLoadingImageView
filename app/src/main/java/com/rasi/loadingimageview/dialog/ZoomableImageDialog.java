package com.rasi.loadingimageview.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.rasi.loadingimageview.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

/**
 * To show zoomable image in a dialog.
 */

public class ZoomableImageDialog extends Dialog {

    @BindView(R.id.iv_zoomable)
    ImageViewTouch mIvZoom;

    public ZoomableImageDialog(Context context) {
        super(context, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_zoomable_image);
        ButterKnife.bind(this);
    }

    public void setImage(final String imageUrl) {
        ImageLoader.getInstance().displayImage(imageUrl, mIvZoom);
    }

}
