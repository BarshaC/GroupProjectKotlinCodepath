package com.example.flexzonecodepathgroupproject;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("_User")
public class User extends ParseObject {
    public static final String KEY_STREAK = "DailyStreak";

    public Number getStreak() {
        return getNumber(KEY_STREAK);
    }
}
