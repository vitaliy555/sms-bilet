package com.bilet.hunting;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.List;

import com.bilet.hunting.dto.Stations;
import com.bilet.hunting.model.Cyrillic—har;
import com.bilet.hunting.rest.RestHelper;
import com.bilet.hunting.rest.cmd.custom_cmd.StationsCommand;
import com.google.common.collect.Lists;
import com.google.gson.Gson;

public class HuntCities {
    static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {
        Collection<String> charCombinations = getCharCombinations(getAlphabet());
        for (String s : charCombinations) {
            System.out.println(s);
        }
        System.out.println("SIZE :" + charCombinations.size());

        List<Stations> stations = Lists.newArrayList();
        for (String charCombination : charCombinations) {
            RestHelper restHelper = new RestHelper(new StationsCommand(charCombination));
            stations.add(gson.fromJson(restHelper.execute(), Stations.class));
        }
        // TODO transformations
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

    private static Collection<String> getCharCombinations(Collection<Cyrillic—har> chars)
            throws UnsupportedEncodingException {
        Collection<String> resultCombinations = Lists.newArrayList();
        for (Cyrillic—har cyrillic—har : chars) {
            for (Cyrillic—har aChar : chars) {
                resultCombinations.add(new String(new char[] { cyrillic—har.getChar(), aChar.getChar() }));
            }
        }
        return resultCombinations;
    }
}
