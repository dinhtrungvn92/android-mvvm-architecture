package com.mindorks.framework.mvvm.ui.feed.myblogs;

import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragment;
import com.mindorks.framework.mvvm.ui.feed.blogs.BlogFragmentModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by brwsr on 03/04/2019.
 */
@Module
public abstract class MyBlogFragmentProvider {

    @ContributesAndroidInjector(modules = MyBlogFragmentModule.class)
    abstract MyBlogFragment provideMyBlogFragmentFactory();
}
