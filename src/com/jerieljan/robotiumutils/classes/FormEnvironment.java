/*
 * Copyright 2012 Jeriel Jan del Prado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jerieljan.robotiumutils.classes;

import android.widget.EditText;
import com.jayway.android.robotium.solo.Solo;

/**
 * @author jerieljan
 */
public class FormEnvironment {
    private Solo tester;
    private EditText field;
    private String submit;
    private Class<?> currentActivity;
    private String originalText;

    public String getOriginalText() {
        return originalText;
    }

    public FormEnvironment(Solo tester, String submit, EditText field, Class<?> currentActivity) {
        this.tester = tester;
        this.submit = submit;
        this.field = field;
        this.currentActivity = currentActivity;
        originalText = field.getText().toString();
    }

    public void setField(EditText field) {
        this.field = field;
        originalText = field.getText().toString();
    }

    public void setCurrentActivity(Class<?> currentActivity) {
        this.currentActivity = currentActivity;
    }

    public Class<?> getCurrentActivity() {
        return currentActivity;
    }

    public EditText getField() {
        return field;
    }

    public String getSubmit() {
        return submit;
    }

    public Solo getTester() {
        return tester;
    }
}
