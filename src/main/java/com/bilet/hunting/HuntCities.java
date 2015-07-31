package com.bilet.hunting;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import com.bilet.hunting.rest.RestHelper;
import com.bilet.hunting.rest.cmd.CitiesAndIdCommand;
import com.google.common.collect.Lists;

public class HuntCities {
    public static void main(String[] args) throws IOException {
        Collection<String> charCombinations = getCharCombinations(getAlphabet());
        for (String s : charCombinations) {
            System.out.println(s);
        }
        System.out.println("SIZE :"+charCombinations.size());

        for (String charCombination : charCombinations) {
//            RESTSetting restSetting = new RESTSetting("http://booking.uz.gov.ua/ru/purchase/station/"+charCombination+"/");
            RestHelper restHelper = new RestHelper(new CitiesAndIdCommand(charCombination));
            restHelper.execute();
        }
    }

    private static Collection<Cyrillic—har> getAlphabet() {
        Collection<Cyrillic—har> alphabet = Lists.newArrayList();
        // alphabet from ¿ to œ
        byte firstByte = -48;
        for (byte secondByte = -80; secondByte <= -65; secondByte++) {
            alphabet.add(new Cyrillic—har(firstByte, secondByte));
        }
        // alphabet from œ to ﬂ
        firstByte = -47;
        for (byte secondByte = -128; secondByte <= -113; secondByte++) {
            alphabet.add(new Cyrillic—har(firstByte, secondByte));
        }
        return alphabet;
    }
    private static Collection<String> getCharCombinations(Collection<Cyrillic—har> chars) throws UnsupportedEncodingException {
        Collection<String> resultCombinations = Lists.newArrayList();
        for (Cyrillic—har cyrillic—har : chars) {
            for (Cyrillic—har aChar : chars) {
                resultCombinations.add(new String(new char[]{cyrillic—har.getChar(),aChar.getChar()}));
            }
        }
        return resultCombinations;
    }
}
