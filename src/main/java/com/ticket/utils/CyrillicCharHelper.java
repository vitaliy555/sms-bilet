package com.ticket.utils;

import java.util.Collection;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

public class CyrillicCharHelper {

    // return combinations by two char with all cyrillic chars
    public static Collection<String> getCharCombinations() {
        Collection<String> resultCombinations = Lists.newArrayList();
        Collection<CyrillicChar> alphabet = getAlphabet();
        for (CyrillicChar cyrillicChar : alphabet) {
            for (CyrillicChar aChar : alphabet) {
                resultCombinations.add(new String(new char[] { cyrillicChar.getChar(), aChar.getChar() }));
            }
        }
        return resultCombinations;
    }

    private static Collection<CyrillicChar> getAlphabet() {
        Collection<CyrillicChar> alphabet = Lists.newArrayList();
        // alphabet from À to Ï
        byte firstByte = -48;
        for (byte secondByte = -80; secondByte <= -65; secondByte++) {
            alphabet.add(new CyrillicChar(firstByte, secondByte));
        }
        // alphabet from Ï to ß
        firstByte = -47;
        for (byte secondByte = -128; secondByte <= -113; secondByte++) {
            alphabet.add(new CyrillicChar(firstByte, secondByte));
        }
        return alphabet;
    }

    static class CyrillicChar {
        private byte[] bytes = new byte[2];

        public CyrillicChar(byte firstByte, byte secondByte) {
            this.bytes[0] = firstByte;
            this.bytes[1] = secondByte;
        }

        public char getChar() {
            return new String(bytes, Charsets.UTF_8).charAt(0);
        }
    }

}
