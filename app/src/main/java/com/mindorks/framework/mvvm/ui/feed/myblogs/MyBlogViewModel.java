package com.mindorks.framework.mvvm.ui.feed.myblogs;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableInt;
import android.databinding.ObservableList;
import android.util.Log;

import com.mindorks.framework.mvvm.data.DataManager;
import com.mindorks.framework.mvvm.data.model.api.BlogResponse;
import com.mindorks.framework.mvvm.ui.base.BaseViewModel;
import com.mindorks.framework.mvvm.utils.rx.SchedulerProvider;

import java.util.List;

/**
 * Created by brwsr on 03/04/2019.
 */

public class MyBlogViewModel extends BaseViewModel<MyBlogNavigator> {
    private static final String TAG = "MyBlogViewModel";
    private final ObservableList<BlogResponse.Blog> myBlogObservableList = new ObservableArrayList<>();

    private final MutableLiveData<List<BlogResponse.Blog>> myBlogMutableLiveData;

    private final ObservableInt lastposition = new ObservableInt(0);

    private MediatorLiveData<Integer> lastPositionLiveData;

    public MyBlogViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        myBlogMutableLiveData = new MutableLiveData<>();
        lastPositionLiveData = new MediatorLiveData<>();
        loadData();
    }

    public void loadData() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getBlogApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(blogResponse -> {
                            if (blogResponse != null && blogResponse.getData() != null) {
                                myBlogMutableLiveData.setValue(blogResponse.getData());
                            }
                            setIsLoading(false);
                        },
                        throwable -> {
                            setIsLoading(false);
                            getNavigator().handleError(throwable);
                        }));
    }

    public void addMyBlogs(List<BlogResponse.Blog> myBlogs) {
        lastposition.set(myBlogObservableList.size());
        lastPositionLiveData.setValue(myBlogObservableList.size());
        myBlogObservableList.addAll(myBlogs);
        Log.d(TAG, "addMyBlogs: " + myBlogObservableList.size());
    }

    public ObservableList<BlogResponse.Blog> getMyBlogObservableList() {
        return myBlogObservableList;
    }

    public MutableLiveData<List<BlogResponse.Blog>> getMyBlogMutableLiveData() {
        return myBlogMutableLiveData;
    }

    public ObservableInt getLastPosition() {
        return lastposition;
    }

    public LiveData<Integer> getLastPositionLiveData() {
        return lastPositionLiveData;
    }
}
