package com.pseudo.warriorz.flickrgallery.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.pseudo.warriorz.flickrgallery.R;
import com.pseudo.warriorz.flickrgallery.fragment.FlickrGalleryFragment;

public class FlickrGalleryActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return FlickrGalleryFragment.newInstance();
    }
}
