package com.rasi.loadingimageview.model;

import java.util.ArrayList;
import java.util.List;

/**
 * To include image details.
 */

public class ImageModel {

    private String mPath;

    private String mName;

    public ImageModel(String path, String name) {
        this.mPath = path;
        this.mName = name;
    }

    public String getPath() {
        return mPath;
    }

    public String getName() {
        return mName;
    }

    public static List<ImageModel> getDummyImages() {
        final List<ImageModel> images = new ArrayList<>(20);
        for (int i = 0; i < 5; i++) {
            images.add(new ImageModel("http://www.nature.org/cs/groups/webcontent/@photopublic/documents/media/bluebird-640x400-1.jpg", "Image 0"+i));
            images.add(new ImageModel("http://www.planwallpaper.com/static/cache/80/43/80430ac91546a771346f52e202ce1f07.jpg", "Image 1"+i));
            images.add(new ImageModel("http://www.planwallpaper.com/static/cache/e2/43/e243895a74253e087fbf48e2712317ad.jpg", "Image 2"+i));
            images.add(new ImageModel("http://www.planwallpaper.com/static/cache/7b/37/7b37185b3d4a573c31a1596ffbdd5974.jpg", "Image 3"+i));
        }
        return images;
    }
}
