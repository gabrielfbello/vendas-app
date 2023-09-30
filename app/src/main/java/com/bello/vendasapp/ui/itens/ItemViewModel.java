package com.bello.vendasapp.ui.itens;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ItemViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ItemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is itens fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}