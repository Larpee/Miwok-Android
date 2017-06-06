/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import com.example.android.miwok_app.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);
        
		/* Get TextViews for all the categories and set OnClickListeners on them */
        // Numbers
        TextView numbersText = (TextView) findViewById(R.id.numbers);
        numbersText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrases = new Intent(MainActivity.this, NumbersActivity.class);
                startActivity(phrases);
            }
        });

        // Family
        TextView familyText = (TextView) findViewById(R.id.family);
        familyText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent family = new Intent(MainActivity.this, FamilyActivity.class);
                startActivity(family);
            }
        });

        // Phrases
        TextView phrasesText = (TextView) findViewById(R.id.phrases);
        phrasesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrases = new Intent(MainActivity.this, PhrasesActivity.class);
                startActivity(phrases);
            }
        });

        // Colors
        TextView colorsText = (TextView) findViewById(R.id.colors);
        colorsText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colors = new Intent(MainActivity.this, ColorsActivity.class);
                startActivity(colors);
            }
        });
    }

    public void openActivity(Class act) {
        Intent goToAct = new Intent(this, act);
        startActivity(goToAct);
    }
}
