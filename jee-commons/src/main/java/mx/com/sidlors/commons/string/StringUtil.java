package mx.com.sidlors.commons.string;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {

	public static void main(String[] args) {
		String str = "love Java Programm", str2 = "jAva";

		System.out.println("Using the StringUtils Class");

		// Using StringUtils.abbreviate()
		System.out.println("Using StringUtils.abbreviate()");
		System.out.println("str = " + str);
		String abstr = StringUtils.abbreviate(str, 14);
		System.out.println("After abbreviation abstr=" + abstr);
		abstr = StringUtils.abbreviate(str, 7, 14);
		System.out.println("After abbreviation abstr=" + abstr);

		// Using StringUtils.abbreviateMiddle()
		abstr = StringUtils.abbreviateMiddle(str, "...", 16);
		System.out.println("After abbreviation abstr=" + abstr);


		// Using StringUtils.reverse()
		System.out.println("Reverse str : " + StringUtils.reverse(str));
		// Using StringUtils.capitalize()
		System.out.println("str2 = " + str2);
		str2 = StringUtils.capitalize(str2);
		System.out.println("After capitalize : " + str2);

		// Using StringUtils.uncapitalize()
		System.out.println("str2 = " + str2);
		str2 = StringUtils.uncapitalize(str2);
		System.out.println("After uncapitalize : " + str2);

		// Using StringUtils.swapCase()
		System.out.println("str2 = " + str2);
		str2 = StringUtils.swapCase(str2);
		System.out.println("After swap case : " + str2);

		// Using StringUtils.lowerCase()
		System.out.println("str2 = " + str2);
		str2 = StringUtils.lowerCase(str2);
		System.out.println("After lower case : " + str2);

		// Using StringUtils.lowerCase()
		System.out.println("str2 = " + str2);
		str2 = StringUtils.upperCase(str2);
		System.out.println("After upper case : " + str2);

		// Using StringUtils.center()
		System.out.println("str2 = " + str2);
		String cstr = StringUtils.center(str2, 10, '-');
		System.out.println("After centerring : " + cstr);

		// Using StringUtils.chomp()
		str2 = str2 + "\n";
		System.out.println("str2 =" + str2 + "With new Line");
		str2 = StringUtils.chomp(str2);
		System.out.println("Now str2 = " + str2 + " After chomp");

		// Using StringUtils.contains()
		if (StringUtils.containsIgnoreCase(str, "JAVA"))
			System.out.println(str + " is about Java");
		else
			System.out.println(str + " is not about Java");

		// Using StringUtils.deleteWhiteSpace()
		System.out.println("str = " + str);
		String newstr = StringUtils.deleteWhitespace(str);
		System.out.println("newstr = " + newstr);

		// Using StringUtils.chop()
		System.out.println("cstr =" + cstr);
		cstr = StringUtils.chop(cstr);
		System.out.println(" After chop : " + cstr);

		// Using StringUtils.endsWithIgnoreCase()
		if (StringUtils.endsWithIgnoreCase(str, "ing"))
			System.out.println(str + " ends with a \"ing\"");
		else
			System.out.println(str + " does not ends with a \"ing\"");

		// Using StringUtils.endsWithIgnoreCase()
		if (StringUtils.startsWithIgnoreCase(str, "rivu"))
			System.out.println(str + " starts with a \"rivu\"");
		else
			System.out.println(str + " does not starts with \"Rivu\"");

		String x = "This is a String", x1 = "This is String 1", x2 = "This is String 2", x3 = "This is a String";
		System.out.println("x = " + x);
		System.out.println("x1 = " + x1);
		System.out.println("x2 = " + x2);
		System.out.println("x2 = " + x3);

		// using StringUtils.equals()
		if (StringUtils.equals(x1, x2))
			System.out.println("x1 and x2 are equal");
		else
			System.out.println("x1 and x2 are not equal");
		if (StringUtils.equalsIgnoreCase(x, x3))
			System.out.println("x and x3 are equal");
		else
			System.out.println("x and x3 are not equal");

		// using StringUtils.difference()
		String d1 = StringUtils.difference(x, x1);
		System.out.println("Difference between x and x1 : " + d1);
		String d2 = StringUtils.difference(x1, x2);
		System.out.println("Difference between x1 and x2 : " + d2);
		String d3 = StringUtils.difference(x1, x);
		System.out.println("Difference between x1 and x : " + d3);

		// using StringUtils.getCommonPrefix()
		System.out.println("Common Prefix in x,x1,x2,x3 is : " + StringUtils.getCommonPrefix(x, x1, x2, x3));

		

		// using StringUtils.getLevenshteinDistance()
		int l1 = StringUtils.getLevenshteinDistance(x, x1);
		int l2 = StringUtils.getLevenshteinDistance(x1, x2);
		int l3 = StringUtils.getLevenshteinDistance(x2, x3);
		int l4 = StringUtils.getLevenshteinDistance(x, x3);
		int l5 = StringUtils.getLevenshteinDistance(x2, x3, 3);
		System.out.println("Levenshtein Distance between x and x1 : " + l1);
		System.out.println("Levenshtein Distance between x1 and x2 : " + l2);
		System.out.println("Levenshtein Distance between x2 and x3 : " + l3);
		System.out.println("Levenshtein Distance between x and x3 : " + l4);
		System.out.println("Levenshtein Distance between x2 and x3 upto threshold 3 : " + l5);

		// Using StringUtils.isAllLowerCase()
		System.out.println("isAllLowerCase(str) = " + StringUtils.isAllLowerCase(str));
		// Using StringUtils.isAllUpperCase()
		System.out.println("isAllUpperCase(str) = " + StringUtils.isAllUpperCase(str));
		// Using StringUtils.isAlpha()
		System.out.println("isAlpha(str) = " + StringUtils.isAlpha(str));
		// Using StringUtils.isAlphanumeric()
		System.out.println("isAlphanumeric(str) = " + StringUtils.isAlphanumeric(str));
		// Using StringUtils.isAlphanumericSpace()
		System.out.println("isAlphanumericSpace(str) = " + StringUtils.isAlphanumericSpace(str));
		// Using StringUtils.isAlphaSpace()
		System.out.println("isAlphaSpace(str) = " + StringUtils.isAlphaSpace(str));
		// Using StringUtils.isAsciiPrintable()
		System.out.println("isAsciiPrintable(str) = " + StringUtils.isAsciiPrintable(str));
		// Using StringUtils.isBlank()
		System.out.println("isBlank(str) = " + StringUtils.isBlank(str));

		// Using StringUtils.rightPad()
		System.out.println("Before Rightpad : " + cstr);
		String rp = StringUtils.rightPad(cstr, 15, 'x');
		System.out.println("After Rightpad : " + rp);

		// Using StringUtils.replace()
		rp = StringUtils.replace(rp, "-", ".");
		System.out.println("After replace " + rp);

		// Using StringUtils.repeat()
		rp = StringUtils.repeat(rp, ">", 5);
		System.out.println("After repeat " + rp);

		// Using StringUtils.split()
		System.out.println("Splitting str:-");
		String[] strs = StringUtils.split(str, " ");
		for (String s : strs) {
			System.out.println(s);
		}

		// Using StringUtils.strip()
		String xx = "java to java";
		System.out.println("before strip : " + xx);
		String s = StringUtils.strip(xx, "aj");
		System.out.println("After strip : " + s);

	}
}
