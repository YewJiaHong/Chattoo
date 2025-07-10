package com.jiho.chattoo.mainui.model;

import android.graphics.Bitmap;
import lombok.Data;

@Data
public class BaseMessage {
    private String messageText;
    private String profileImage;
    private User sender;
    /**
     * Created time in epoch
     */
    private long createdAt;
    private String readReceipt;
}
