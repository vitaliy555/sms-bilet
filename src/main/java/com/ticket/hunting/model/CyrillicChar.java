package com.ticket.hunting.model;

import com.google.common.base.Charsets;

import java.io.UnsupportedEncodingException;

public class CyrillicChar {
    private byte[] bytes = new byte[2];

    public CyrillicChar(byte firstByte, byte secondByte) {
        this.bytes[0] = firstByte;
        this.bytes[1] = secondByte;
    }

    public char getChar() throws UnsupportedEncodingException {
        return new String(bytes, Charsets.UTF_8).charAt(0);
    }
}
