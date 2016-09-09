package com.rasi.loadingimageview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.rasi.loadingimageview.R;
import com.rasi.loadingimageview.adapter.LoadingImageViewAdapter;
import com.rasi.loadingimageview.model.ImageModel;

import java.util.List;

public class LoadingImageViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_image_view);
        setImagesListView();
    }

    private void setImagesListView() {
        final ListView lvImages = (ListView) findViewById(R.id.lv_loading_images);
        final List<ImageModel> dummyImages = ImageModel.getDummyImages();
        lvImages.setAdapter(new LoadingImageViewAdapter(dummyImages));
    }
}
