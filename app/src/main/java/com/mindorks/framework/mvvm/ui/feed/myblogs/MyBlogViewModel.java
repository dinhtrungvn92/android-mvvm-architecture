package com.mindorks.framework.mvvm.ui.feed.myblogs;

import com.mindorks.framework.mvvm.data.DataManager;
import com.mindorks.framework.mvvm.ui.base.BaseViewModel;
import com.mindorks.framework.mvvm.utils.rx.SchedulerProvider;

/**
 * Created by brwsr on 03/04/2019.
 */

public class MyBlogViewModel extends BaseViewModel<MyBlogNavigator> {

    public MyBlogViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

}
