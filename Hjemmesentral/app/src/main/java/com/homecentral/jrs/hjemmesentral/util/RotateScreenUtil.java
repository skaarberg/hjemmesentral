package com.homecentral.jrs.hjemmesentral.util;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class RotateScreenUtil {

    public static void rotateScreen(final LinearLayout layout, final Activity activity) {

        Display display = activity.getWindowManager().getDefaultDisplay();

        Point size = new Point();
        display.getSize(size);
        int h = size.x;
        int w = size.y;

        layout.setRotation(180.0f);

        ViewGroup.LayoutParams lp = layout.getLayoutParams();
        layout.setLayoutParams(lp);
        layout.requestLayout();
    }
}
