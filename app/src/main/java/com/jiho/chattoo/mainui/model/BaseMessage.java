package com.jiho.chattoo.mainui.model;

import android.graphics.Bitmap;
import lombok.Data;

@Data
public class BaseMessage {
    private String messageText;
    private Bitmap profileImage;
    private User sender;
    private String createdAt;
    private String Date;
}
