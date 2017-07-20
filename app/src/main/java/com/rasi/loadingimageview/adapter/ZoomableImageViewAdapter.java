package com.rasi.loadingimageview.adapter;

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

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rasi.loadingimageview.R;
import com.rasi.loadingimageview.databinding.ItemZoomableImageBinding;
import com.rasi.loadingimageview.model.ImageModel;

import java.util.List;

/**
 * Adapter to show Zoomable ImageView in Adapter of ListView.
 */

public class ZoomableImageViewAdapter extends BaseAdapter {

    private final List<ImageModel> mImages;

    public ZoomableImageViewAdapter(@NonNull final List<ImageModel> images) {
        this.mImages = images;
    }

    @Override
    public int getCount() {
        return mImages.size();
    }

    @Override
    public ImageModel getItem(int i) {
        return mImages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ItemZoomableImageBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_zoomable_image, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemZoomableImageBinding) convertView.getTag();
        }
        binding.setImageData(getItem(i));
        return convertView;
    }
}
