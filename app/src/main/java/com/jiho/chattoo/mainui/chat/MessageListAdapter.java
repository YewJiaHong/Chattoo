package com.jiho.chattoo.mainui.chat;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jiho.chattoo.R;
import com.jiho.chattoo.mainui.enums.ViewTypeMessage;
import com.jiho.chattoo.mainui.model.BaseMessage;
import com.jiho.chattoo.mainui.sharedPref.SharedPreferenceAbstract;
import com.jiho.chattoo.mainui.sharedPref.SharedPreferenceAbstractImpl;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MessageListAdapter extends RecyclerView.Adapter{
    private Context context;
    private List<BaseMessage> messages;
    private SharedPreferenceAbstract sharedPreferenceAbstract;

    private class ChatOtherViewHolder extends RecyclerView.ViewHolder{
        TextView mDate;
        TextView mMessage;
        TextView mTimestamp;
        TextView mName;
        ImageView mProfileImage;
        ChatOtherViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.text_chat_date_other);
            mMessage = itemView.findViewById(R.id.text_chat_message_other);
            mTimestamp = itemView.findViewById(R.id.text_chat_timestamp_other);
            mName = itemView.findViewById(R.id.text_chat_user_other);
            mProfileImage = itemView.findViewById(R.id.image_chat_profile_other);
        }

        void bind(BaseMessage message){
            mMessage.setText(message.getMessageText());
            mTimestamp.setText(DateUtils.formatDateTime(itemView.getContext(), Long.parseLong(message.getCreatedAt()), DateUtils.FORMAT_SHOW_TIME));
            mName.setText(message.getSender().getName());
            mProfileImage.setImageResource(R.drawable.icon);
        }
    }

    private class ChatMeViewHolder extends RecyclerView.ViewHolder {
        TextView mDate;
        TextView mMessage;
        TextView mTimestamp;
        ImageView mReadReceipt;
        ChatMeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.text_chat_date_me);
            mMessage = itemView.findViewById(R.id.text_chat_message_me);
            mTimestamp = itemView.findViewById(R.id.text_chat_timestamp_me);
            mReadReceipt = itemView.findViewById(R.id.text_chat_read_receipt);
        }

        void bind(BaseMessage message){
            mMessage.setText(message.getMessageText());
            mTimestamp.setText(DateUtils.formatDateTime(itemView.getContext(), Long.parseLong(message.getCreatedAt()), DateUtils.FORMAT_SHOW_TIME));
        }
    }

    public MessageListAdapter(Context context, List<BaseMessage> messages){
        this.context = context;
        this.messages = messages;
        sharedPreferenceAbstract = new SharedPreferenceAbstractImpl(context);
    }

    @NonNull
    @Override
    public @NotNull RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == ViewTypeMessage.SENT.getVal()){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_me, parent, false);
            return new ChatMeViewHolder(view);
        } else if (viewType == ViewTypeMessage.RECEIVED.getVal()){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat_other, parent, false);
            return new ChatOtherViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        BaseMessage message = messages.get(position);

        if (holder.getItemViewType() == ViewTypeMessage.SENT.getVal()) {
            ((ChatMeViewHolder) holder).bind(message);
        } else if (holder.getItemViewType() == ViewTypeMessage.RECEIVED.getVal()) {
            ((ChatOtherViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemViewType(int position) {
        BaseMessage message = messages.get(position);

        //if the sender is not the user themselves, meaning is received
        //todo: when login success, set their self id in shared pref
        if (!String.valueOf(message.getSender().getId()).equals(sharedPreferenceAbstract.getSelfId())){
            return ViewTypeMessage.RECEIVED.getVal();
        } else{
            return ViewTypeMessage.SENT.getVal();
        }
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
