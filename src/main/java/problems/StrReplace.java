package problems;

/**
 * Created by BudaiK on Feb, 2020.
 * Please use this Google doc during your interview (your interviewer will see what you write here). To free your hands for typing, we recommend using a headset or speakerphone.
 *
 * Method signature
 *
 * class Replacement {
 *   int index;
 *   String before;
 *   String after;
 * }
 *
 * String applyReplacements(String input, List<Replacement> replacements) { … }
 *
 * Example
 *
 * input: "num foo;"
 *
 * replacements: {index: 0, before: "num", after: "String"}, {4, "foo", "value"}
 * output: "String value;"
 *
 * int startIndex = 0;
 * int delta =0;
 * // ordering replacements increasing -> o(mlgm)
 * int previousIndex;
 * for (Replacement r : replacements) {
 * 	String before = r.getBefore();
 * 	String after = r.getAfter();
 * 	int index = r.getIndex();
 * 	if (previousIndex + delta > index) {
 * 		throw new IllegalArgumentException(“Not valid input.”)
 *        }
 * 	startIndex = delta + index;
 *
 * 	String firstPart = input.subString(0, startIndex);
 * String middle = input.subString(startIndex, before.length);
 * String last = input.subString(startIndex + before.length);
 *
 * 	input = firstPart + after + last;
 *
 * delta += after.length - before.length;
 * previousIndex = index;
 *
 * }
 *
 * m -> n1 + n2 +... nk = n
 * Compl = O(mn)
 *
 * iteration: “String foo;” delta = 6 - 3 = 3
 * iteration: “String value;” delta= 3+ 2;
 */
public class StrReplace {
}
