package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pilar_000 on 07/06/2017.
 */

class WordAdapter extends ArrayAdapter<Word> {
    // COULD BE PRIVATE [CHECK]
    private AudioManager mAudioManager;
    private int mColorResourceId;
    private MediaPlayer mMediaPlayer;
    // COULD BE PRIVATE [CHECK]
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            switch (focusChange) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    mMediaPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    mMediaPlayer.pause();
                    mMediaPlayer.seekTo(0);
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    releaseMediaPlayer();
            }
        }
    };
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };


    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context, 0, words);
        mColorResourceId = color;
        mAudioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);
    }

    public void releaseMediaPlayer() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;

            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Store the scrap view in the listView variable
        View listItem = convertView;

        // If there's no view to be reused, inflate one
        if (listItem == null) {
            listItem = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Set the background color of the view to be the category's color
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        View linearLayout = listItem.findViewById(R.id.linear_layout);
        linearLayout.setBackgroundColor(color);

        // Get Word at the current position
        final Word currentWord = getItem(position);

        // Set current Miwok Word on the appropriate TextView
        TextView miwokWord = (TextView) listItem.findViewById(R.id.miwok_word);
        miwokWord.setText(currentWord.getMiwokWord());

        // Set current default Word on the appropriate TextView
        TextView defalutTranslation = (TextView) listItem.findViewById(R.id.default_word);
        defalutTranslation.setText(currentWord.getDefaultTranslation());

        // Get the ImageView
        ImageView image = (ImageView) listItem.findViewById(R.id.image);

        // If the current Word has an image resource ID...
        if (currentWord.hasImage()) {
            // Set the ImageView's resource ID to be the current Word's image resource ID
            image.setImageResource(currentWord.getImageResourceId());
            // Set the ImageView's visibility to be VISIBLE
            image.setVisibility(View.VISIBLE);
        } else {
            // Set the ImageView's visibility to be GONE
            image.setVisibility(View.GONE);
        }

        /* Set OnClickListener on item */
        // Create MediaPlayer for the audio file

        // Set OnClickListener
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FINISH REQUESTING AUDIO FOCUS
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    releaseMediaPlayer();
                    mMediaPlayer = MediaPlayer.create(getContext(), currentWord.getAudioResourceId());
                    mMediaPlayer.setOnCompletionListener(mOnCompletionListener);
                    mMediaPlayer.start();
                }
            }
        });

        return listItem;
    }
}
