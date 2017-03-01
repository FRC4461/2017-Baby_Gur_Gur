package org.usfirst.frc.team4461.robot;

import java.util.Date;

public class Util {
	
	/**
	 * This is allow you to call for Util.timeStamp("") And will add an auto time stamp for you
	 * @param textArg
	 */
	public static void timeStamp(String textArg){
		Date date = new Date();
		System.out.println(date+" 4461:"+textArg);
	}//End timeStamp
	
}//End Class