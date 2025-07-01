package com.jiho.chattoo.mainui.login;

public abstract class LoginResult {
    public static class Success extends LoginResult {}
    public static class Loading extends LoginResult {}
    public static class Error extends LoginResult {
        private final String message;
        public Error(String message) { this.message = message; }
        public String getMessage() { return message; }
    }
}
