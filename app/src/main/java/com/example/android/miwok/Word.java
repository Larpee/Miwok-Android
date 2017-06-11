package com.example.android.miwok;

/**
 * Created by pilar_000 on 06/06/2017.
 */

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String mMiwokWord;
    private String mDefaultTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String defaultTranslation, String miwokWord) {
        mMiwokWord = miwokWord;
        mDefaultTranslation = defaultTranslation;
    }
	
	public Word(String defaultTranslation, String miwokWord, int imageResId) {
		mMiwokWord = miwokWord;
		mDefaultTranslation = defaultTranslation;
		mImageResourceId = imageResId;
	}

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }
	
	public int getImageResourceId()
	{
		return mImageResourceId;
	}

    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
