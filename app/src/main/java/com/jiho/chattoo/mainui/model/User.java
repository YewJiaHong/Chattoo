package com.jiho.chattoo.mainui.model;

import lombok.Data;

@Data
public class User {
    private long id;
    private String name;
    private String password;
    private String salt;
    private String profileUrl;
}
