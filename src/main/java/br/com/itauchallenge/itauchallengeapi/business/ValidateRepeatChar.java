package br.com.itauchallenge.itauchallengeapi.business;

import java.util.HashMap;
import java.util.Map;

public class ValidateRepeatChar {

    public boolean hasRepeted(String input) {
        char[] chars = input.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else {
                map.put(c, 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) > 1) {
                return true;
            }
        }
        return false;
    }

}
