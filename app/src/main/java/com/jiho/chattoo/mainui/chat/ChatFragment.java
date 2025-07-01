package com.jiho.chattoo.mainui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.jiho.chattoo.databinding.FragmentChatBinding;
import org.jetbrains.annotations.NotNull;

public class ChatFragment extends Fragment {
    private FragmentChatBinding binding;
    private ChatViewModel chatViewModel;

    @Nullable
    @Override
    public @org.jetbrains.annotations.Nullable View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                                                                 @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                                                                 @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        chatViewModel =
                new ViewModelProvider(this).get(ChatViewModel.class);
        binding = FragmentChatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
