package com.example.flexzonecodepathgroupproject;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("Muscle")
public class StreamMuscle extends ParseObject {
    public static final String KEY_NAME = "MuscleName";
    public static final String KEY_MAIN_PIC = "MusclePicture";
    public static final String KEY_WORKOUT1 = "workout1";
    public static final String KEY_WORKOUT2 = "workout2";
    public static final String KEY_WORKOUT3 = "workout3";
    public static final String KEY_PIC_WORKOUT1 = "workout1Pic";
    public static final String KEY_PIC_WORKOUT2 = "workout2Pic";
    public static final String KEY_PIC_WORKOUT3 = "workout3Pic";
    public static final String KEY_DESCRIPTION = "description";

    public String getName() {
        return getString(KEY_NAME);
    }
    public void setName(String name) {
        put(KEY_NAME,name);
    }

    public String getDescription() {
        return getString(KEY_DESCRIPTION);
    }

    public void setDescription(String description) {
        put(KEY_DESCRIPTION, description);
    }

    public ParseFile getMainImage() {
        return getParseFile(KEY_MAIN_PIC);
    }

    public String  getWk1() {
        return getString(KEY_WORKOUT1);
    }
    public ParseFile getWorkout1Img() {
        return getParseFile(KEY_PIC_WORKOUT1);
    }

    public String  getWk2() {
        return getString(KEY_WORKOUT2);
    }
    public ParseFile getWorkout2Img() {
        return getParseFile(KEY_PIC_WORKOUT2);
    }


    public String getWk3() {
        return getString(KEY_WORKOUT3);
    }
    public ParseFile getWorkout3Img() {
        return getParseFile(KEY_PIC_WORKOUT3);
    }

//    public ParseUser getUser() {
//        return getParseUser(KEY_USER);
//    }
//    public  void setUser(ParseUser user) {
//        put(KEY_USER,user);
//    }


}
