package com.liruya.common;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class BaseViewModel<T> extends ViewModel {
    protected final String TAG = this.getClass().getSimpleName();

    private final MutableLiveData<T> mLiveData = new MutableLiveData<>();

    public void observe(LifecycleOwner owner, Observer<T> observer) {
        mLiveData.observe(owner, observer);
    }
}
