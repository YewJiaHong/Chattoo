package com.jiho.chattoo.mainui.sharedPref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceAbstractImpl implements SharedPreferenceAbstract{
    private static final String PREF_NAME = "app_prefs";
    private static final String KEY_SELF_ID = "self_id";
    private final SharedPreferences prefs;

    public SharedPreferenceAbstractImpl(Context context) {
        this.prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);;
    }

    @Override
    public void setSelfId(String id) {
        prefs.edit().putString(KEY_SELF_ID, id).apply();
    }

    @Override
    public String getSelfId() {
        return prefs.getString(KEY_SELF_ID, null);
    }

    @Override
    public void clearSelfId() {
        prefs.edit().remove(KEY_SELF_ID).apply();
    }
}
