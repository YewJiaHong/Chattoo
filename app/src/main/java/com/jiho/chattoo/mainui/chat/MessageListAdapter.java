package com.jiho.chattoo.mainui.chat;

import android.text.format.DateUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.jiho.chattoo.R;
import com.jiho.chattoo.mainui.model.BaseMessage;
import org.jetbrains.annotations.NotNull;

public class MessageListAdapter {

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
            mProfileImage.setImageBitmap(message.getProfileImage());
        }
    }

    private class ChatMeViewHolder extends RecyclerView.ViewHolder {
        TextView mDate;
        TextView mMessage;
        TextView mTimestamp;
        ChatMeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            mDate = itemView.findViewById(R.id.text_chat_date_me);
            mMessage = itemView.findViewById(R.id.text_chat_message_me);
            mTimestamp = itemView.findViewById(R.id.text_chat_timestamp_me);
        }

        void bind(BaseMessage message){
            mMessage.setText(message.getMessageText());
            mTimestamp.setText(DateUtils.formatDateTime(itemView.getContext(), Long.parseLong(message.getCreatedAt()), DateUtils.FORMAT_SHOW_TIME));
        }
    }
}
