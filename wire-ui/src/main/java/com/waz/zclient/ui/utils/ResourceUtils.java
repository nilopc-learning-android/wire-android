/**
 * Wire
 * Copyright (C) 2016 Wire Swiss GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.waz.zclient.ui.utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.DimenRes;
import android.util.TypedValue;
import com.waz.zclient.ui.R;

import java.util.Random;

public class ResourceUtils {
    public static final String TAG = ResourceUtils.class.getName();

    private ResourceUtils() {
    }

    /**
     * returns a float resource with the following structure
     * <p/>
     * <item name="resId" type="dimen" format="float"></item>
     */
    public static float getResourceFloat(Resources res, @DimenRes int resId) {
        TypedValue typedValue = new TypedValue();
        res.getValue(resId, typedValue, true);
        return typedValue.getFloat();
    }

    public static int getRandomAccentColor(Context context) {
        int accentColorPos = randInt(0, context.getResources().getInteger(R.integer.framework__num_of_accent_colors));
        switch (accentColorPos) {
            case 0: return context.getResources().getColor(R.color.accent_blue);
            case 1: return context.getResources().getColor(R.color.accent_orange);
            case 3: return context.getResources().getColor(R.color.accent_magenta);
            case 4: return context.getResources().getColor(R.color.accent_red);
            case 5: return context.getResources().getColor(R.color.accent_yellow);
            case 6: return context.getResources().getColor(R.color.accent_green);
            default: return context.getResources().getColor(R.color.accent_blue);
        }
    }

    public static int randInt(int min, int max) {
        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
