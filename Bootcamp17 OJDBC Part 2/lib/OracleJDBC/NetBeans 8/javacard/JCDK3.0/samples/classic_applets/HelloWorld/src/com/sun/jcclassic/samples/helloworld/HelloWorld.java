/*
 * Copyright 2009 Sun Microsystems, Inc. All rights reserved.
 * Use is subject to license terms.
 */

// /*
// Workfile:@(#)HelloWorld.java	1.7
// Version:1.7
// Date:01/03/06
//
// Archive:  /Products/Europa/samples/com/sun/javacard/samples/HelloWorld/HelloWorld.java
// Modified:01/03/06 12:13:08
// Original author:  Mitch Butler
// */
package com.sun.jcclassic.samples.helloworld;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;
import javacard.framework.ISOException;
import javacard.framework.Util;

/**
 */

public class HelloWorld extends Applet {
    private byte[] echoBytes;
    private static final short LENGTH_ECHO_BYTES = 256;

    /**
     * Only this class's install method should create the applet object.
     */
    protected HelloWorld() {
        echoBytes = new byte[LENGTH_ECHO_BYTES];
        register();
    }

    /**
     * Installs this applet.
     *
     * @param bArray
     *            the array containing installation parameters
     * @param bOffset
     *            the starting offset in bArray
     * @param bLength
     *            the length in bytes of the parameter data in bArray
     */
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new HelloWorld();
    }

    /**
     * Processes an incoming APDU.
     *
     * @see APDU
     * @param apdu
     *            the incoming APDU
     * @exception ISOException
     *                with the response bytes per ISO 7816-4
     */
    public void process(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        
        // check SELECT APDU command
        if ((buffer[ISO7816.OFFSET_CLA] == 0) &&
                (buffer[ISO7816.OFFSET_INS] == (byte) (0xA4))) {
            return;
        }
        
        apdu.setIncomingAndReceive();

        byte nameLength = buffer[ISO7816.OFFSET_LC];
        byte[] greeting = {(byte)'H',(byte)'e',(byte)'l',(byte)'l',(byte)'o',(byte)'!',(byte)' '};

        short offset = Util.arrayCopy(buffer, ISO7816.OFFSET_CDATA, buffer,
                      (short)(ISO7816.OFFSET_CDATA+greeting.length), nameLength);
        Util.arrayCopy(greeting, (short)0, buffer, ISO7816.OFFSET_CDATA, (byte)(greeting.length));

        apdu.setOutgoing();
        apdu.setOutgoingLength((byte)(nameLength+greeting.length));
        apdu.sendBytes(ISO7816.OFFSET_CDATA, (byte)(nameLength+greeting.length));
    }
}
