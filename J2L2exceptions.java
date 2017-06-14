class J2L2exceptions {
	private int sizex, sizey, calculation;


	String cleanSpaces(String t){							//clean all spaces
		String result="";
		for (int i=0;i<t.length();i++)
			if (!(t.charAt(i) == ' ')) result+=t.charAt(i);
		return result;
	} 

	String cleanEnters(String t){ 							//clean Enters
		String result="";
		for (int i=0;i<t.length();i++)
			if (!(t.charAt(i) == '\n')) result+=t.charAt(i);
		return result;
	} 

	String[][] makeStringArray(String t){					// set array [sizex][sizey]
															// make array from string	
		for (int x = 0; x < t.length();x++)
			if (t.charAt(x) == '\n') sizex++;		
		sizex++;
		sizey = t.indexOf("\n");
		
		t = cleanEnters(t);

		String [][] result = new String[sizex][sizey];
		int n=0;
		for (int i = 0; i<sizex; i++)
			for (int j = 0; j<sizey; j++){
				result[i][j] = String.valueOf(t.charAt(n));
				n++;
			}	
		return result;
	}

	void showArray(int [][] tarr){
		for (int i=0 ; i<sizex; i++){
			for (int j=0; j<sizey; j++){
				System.out.print(tarr[i][j]+" ");
			}
		System.out.println();
		}	
	}

	int[][] makeIntArrayFromString(String[][] tarr){
		int[][] result = new int[tarr.length][tarr[0].length];
		for (int i=0;i<tarr.length;i++){
			for (int j=0;j<tarr[i].length;j++)
				try {
					result[i][j]=Integer.parseInt(tarr[i][j]);
					calculation += result[i][j];
					}
				catch (Exception ex) {
					System.out.print(ex);
					System.out.printf(" in %s - %s\n",j+1,i+1);
				}			
		}	
		return result;	
	}

	float calculate (){
		return calculation/2;
	}

	J2L2exceptions(String text){
		sizex=0;  
		sizey=0;
		calculation = 0;
		String t = cleanSpaces(text);
		int[][] intarray = makeIntArrayFromString(makeStringArray(t)); 
		showArray(intarray);

	}

	public static void main(String[] args) {
		J2L2exceptions app = new J2L2exceptions("1 5 1 2\n2 5 2 y\n5 6 3 1\n3 5 c 0");
		System.out.println(app.calculate());
		
	}
}