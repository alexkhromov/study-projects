package com.alexkhromov.test.algorithms;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Solution for problem https://leetcode.com/problems/strong-password-checker/
 */
public class StrongPasswordChecker {

    public int strongPasswordChecker(String password) {

        int notAllowedNum = 0;
        Pattern allowedSymbolsPattern = Pattern.compile("[a-zA-Z0-9.!]+");
        Matcher allowedSymbolsMatcher = allowedSymbolsPattern.matcher(password);
        boolean onlyAllowedSymbols = allowedSymbolsMatcher.matches();
        if (!onlyAllowedSymbols) {
            notAllowedNum = password.length();
            while (allowedSymbolsMatcher.find()) {
                notAllowedNum -= allowedSymbolsMatcher.group().length();
            }
        }

        int requirementsChangesNum = 0;
        Pattern lowerCasePattern = Pattern.compile("[a-z]+");
        Matcher lowerCaseMatcher = lowerCasePattern.matcher(password);
        boolean lowerCasePresent = lowerCaseMatcher.find();
        if (!lowerCasePresent) {
            requirementsChangesNum++;
        }

        Pattern upperCasePattern = Pattern.compile("[A-Z]+");
        Matcher upperCaseMatcher = upperCasePattern.matcher(password);
        boolean upperCasePresent = upperCaseMatcher.find();
        if (!upperCasePresent) {
            requirementsChangesNum++;
        }

        Pattern digitPattern = Pattern.compile("[0-9]+");
        Matcher digitMatcher = digitPattern.matcher(password);
        boolean digitPresent = digitMatcher.find();
        if (!digitPresent) {
            requirementsChangesNum++;
        }

        Map<Integer, String> repeatedGroups = new HashMap<>();
        Pattern repeatedGroupPattern = Pattern.compile("([a-zA-Z0-9.!])\\1{2,}");
        Matcher repeatedGroupMatcher = repeatedGroupPattern.matcher(password);
        int count = 0;
        while (repeatedGroupMatcher.find()) {
            repeatedGroups.put(count++, repeatedGroupMatcher.group());
        }

        Map<Integer, String> repeatedGroupsSorted = repeatedGroups.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        if (password.length() < 6) {

            int underFlowNum = 6 - password.length();
            int changes = underFlowNum;
            int finalRequirementsChangesNum = requirementsChangesNum;

            requirementsChangesNum -= underFlowNum;

            if (requirementsChangesNum > 0 && repeatedGroupsSorted.isEmpty()) {
                changes += Math.abs(underFlowNum - requirementsChangesNum);
            }

            if (!repeatedGroupsSorted.isEmpty() && requirementsChangesNum > 0 && Math.abs(underFlowNum - finalRequirementsChangesNum) != 0) {
                requirementsChangesNum--;
                changes++;
            }

            for ( ; requirementsChangesNum > 0; requirementsChangesNum--) {
                if (notAllowedNum != 0) {
                    notAllowedNum--;
                } else {
                    break;
                }
            }

            return changes + notAllowedNum;

        } else if (password.length() > 20) {

            int overFlowNum = password.length() - 20;
            int changes = Math.abs(overFlowNum - notAllowedNum) + requirementsChangesNum;

            while (overFlowNum != 0 && !repeatedGroupsSorted.isEmpty()) {
                List<Integer> keysToRemove = new ArrayList<>();
                Map<Integer, String> replacementForRepeatedGroup = new HashMap<>();
                for (Map.Entry<Integer, String> entry : repeatedGroupsSorted.entrySet()) {
                    if (overFlowNum != 0 && entry.getValue().length() % 3 == 0) {
                        String newValue = entry.getValue().replaceFirst(".", "");
                        if (newValue.length() < 3) {
                            keysToRemove.add(entry.getKey());
                        } else {
                            replacementForRepeatedGroup.put(entry.getKey(), newValue);
                        }
                        overFlowNum--;
                    }
                }

                replacementForRepeatedGroup.forEach(repeatedGroupsSorted::replace);
                keysToRemove.forEach(repeatedGroupsSorted::remove);

                repeatedGroupsSorted = repeatedGroupsSorted.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.comparingInt(String::length).reversed()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                for (Map.Entry<Integer, String> entry : repeatedGroupsSorted.entrySet()) {
                    String newValue = entry.getValue();
                    while (overFlowNum != 0 && (newValue.length() % 5 != 0 && newValue.length() > 2)) {
                        newValue = newValue.replaceFirst(".", "");
                        repeatedGroupsSorted.put(entry.getKey(), newValue);
                        overFlowNum--;
                    }
                }

                repeatedGroupsSorted = repeatedGroupsSorted.entrySet()
                        .stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(
                                Map.Entry::getKey,
                                Map.Entry::getValue,
                                (oldValue, newValue) -> oldValue, LinkedHashMap::new));

                for (Map.Entry<Integer, String> entry : repeatedGroupsSorted.entrySet()) {
                    String newValue = entry.getValue();
                    while (overFlowNum != 0 && newValue.length() >= 3) {
                        newValue = newValue.replaceFirst(".", "");
                        repeatedGroupsSorted.put(entry.getKey(), newValue);
                        overFlowNum--;
                    }
                }
            }

            int finalRequirementsChangesNum = requirementsChangesNum;
            int fixRepeatedGroupsWithRequirements = repeatedGroupsSorted.values()
                    .stream()
                    .map(group -> group.length() / 3)
                    .reduce(Integer::sum)
                    .map(steps -> steps - finalRequirementsChangesNum)
                    .orElse(0);

            if (fixRepeatedGroupsWithRequirements > 0) {
                changes += fixRepeatedGroupsWithRequirements;
            }

            return changes;
        } else {

            int changes = requirementsChangesNum;

            notAllowedNum -= requirementsChangesNum;

            if (notAllowedNum > 0 && repeatedGroupsSorted.isEmpty()) {
                changes += Math.abs(notAllowedNum - requirementsChangesNum);
            }

            int finalRequirementsChangesNum = requirementsChangesNum;
            int fixRepeatedGroupsWithRequirements = repeatedGroupsSorted.values()
                    .stream()
                    .map(group -> group.length() / 3)
                    .reduce(Integer::sum)
                    .map(steps -> steps - finalRequirementsChangesNum)
                    .orElse(0);

            return changes + fixRepeatedGroupsWithRequirements;
        }
    }
}