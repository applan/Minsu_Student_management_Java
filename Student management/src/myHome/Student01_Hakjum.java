package myHome;

public class Student01_Hakjum {

	public static String getHakjum(float avg) {
		String prHakjum ="";
	    if(avg >= 90) {
	    	prHakjum = "A����";
	    }else if(avg >= 80) {
	    	prHakjum = "B����";
	    }else if(avg >= 70) {
	    	prHakjum = "C����";
	    }else if(avg >= 60) {
	    	prHakjum = "D����";
	    }else {
	    	prHakjum = "F����";
	    }
	    
	    return prHakjum;
	}
}
