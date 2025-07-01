package com.jiho.chattoo.mainui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.jiho.chattoo.R;
import com.jiho.chattoo.databinding.FragmentLoginBinding;
import org.jetbrains.annotations.NotNull;


public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    LoginViewModel loginViewModel;

    @Nullable
    @Override
    public @org.jetbrains.annotations.Nullable View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                                                 @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                                                 @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginViewModel.getLoginResult().observe(getViewLifecycleOwner(), result ->{
            if (result instanceof LoginResult.Loading){
                binding.loginButton.setEnabled(false);
                binding.loginButton.setVisibility(View.GONE);
                binding.loadingImage.setVisibility(View.VISIBLE);
            } else if (result instanceof LoginResult.Success){
                Toast.makeText(getContext(), "Login Success", Toast.LENGTH_SHORT).show();
                NavController navController = NavHostFragment.findNavController(this);
                navController.navigate(R.id.action_login_to_chat);
            } else if (result instanceof LoginResult.Error){
                String message = ((LoginResult.Error) result).getMessage();
                Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();

                binding.loginButton.setEnabled(true);
                binding.loginButton.setVisibility(View.VISIBLE);
                binding.loadingImage.setVisibility(View.GONE);
            }
        });

        binding.loginButton.setOnClickListener(v -> {
            loginViewModel.login(
                    binding.loginName.getText().toString().strip(),
                    binding.loginPassword.getText().toString().strip()
            );
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
