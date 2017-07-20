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
import android.widget.ListView;

import com.rasi.loadingimageview.R;
import com.rasi.loadingimageview.adapter.ZoomableImageViewAdapter;
import com.rasi.loadingimageview.model.ImageModel;

import java.util.List;

/**
 * Activity to demonstrate use of Zoomable ImageView with ListView.
 */
public class ZoomableListViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_zoomable_image_view);
        // To set dummy data on ListView
        setImagesListView();
    }

    /**
     * To set Zoomable Images on Adapter.
     */
    private void setImagesListView() {
        final ListView lvImages = (ListView) findViewById(R.id.lv_loading_images);
        final List<ImageModel> dummyImages = ImageModel.getDummyImages();
        lvImages.setAdapter(new ZoomableImageViewAdapter(dummyImages));
    }
}
