/*
 * Copyright (c) 2009 Sun Microsystems, Inc. All rights reserved.
 * Use is subject to license terms.
 */
package com.sun.jchowto.helloworld;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;

/**
 * Simple HelloWorldApplet extended applet
 */
public class HelloWorldApplet extends Applet {

    /**
     * Only this class's install method should create the applet object.
     */
    protected HelloWorldApplet() {
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
        new HelloWorldApplet();
    }

    /**
     * Processes an incoming APDU.
     * 
     * @see APDU
     * @param apdu
     *            the incoming APDU
     */
    @Override
    public void process(APDU apdu) {
        byte[] buffer = apdu.getBuffer();

        // check SELECT APDU command
        if ((buffer[ISO7816.OFFSET_CLA] == 0) &&
                (buffer[ISO7816.OFFSET_INS] == (byte) (0xA4))) {
            return;
        }

        apdu.setIncomingAndReceive();

        byte nameLength = buffer[ISO7816.OFFSET_LC];

        StringBuffer sb = new StringBuffer("Hello! ");
        for (int i = 0; i < nameLength; i++) {
            sb.append((char) buffer[ISO7816.OFFSET_CDATA + i]);
        }
        System.out.println("\n\n\nName is = " + sb);

        byte[] response = sb.toString().getBytes();

        apdu.setOutgoing();
        apdu.setOutgoingLength((short) response.length);
        apdu.sendBytesLong(response, (short) 0, (short) response.length);
    }

}
