package com.jiho.chattoo.mainui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.jiho.chattoo.databinding.FragmentChatBinding;
import com.jiho.chattoo.mainui.model.BaseMessage;
import com.jiho.chattoo.mainui.model.User;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.List;

public class ChatFragment extends Fragment {
    private FragmentChatBinding binding;
    private ChatViewModel chatViewModel;
    private MessageListAdapter adapter;

    @Nullable
    @Override
    public @org.jetbrains.annotations.Nullable View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                                                                 @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                                                                 @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        chatViewModel =
                new ViewModelProvider(this).get(ChatViewModel.class);
        binding = FragmentChatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //todo: replace with real msg list
        adapter = new MessageListAdapter(getContext(), List.of(setupBaseMessage(1), setupBaseMessage(2)));
        binding.recyclerChat.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerChat.setAdapter(adapter);

        return root;
    }

    @Deprecated(message = "For testing purposes only")
    private BaseMessage setupBaseMessage(long id){
        BaseMessage message = new BaseMessage();

        User user = new User();
        user.setId(id);
        user.setName("JIHO");

        message.setMessageText("abc");
        message.setCreatedAt(System.currentTimeMillis());
        message.setSender(user);
        return message;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
