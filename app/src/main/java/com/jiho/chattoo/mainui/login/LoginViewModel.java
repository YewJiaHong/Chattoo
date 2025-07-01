package com.jiho.chattoo.mainui.login;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    public LoginViewModel(){
    }

    public LiveData<LoginResult> getLoginResult(){
        return loginResult;
    }
    public void login(String name, String password){
        if (name.isBlank() || password.isBlank()){
            loginResult.setValue(new LoginResult.Error("Username and password cannot be empty"));
            return;
        }

        loginResult.setValue(new LoginResult.Loading());

        // TODO: Replace this with a real backend call (e.g., Retrofit)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (name.equals("admin") && password.equals("1234")) {
                loginResult.setValue(new LoginResult.Success());
            } else {
                loginResult.setValue(new LoginResult.Error("Invalid credentials"));
            }
        }, 1000);
    }
}
