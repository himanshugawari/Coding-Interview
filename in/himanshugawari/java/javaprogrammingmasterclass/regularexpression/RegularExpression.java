package in.himanshugawari.java.javaprogrammingmasterclass.regularexpression;

// . wild card forall charcters
// ^ starts with
// $ ends with

public class RegularExpression {
	public static void main(String[] args) {
		String str = "I am a string. Yes, I am.";
		System.out.println(str);
		String newStr = str.replaceAll("I am", "You are");
		System.out.println(newStr);
		System.out.println();

		String alphNumeric = "abcDeeeF12Ghiiiijkl99z";
		System.out.println(alphNumeric);
		// . character matcher is for all characters. i.e "." is a wild card
		System.out.println(alphNumeric.replaceAll(".", "Y"));
		System.out.println();

		System.out.println(alphNumeric);
		System.out.println(alphNumeric.replaceAll("abcDeee", "YYY"));
		System.out.println();

		String secondStr = "abcDeeeF12GhabcDeeeiiiijkl99z";
		System.out.println(secondStr);
		// all occurrences are replaced
		System.out.println(secondStr.replaceAll("abcDeee", "YYY"));
		System.out.println();
		System.out.println(secondStr);
		// ^ start with boundary matcher
		System.out.println(secondStr.replaceAll("^abcDeee", "THE START "));
		System.out.println();

		System.out.println(alphNumeric.matches("^hello"));

		// matches only matches the entire string not with a part of the string
		System.out.println(alphNumeric.matches("abcDeee"));
		System.out.println(alphNumeric.matches("^abcDeee"));

		System.out.println(alphNumeric.matches("abcDeeeF12Ghiiiijkl99z"));
		System.out.println();

		System.out.println(secondStr);
		// $ end with boundary matcher
		System.out.println(secondStr.replaceAll("jkl99z$", " THE END"));
		System.out.println();

		System.out.println(alphNumeric);
		System.out.println(alphNumeric.replaceAll("[aei]", "X"));
		System.out.println(alphNumeric.replaceAll("[aei]", " REPLACED HERE "));
		System.out.println();

		System.out.println(alphNumeric);
		// replace only if [aei] is followed by [Fj]
		System.out.println(alphNumeric.replaceAll("[aei][Fj]", "X"));
		System.out.println();

		// capital or Small
		System.out.println("Happy".replaceAll("[Hh]appy", "Xappy"));
		System.out.println("happy".replaceAll("[Hh]appy", "Xappy"));
		System.out.println();

		String newAlphNumeric = "abcDeeeF12Ghiiiijkl99z";
		System.out.println(newAlphNumeric);
		// replace every letter except e or j using character class
		System.out.println(newAlphNumeric.replaceAll("[^ej]", "X"));
		// Is case sensitive
		System.out.println(newAlphNumeric.replaceAll("[abcdef345678]", "X"));
		System.out.println(newAlphNumeric.replaceAll("[a-f3-8]", "X"));
		System.out.println(newAlphNumeric.replaceAll("[a-fA-F3-8]", "X"));
		// Ignore Case Sensitivity for ascii for unicode use (?iu)
		System.out.println(newAlphNumeric.replaceAll("(?i)[a-f3-8]", "X"));
		// replace all digits
		System.out.println(newAlphNumeric.replaceAll("[0-9]", "X"));
		// replace all digits using \\d
		System.out.println(newAlphNumeric.replaceAll("\\d", "X"));
		// replace all non digits using \\D
		System.out.println(newAlphNumeric.replaceAll("\\D", "X"));
		System.out.println(newAlphNumeric.replaceAll("[a-zA-Z]", "X"));
		System.out.println();

		String hasWithSpaces = "I have blanks and\t tab, and also a newline\n";
		System.out.println(hasWithSpaces);
		// remove all spaces, tab, and newline using \\s
		System.out.println(hasWithSpaces.replaceAll("\\s", ""));
		// remove tab
		System.out.println(hasWithSpaces.replaceAll("\\t", ""));
		// remove newline
		System.out.println(hasWithSpaces.replaceAll("\\n", "X"));
		// replace all non white spaces, tabs and newline
		System.out.println(hasWithSpaces.replaceAll("\\S", "X"));
		System.out.println();

		// \\w matches a-z A-Z 0-9 and \\W for opposite
		System.out.println(newAlphNumeric);
		System.out.println(newAlphNumeric.replaceAll("\\w", "X"));
		System.out.println(newAlphNumeric.replaceAll("\\W", "X"));
		System.out.println();

		System.out.println(hasWithSpaces);
		System.out.println(hasWithSpaces.replaceAll("\\w", "X"));
		System.out.println(hasWithSpaces.replaceAll("\\W", "X"));
		System.out.println();

		System.out.println(hasWithSpaces);
		// Word boundary
		System.out.println(hasWithSpaces.replaceAll("\\b", "X"));
		System.out.println();

		String thirdStr = "abcDeeeF12Ghiiiijkl99z";
		System.out.println(thirdStr);
		System.out.println(thirdStr.replaceAll("^abcDeee", "YYY"));
		// using quantifier with exactly 3 e after D
		System.out.println(thirdStr.replaceAll("^abcDe{3}", "YYY"));
		// using quantifier with any numbers of e after D (i.e one or more e after D)
		System.out.println(thirdStr.replaceAll("^abcDe+", "YYY"));
		// using quantifier with optional e after D (i.e zero or one e after D)
		System.out.println(thirdStr.replaceAll("^abcDe*", "YYY"));
		System.out.println("abcDF12Ghiiiijkl99z".replaceAll("^abcDe*", "YYY"));
		// using quantifier replace with if 2 to 5 e after D (i.e 2-5 e after D)
		System.out.println(thirdStr.replaceAll("^abcDe{2,5}", "YYY"));
		System.out.println("abcDeF12Ghiiiijkl99z".replaceAll("^abcDe{2,5}", "YYY"));
		// h followed by any numbers of i followed by at least one j
		// one h+ zero or more i* followed by j
		System.out.println(thirdStr.replaceAll("h+i*j", "Y"));
				
	}
}
