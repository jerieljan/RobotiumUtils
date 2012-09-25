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

import com.jayway.android.robotium.solo.Solo;
import com.jerieljan.robotiumutils.classes.Sleep;

/**
 * A set of touch-related Robotium utilities.
 *
 * @author jerieljan
 */
public class TouchUtilities {

    /**
     * Performs a flinging action for navigating through view pagers.
     *
     * @param tester    the current Solo instance.
     * @param direction the direction to fling. Use Solo.RIGHT, LEFT, UP or DOWN.
     * @param steps     the number of steps needed to perform the gesture. More steps takes longer and slower.
     *                  Must be greater than 1.
     */
    public static void flingTo(Solo tester, int direction, int steps) {
        if (steps > 1) {
            switch (direction) {
                case Solo.RIGHT: {

                    tester.drag(0, 500, 200, 200, steps);
                    break;
                }
                case Solo.LEFT: {
                    tester.drag(500, 0, 200, 200, steps);
                    break;
                }
                case Solo.UP: {
                    tester.drag(250, 250, 600, 300, steps);
                    break;

                }
                case Solo.DOWN: {
                    tester.drag(250, 250, 300, 600, steps);
                    break;

                }
            }
        }
    }

    /**
     * Swipes the screen to the left or right multiple times.
     *
     * @param tester the current Solo instance.
     * @param page   the number of times to swipe. Enter negative numbers to swipe to the right instead.
     */
    public static void swipeTo(Solo tester, int page) {
        if (page > 0) {
            for (int i = 0; i < page; i++) {
                flingTo(tester, Solo.LEFT, 10);
                tester.sleep(Sleep.PAUSE_SECOND);
            }

        } else {
            for (int i = 0; i > page; i--) {
                flingTo(tester, Solo.RIGHT, 10);
                tester.sleep(Sleep.PAUSE_SECOND);

            }

        }
    }
}
