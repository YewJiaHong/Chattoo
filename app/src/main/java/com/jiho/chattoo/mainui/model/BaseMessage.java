package com.jiho.chattoo.mainui.model;

import android.graphics.Bitmap;
import lombok.Data;

@Data
public class BaseMessage {
    private String messageText;
    private String profileImage;
    private User sender;
    private String createdAt;
    private String readReceipt;
    private String Date;
}
