package com.triplez.javaconcurrencyinpractice.introduction;

import net.jcip.annotations.*;

/**
 * 1.1.UnsafeSequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
public class UnsafeSequence {
    private int value;

    /**
     * Returns a unique value.
     */
    public int getNext() {
        return value++;
    }
}