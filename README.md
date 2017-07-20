Zoomable ImageView
========

This library will help you to show Image from url and to provide zooming, panning functionalities. This simple ImageView will easily fit in your ListView/RecyclerView/Activity/Fragment etc.

Gradle
--------

Add it in your root build.gradle at the end of repositories in your project module:
```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add the dependency in you app module:
```groovy
	dependencies {
	       compile 'com.github.rahulkapoor1:ZommableLoadingImageView:v1.2'
	 }

```

Usage
=======
Add ```ZoomableImageView``` in your layout file - 
```java
<com.iriis.libzoomableimageview.ZoomableImageView
        android:id="@+id/iv_zoomable"
        android:layout_width="@dimen/img_size"
        android:layout_height="@dimen/img_size"
        app:image_url="@string/dummy_image_url" />
```        
Attributes used in layout file.

| Name        | Format           | Description  |
| ------------- |:-------------:| -----:|
| image_url      | string | Url of Image |
| error_icon      | reference      |   Error in case of failure |
| zoomable_image_background | color      |    Background color |

Load Image from Java file
=======
```java
ZoomableImageView zoomableImageView = (ZoomableImageView) findViewById(R.id.iv_zoomable);
zoomableImageView.setPath("path of an image");
```
Example files are added. Enjoy!
=======
***
Demo App
=======
Try App on online simulator, to check functionality.
Play Online with App -  [Link of Simulator](https://appetize.io/app/fverx0qc9ht4tfumz6dqe8ddkr?device=nexus5&scale=75&orientation=portrait&osVersion=7.0)
***
MIT License
=======
Copyright 2017 Rasi Mobile

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
