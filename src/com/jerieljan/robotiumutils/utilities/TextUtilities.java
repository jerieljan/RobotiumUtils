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

package com.jerieljan.robotiumutils.utilities;

import android.view.View;
import com.jayway.android.robotium.solo.Solo;
import com.jerieljan.robotiumutils.classes.FormEnvironment;

/**
 * A set of editText, field and form-related Robotium utilities.
 *
 * @author jerieljan
 */
public class TextUtilities {
    /**
     * Validates the maximum and minimum bounds of a particular form field.
     *
     * @param form the FormEnvironment instance to validate.
     * @param max  the maximum number of characters allowed.
     * @param min  the minimum number of characters allowed.
     */
    public static void validateLengths(FormEnvironment form, int max, int min) {
        if (form.getField().getVisibility() == View.VISIBLE) {
            Solo tester = form.getTester();
            tester.clearEditText(form.getField());

            //Test Upper Limits
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < max + 1; i++) {
                input.append('x');
            }

            tester.enterText(form.getField(), input.toString());
            //Only perform when the text field actually holds more than the max number of characters.
            if (form.getField().getText().length() > max) {
                tester.clickOnText(form.getSubmit());
                tester.assertCurrentActivity("Maximum field limit was accepted incorrectly: " + max, form.getCurrentActivity());
            }

            tester.clearEditText(form.getField());

            //Test Lower Limits

            if (min > 1) {
                input = new StringBuilder();
                for (int i = 0; i < min - 1; i++) {
                    input.append('x');
                }
                tester.enterText(form.getField(), input.toString());
                tester.clickOnText(form.getSubmit());
                tester.assertCurrentActivity("Minimum field limit was accepted incorrectly: " + min, form.getCurrentActivity());
            }

        }
    }

    public static void validateInvalidCharacters(FormEnvironment form, char c, int length) {
        StringBuilder input;

        input = new StringBuilder();
        for (int i = 0; i < length; i++) {
            input.append(c);
        }

        Solo tester = form.getTester();
        tester.clearEditText(form.getField());
        tester.enterText(form.getField(), input.toString());
        tester.clickOnText(form.getSubmit());
        tester.assertCurrentActivity("Invalid characters were accepted: ", form.getCurrentActivity());


    }

    public static void validateInvalidCharacters(FormEnvironment form, char[] chars, int length) {
        for (char c : chars) {
            validateInvalidCharacters(form, c, length);
        }
    }

    public static void validateInvalidStrings(FormEnvironment form, String[] strings, int length) {
        StringBuilder input;
        for (String str : strings) {
            input = new StringBuilder();
            for (int i = 0; i < length; i++) {
                input.append(str);
            }

            Solo tester = form.getTester();
            tester.clearEditText(form.getField());
            tester.enterText(form.getField(), input.toString());
            tester.clickOnText(form.getSubmit());
            tester.assertCurrentActivity("Invalid characters were accepted: ", form.getCurrentActivity());
        }
    }


}
