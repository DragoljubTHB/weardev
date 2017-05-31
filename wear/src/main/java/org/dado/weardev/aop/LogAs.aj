package org.dado.weardev.aop;

import android.util.Log;

/**
 * Created by dado on 22.05.17.
 */
public aspect LogAs {
    pointcut p() : execution(* *.*(..));
    before() : p() && !within(de.piobyte.ddd.abgleich.aop.LogAs)
            {
                Log.d("aop", thisJoinPoint.getSignature().toShortString());
            }
}
