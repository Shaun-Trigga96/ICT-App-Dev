//import java.util.Calendar;
import java.util.Date;
import java.awt.*;

public class Calc extends Thread {
	int hour, minute, second;
	Label display;
	int diff;
	
	Calc(Label s, int d) {
		display = s;
		diff = d;
	}
	
	public void show() {
		display.setText(hour + ":" + minute + ":" + second);
	}
	
	public void run() {
	  while (true) {
		/* get the system time
		Calendar rightNow = Calendar.getInstance();
		hour = rightNow.HOUR;
		minute = rightNow.MINUTE;
		second = rightNow.SECOND;
		*/
		Date now = new Date();
		// hour = now.getHour();		 use the api - search index for correct usage
		hour = now.getHours();
		minute = now.getMinutes();
		second = now.getSeconds();

		hour += diff;		// change the time based on the object/country
		
		if (hour > 23)
			hour = hour - 24;
		else if (hour < 0)
			hour = 24 + hour;
		
		// call the display method in the TimeGUI class and pass the time??
		show();
	  }
	}
}