package com.mindorks.framework.mvvm.ui.feed.myblogs;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mindorks.framework.mvvm.data.model.api.BlogResponse;
import com.mindorks.framework.mvvm.databinding.ItemBlogViewBinding;
import com.mindorks.framework.mvvm.ui.base.BaseViewHolder;
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogAdapter;

import java.util.List;

/**
 * Created by brwsr on 03/04/2019.
 */

public class MyBlogAdapter extends BlogAdapter {

    public MyBlogAdapter(List<BlogResponse.Blog> blogResponseList) {
        super(blogResponseList);
    }
}
