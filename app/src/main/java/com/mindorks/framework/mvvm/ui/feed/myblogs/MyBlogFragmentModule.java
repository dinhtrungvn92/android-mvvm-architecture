package com.mindorks.framework.mvvm.ui.feed.myblogs;

import com.mindorks.framework.mvvm.data.DataManager;
import com.mindorks.framework.mvvm.utils.rx.SchedulerProvider;

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
}
