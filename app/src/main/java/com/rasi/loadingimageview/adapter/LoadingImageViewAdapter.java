package com.rasi.loadingimageview.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.rasi.loadingimageview.R;
import com.rasi.loadingimageview.databinding.ItemLoadingImageBinding;
import com.rasi.loadingimageview.model.ImageModel;

import java.util.List;

/**
 * To display list of images.
 */

public class LoadingImageViewAdapter extends BaseAdapter {

    private final List<ImageModel> mImages;

    public LoadingImageViewAdapter(@NonNull final List<ImageModel> images) {
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
        ItemLoadingImageBinding binding;
        if (convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_loading_image, parent, false);
            convertView = binding.getRoot();
            convertView.setTag(binding);
        } else {
            binding = (ItemLoadingImageBinding) convertView.getTag();
        }
        binding.setImageData(getItem(i));
        return convertView;
    }
}
