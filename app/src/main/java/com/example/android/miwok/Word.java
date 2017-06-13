package com.example.android.miwok;

/**
 * Created by pilar_000 on 06/06/2017.
 */

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1; // Constant to represent no image was provided
    private String mMiwokWord; // Miwok word
    private String mDefaultTranslation; // Default translation of Miwok word
    // Set image resource ID to the NO_IMAGE_PROVIDED constant
    // If an image is provided, this changes
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private int mAudioResourceId; // Audio resource ID

    // Constructor for Words without an image
    public Word(String defaultTranslation, String miwokWord, int audioResourceId) {
        mMiwokWord = miwokWord;
        mDefaultTranslation = defaultTranslation;
        mAudioResourceId = audioResourceId;
    }

    // Constructor for Words with an image
    public Word(String defaultTranslation, String miwokWord, int imageResourceId, int audioResourceId) {
        mMiwokWord = miwokWord;
        mDefaultTranslation = defaultTranslation;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Getter methods for member variables
     **/

    public String getMiwokWord() {
        return mMiwokWord;
    }

    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public int getAudioResourceId() {
        return mAudioResourceId;
    }

    // Method to determine if word has an image
    // @return boolean representing if the Word has an image
    public boolean hasImage() {
        // If the image resource ID is equal to the NO_IMAGE_PROVIDED constant, return false
        // If it is different from the constant,
        // it means that it contains a valid resource ID, so the return value is true
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
