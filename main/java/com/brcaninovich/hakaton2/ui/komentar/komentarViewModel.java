package com.brcaninovich.hakaton2.ui.komentar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class komentarViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public komentarViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}