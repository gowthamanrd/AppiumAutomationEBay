import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {

	public static void main(String[] args) {
		String total = " June 2017  S M T W T F S                1   2   3   4   5   6   7   8   9   10   11   12   13   14   15   16   17   18   19   20   21   22   23   24   25   26   27   28   29   30   31                     Privacy And Terms  |  Provide Feedback  ";
		
		//int month = total.indexOf("S");
		
		String myMonth = total.substring(2, total.indexOf("S")-8);
		String myYear = total.substring(total.indexOf("S")-8, total.indexOf("S")-3);
		System.out.println(myYear);

	}

}
