package com.chinalwb.hereyouare.mvp2;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BasePresenter<T> implements IBasePresenter<T> {
    // thread-safe set of listeners
    private Set<T> mListeners = Collections.newSetFromMap(new ConcurrentHashMap<T, Boolean>(1));


    @Override
    public void registerListener(T listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(T listener) {
        mListeners.remove(listener);
    }

    protected Set<T> getListeners() {
        return mListeners;
    }
}
