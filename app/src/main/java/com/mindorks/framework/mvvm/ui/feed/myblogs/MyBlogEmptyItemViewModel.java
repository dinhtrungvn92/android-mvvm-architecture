package com.mindorks.framework.mvvm.ui.feed.myblogs;

import com.mindorks.framework.mvvm.ui.feed.blogs.BlogEmptyItemViewModel;

/**
 * Created by brwsr on 03/04/2019.
 */

public class MyBlogEmptyItemViewModel {
    private MyBlogEmptyItemViewModelListener mListener;

    public MyBlogEmptyItemViewModel(MyBlogEmptyItemViewModelListener listener) {
        this.mListener = listener;
    }

    public void onRetryClick() {
        mListener.onRetryClick();
    }

    public interface MyBlogEmptyItemViewModelListener {

        void onRetryClick();
    }
}
