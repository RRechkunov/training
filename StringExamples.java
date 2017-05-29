/**
*
*_______Work with text_______
* 
*
*
* #String, #StringBuilder, #StringBuffer
*
*@author Rechkunov Roman
*@version 29.05
*
*/
class StringExamples {

	public static void main(String[] args) {
		String s1 = "Java";
		String s2 = new String("Home");
		String s3 = new String(new char[]{'A', 'B', 'C'});
		String s4 = new String(s3);
		String s5 = new String(new byte[]{65, 66, 67});
		String s6 = new String(new byte[]{0, 65, 0, 66});
		System.out.printf("s1 = %s, s2 = %s, s3 = %s, s4 = %s, s5 = %s, s6 = %s", s1, s2, s3, s4, s5, s6);

	}

}