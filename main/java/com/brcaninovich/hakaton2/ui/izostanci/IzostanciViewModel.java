package com.brcaninovich.hakaton2.ui.izostanci;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class IzostanciViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public IzostanciViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}