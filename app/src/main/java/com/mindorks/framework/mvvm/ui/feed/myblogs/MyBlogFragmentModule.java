package com.mindorks.framework.mvvm.ui.feed.myblogs;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.widget.LinearLayoutManager;

import com.mindorks.framework.mvvm.ViewModelProviderFactory;
import com.mindorks.framework.mvvm.data.DataManager;
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogAdapter;
import com.mindorks.framework.mvvm.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

/**
 * Created by brwsr on 03/04/2019.
 */
@Module
public class MyBlogFragmentModule {
    @Provides
    MyBlogViewModel myBlogViewModel(DataManager dataManager,
                                    SchedulerProvider schedulerProvider) {
        return new MyBlogViewModel(dataManager, schedulerProvider);
    }

    @Provides
    MyBlogAdapter provideMyBlogAdapter() {
        return new MyBlogAdapter(new ArrayList<>());
    }


/*    @Provides
    MyBlogAdapter provideMyBlogAdapter() {
        return new MyBlogAdapter(new ArrayList<>());
    }*/

    @Provides
    ViewModelProvider.Factory provideMyBlogViewModel(MyBlogViewModel myBlogViewModel) {
        return new ViewModelProviderFactory<>(myBlogViewModel);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(MyBlogFragment fragment) {
        return new LinearLayoutManager(fragment.getActivity());
    }
}
