package com.brcaninovich.hakaton2.ui.raspored;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RasporedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RasporedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}