package com.mindorks.framework.mvvm.ui.feed.myblogs;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.mindorks.framework.mvvm.BR;
import com.mindorks.framework.mvvm.R;
import com.mindorks.framework.mvvm.databinding.FragmentMyBlogBinding;
import com.mindorks.framework.mvvm.ui.base.BaseFragment;
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogAdapter;

import javax.inject.Inject;

/**
 * Created by brwsr on 03/04/2019.
 */

public class MyBlogFragment extends BaseFragment<FragmentMyBlogBinding, MyBlogViewModel>
        implements MyBlogNavigator, BlogAdapter.BlogAdapterListener {

    @Inject
    BlogAdapter mBlogAdapter;
    @Inject
    LinearLayoutManager linearLayoutManager;
    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    private FragmentMyBlogBinding fragmentMyBlogBinding;
    private MyBlogViewModel myBlogViewModel;


    public static MyBlogFragment newInstance() {

        Bundle args = new Bundle();
        MyBlogFragment fragment = new MyBlogFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_my_blog;
    }

    @Override
    public MyBlogViewModel getViewModel() {
        myBlogViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MyBlogViewModel.class);
        return myBlogViewModel;
    }

    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myBlogViewModel.setNavigator(this);
        mBlogAdapter.setListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMyBlogBinding = getViewDataBinding();
        setUp();
        subscribeToLiveData();
    }

    public void setUp() {
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fragmentMyBlogBinding.listMyBlog.setLayoutManager(linearLayoutManager);
        fragmentMyBlogBinding.listMyBlog.setItemAnimator(new DefaultItemAnimator());
        fragmentMyBlogBinding.listMyBlog.setAdapter(mBlogAdapter);
    }

    public void subscribeToLiveData() {
        myBlogViewModel.getMyBlogMutableLiveData().observe(this, blogs -> myBlogViewModel.addMyBlogs(blogs));
    }

    @Override
    public void onRetryClick() {

    }
}

