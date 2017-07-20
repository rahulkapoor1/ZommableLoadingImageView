package com.rasi.loadingimageview.model;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Model class to generate dummy data.
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

        final List<ImageModel> images = new ArrayList<>(12);

        images.add(new ImageModel("http://www.nature.org/cs/groups/webcontent/@photopublic/documents/media/bluebird-640x400-1.jpg", "Image 0"));
        images.add(new ImageModel("http://www.planwallpaper.com/static/cache/80/43/80430ac91546a771346f52e202ce1f07.jpg", "Image 1"));
        images.add(new ImageModel("http://www.planwallpaper.com/static/cache/e2/43/e243895a74253e087fbf48e2712317ad.jpg", "Image 2"));
        images.add(new ImageModel("http://www.planwallpaper.com/static/cache/7b/37/7b37185b3d4a573c31a1596ffbdd5974.jpg", "Image 3"));

        images.add(new ImageModel("https://images.pexels.com/photos/36762/scarlet-honeyeater-bird-red-feathers.jpg?w=940&h=650&auto=compress&cs=tinysrgb", "Image 4"));
        images.add(new ImageModel("https://images.pexels.com/photos/132037/pexels-photo-132037.jpeg?h=350&auto=compress&cs=tinysrgb", "Image 5"));
        images.add(new ImageModel("https://images.pexels.com/photos/145939/pexels-photo-145939.jpeg?h=350&auto=compress&cs=tinysrgb", "Image 6"));
        images.add(new ImageModel("https://images.pexels.com/photos/169905/pexels-photo-169905.jpeg?h=350&auto=compress&cs=tinysrgb", "Image 7"));

        images.add(new ImageModel("https://images.pexels.com/photos/17679/pexels-photo.jpg?h=350&auto=compress&cs=tinysrgb", "Image 8"));
        images.add(new ImageModel("https://images.pexels.com/photos/35627/shells-massage-therapy-sand.jpg?h=350&auto=compress&cs=tinysrgb", "Image 9"));
        images.add(new ImageModel("https://images.pexels.com/photos/36764/marguerite-daisy-beautiful-beauty.jpg?h=350&auto=compress&cs=tinysrgb", "Image 10"));
        images.add(new ImageModel("https://images.pexels.com/photos/40896/larch-conifer-cone-branch-tree-40896.jpeg?h=350&auto=compress&cs=tinysrgb", "Image 11"));

        return images;
    }
}
