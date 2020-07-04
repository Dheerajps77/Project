package DecimalFormatterUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatterClass {
	
	
	
	public static void decimalFormatter()
	{
		String pattern = "###,###.###";
		try {
				DecimalFormat dc=new DecimalFormat(pattern);
				String str=dc.format(123456789.123);
				System.out.println(str);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void decimalFormatForSpecificLocale()
	{
		try {			
			String pattern = "###.###";
			NumberFormat numberFormat=NumberFormat.getInstance(Locale.CANADA);
			DecimalFormat dc=(DecimalFormat)numberFormat;
			dc.applyPattern(pattern);
			String format=dc.format(123456789.123);
			System.err.println(format);
		} catch (Exception e) {
			throw e;
		}
	}
	
	public static void main(String[] args) {
		
		//decimalFormatter();
		decimalFormatForSpecificLocale();
	}

}
