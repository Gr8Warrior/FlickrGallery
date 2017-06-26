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
import android.widget.TextView;

import com.pseudo.warriorz.flickrgallery.R;
import com.pseudo.warriorz.flickrgallery.model.Photo;
import com.pseudo.warriorz.flickrgallery.networking.FlickrFetcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shailendra Suriyal
 */

public class FlickrGalleryFragment extends Fragment {
    private static final String TAG = " FlickrGalleryFragment ";
    private RecyclerView mPhotoRecyclerView;
    private List<Photo> mItems = new ArrayList<>();

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
        setupAdapter();
        return v;
    }

    private class FetchItemsTask extends AsyncTask<Void, Void, List<Photo>> {
        @Override
        protected List<Photo> doInBackground(Void... params) {
            return new FlickrFetcher().fetchItems();
        }

        @Override
        protected void onPostExecute(List<Photo> items) {
            mItems = items;
            setupAdapter();
        }
    }

    private void setupAdapter() {
        if (isAdded()) {
            mPhotoRecyclerView.setAdapter(new PhotoAdapter(mItems));
        }
    }

    private class PhotoHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTextView;

        public PhotoHolder(View itemView) {
            super(itemView);
            mTitleTextView = (TextView) itemView;
        }

        public void bindGalleryItem(Photo item) {
            Log.i(TAG, "bindGalleryItem: "+item.getTitle());
            mTitleTextView.setText(item.getTitle());
        }
    }

    private class PhotoAdapter extends RecyclerView.Adapter<PhotoHolder> {
        private List<Photo> mPhotos;

        public PhotoAdapter(List<Photo> photos) {
            mPhotos = photos;
        }

        @Override
        public PhotoHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            TextView textView = new TextView(getActivity());
            return new PhotoHolder(textView);
        }

        @Override
        public void onBindViewHolder(PhotoHolder photoHolder, int position) {
            Photo photo = mPhotos.get(position);
            photoHolder.bindGalleryItem(photo);
        }

        @Override
        public int getItemCount() {
            Log.i(TAG, "getItemCount: "+mPhotos.size());
            return mPhotos.size();
        }
    }
}