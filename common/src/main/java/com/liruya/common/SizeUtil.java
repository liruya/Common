package com.liruya.common;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.TypedValue;

public class SizeUtil
{
    public static float dp2px( @NonNull Context context, float dp )
    {
        if ( context != null )
        {
            return TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics() );
        }
        return 0;
    }

    public static float sp2px( @NonNull Context context, float sp )
    {
        if ( context != null )
        {
            return sp * context.getResources().getDisplayMetrics().scaledDensity + 0.5f;
        }
        return 0;
    }

    public static float px2sp( @NonNull Context context, float px )
    {
        if ( context != null )
        {
            return px / (float) context.getResources().getDisplayMetrics().scaledDensity + 0.5f;
        }
        return 0;
    }
}
