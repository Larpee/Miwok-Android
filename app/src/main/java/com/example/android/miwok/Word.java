package com.example.android.miwok;

/**
 * Created by pilar_000 on 06/06/2017.
 */

public class Word {
    private String mMiwokWord;
    private String mDefaultTranslation;
	private int mImageResourceId;

    public Word(String defaultTranslation, String miwokWord) {
        mMiwokWord = miwokWord;
        mDefaultTranslation = defaultTranslation;
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
}
