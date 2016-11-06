package com.example.xyzreader.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.xyzreader.R;

import java.util.Hashtable;

/**
 * Created by sanjaydixit on 07/11/16.
 */

public class MyFontTextView extends  TextView{
    private String fontName;

    public MyFontTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public MyFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public MyFontTextView(Context context) {
        super(context);
        init(context, null);
    }

    public MyFontTextView(Context context, String fontName) {
        super(context);
        this.fontName = fontName;
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (!this.isInEditMode()) {
            if (attrs != null) {
                TypedArray a = getContext().obtainStyledAttributes(attrs,
                        R.styleable.MyFontTV);
                fontName = a.getString(R.styleable.MyFontTV_fontName);
                if (fontName != null) {
                    createFromAsset(context);
                }
                a.recycle();
            } else if (fontName != null) {
                createFromAsset(context);
            }
        }
    }

    private void createFromAsset(Context context) {
        if(fontName!=null) {
            setTypeface(Typefaces.get(context, fontName));
        }
    }
}