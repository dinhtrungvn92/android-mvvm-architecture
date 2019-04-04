package com.mindorks.framework.mvvm.ui.feed.myblogs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mindorks.framework.mvvm.data.model.api.BlogResponse;
import com.mindorks.framework.mvvm.databinding.ItemBlogViewBinding;
import com.mindorks.framework.mvvm.ui.base.BaseViewHolder;

import java.util.List;

/**
 * Created by brwsr on 03/04/2019.
 */

public class MyBlogAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "MyBlogAdapter";

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;
    private List<BlogResponse.Blog> mBlogsResponseList;
    private MyBlogAdapterListener mListener;

    public MyBlogAdapter(List<BlogResponse.Blog> mBlogsResponseList) {
        this.mBlogsResponseList = mBlogsResponseList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder baseViewHolder, int i) {
        baseViewHolder.onBind(i);
    }

    @Override
    public int getItemCount() {
        if (mBlogsResponseList != null && mBlogsResponseList.size() > 0) {
            return mBlogsResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBlogsResponseList != null && !mBlogsResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void setListener(MyBlogAdapterListener mListener) {
        this.mListener = mListener;
    }

    public interface MyBlogAdapterListener {

    }
}
