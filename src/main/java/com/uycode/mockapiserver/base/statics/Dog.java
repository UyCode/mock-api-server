package com.uycode.mockapiserver.base.statics;

/**
 * @author Hyper
 * @email Hyper-Hack@outlook.com
 * @since 4/6/2021/10:23:47
 */

public interface Dog {

    /**
     * <p>
     * if this method not override by concrete <strong>class</strong> like WolfDog,
     * then it will use the implemented method in the
     * abstract class.
     * </p>
     */
    public void callDog();

    /**
     * get the dog's color
     */
    public void getDogColor();
}
