package com.alexkhromov.test.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for problem https://leetcode.com/problems/strong-password-checker/
 */
public class StrongPasswordChecker {

    public int strongPasswordChecker(String password) {

        int requirementsChangesNum = 0;
        requirementsChangesNum += password.matches("^(.*)([a-z]+)(.*)$") ? 0 : 1;
        requirementsChangesNum += password.matches("^(.*)([A-Z]+)(.*)$") ? 0 : 1;
        requirementsChangesNum += password.matches("^(.*)([0-9]+)(.*)$") ? 0 : 1;

        List<String> repeatedGroups = new ArrayList<>();
        int insert = 6, delete = -20, repeatedGroupsFix = 0;

        int startGroup = 0;
        for (int i = 0; i < password.length(); i++, insert--, delete++) {

            if (i == 0 ||
                    password.charAt(startGroup) == password.charAt(i) && i != password.length() - 1 ||
                    i == password.length() - 1 && password.charAt(i - 1) != password.charAt(i)) {

                continue;
            }

            int endGroup = i == password.length() - 1 ? password.length() : i;
            if (endGroup - startGroup >= 3) {

                String repeatedGroup =
                        password.substring(startGroup, endGroup);

                repeatedGroups.add(repeatedGroup);

                repeatedGroupsFix += repeatedGroup.length() / 3;
            }
            startGroup = i;
        }

        int changes = 0;

        if (insert >= 0) {
            for (int i = insert; i > 0; i--) {
                requirementsChangesNum--;
                repeatedGroupsFix--;
                changes++;
            }
            if (requirementsChangesNum > 0) {
                changes += requirementsChangesNum;
                repeatedGroupsFix -= requirementsChangesNum;
            }
            if (repeatedGroupsFix > 0) {
                changes += repeatedGroupsFix;
            }
        } else if (delete >= 0) {
            int rem = 0;
            while (rem < 3 && delete > 0 && repeatedGroupsFix != 0) {
                for (int i = 0; i < repeatedGroups.size() && delete >= rem; i++) {
                    String repeatedGroup = repeatedGroups.get(i);
                    if (repeatedGroup.length() > 2 && repeatedGroup.length() % 3 == rem) {
                        repeatedGroups.set(i, repeatedGroup.substring(0, repeatedGroup.length() - (rem + 1)));
                        delete -= (rem + 1);
                        changes += (rem + 1);
                        repeatedGroupsFix--;
                    }
                }
                if (rem == 2 && delete > 3) {
                    rem = 0;
                } else {
                    rem++;
                }
            }
            if (delete > 0) {
                changes += delete;
            }
            if (requirementsChangesNum > 0) {
                changes += requirementsChangesNum;
                repeatedGroupsFix -= requirementsChangesNum;
            }
            if (repeatedGroupsFix > 0) {
                changes += repeatedGroupsFix;
            }
        } else {
            for (String repeatedGroup : repeatedGroups) {
                int changesForGroup = repeatedGroup.length() / 3;
                requirementsChangesNum -= changesForGroup;
                changes += changesForGroup;
            }
            if (requirementsChangesNum > 0) {
                changes += requirementsChangesNum;
            }
        }

        return changes;
    }
}