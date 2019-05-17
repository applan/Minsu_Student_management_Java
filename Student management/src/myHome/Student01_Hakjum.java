package myHome;

public class Student01_Hakjum {

	public static String getHakjum(float avg) {
		String prHakjum ="";
	    if(avg >= 90) {
	    	prHakjum = "A학점";
	    }else if(avg >= 80) {
	    	prHakjum = "B학점";
	    }else if(avg >= 70) {
	    	prHakjum = "C학점";
	    }else if(avg >= 60) {
	    	prHakjum = "D학점";
	    }else {
	    	prHakjum = "F학점";
	    }
	    
	    return prHakjum;
	}
}
