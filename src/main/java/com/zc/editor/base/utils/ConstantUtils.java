package com.zc.editor.base.utils;

import com.zc.editor.R;

import java.util.Random;




public class ConstantUtils {

    public static int getDrawable(){
        return drawables[new Random().nextInt(drawables.length)];
    }
    public static int[] drawables = {
        R.drawable.emoji_00,
        R.drawable.emoji_01,
        R.drawable.emoji_02,
        R.drawable.emoji_03,
        R.drawable.emoji_04,
    };
}
