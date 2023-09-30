package com.bello.vendasapp.ui.cliente;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClienteViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClienteViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cliente fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public void adicionarCliente(String nome, String cpf, String dataNasc) {
    }
}