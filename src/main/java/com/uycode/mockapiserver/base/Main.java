package com.uycode.mockapiserver.base;

import com.uycode.mockapiserver.base.statics.SmallDog;
import com.uycode.mockapiserver.base.statics.WolfDog;

/**
 * @author Hyper
 * @email Hyper-Hack@outlook.com
 * @since 2021/4/6
 */
public class Main {

    public static void main(String[] args) {
        SmallDog dog = new WolfDog();

        dog.callDog();
        dog.getDogColor();
        dog.dogSize();

    }
}
