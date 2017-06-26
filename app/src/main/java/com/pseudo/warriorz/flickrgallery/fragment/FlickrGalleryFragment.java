package com.pseudo.warriorz.flickrgallery.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pseudo.warriorz.flickrgallery.R;
import com.pseudo.warriorz.flickrgallery.networking.FlickrFetcher;

import java.io.IOException;

/**
 * @author Shailendra Suriyal
 */

public class FlickrGalleryFragment extends Fragment {
    private static final String TAG = " FlickrGalleryFragment ";
    private RecyclerView mPhotoRecyclerView;

    public static FlickrGalleryFragment newInstance() {
        return new FlickrGalleryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        new FetchItemsTask().execute();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_gallery, container, false);
        mPhotoRecyclerView = (RecyclerView) v
                .findViewById(R.id.fragment_photo_gallery_recycler_view);
        mPhotoRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        return v;
    }

    private class FetchItemsTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            new FlickrFetcher().fetchItems();
            return null;
        }
    }
}