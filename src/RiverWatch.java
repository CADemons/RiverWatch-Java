import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RiverWatch {

	public static void main(String args[]){
		try{
			String pass = new Password().password;
			String address = "http://localhost/write.php";
			Date dconn = new Date();
			SimpleDateFormat dform = new SimpleDateFormat("yyyy:MM:dd:HH:mm");
			String date = dform.format(dconn);
<<<<<<< HEAD
			String data = date +"," + level;
=======
>>>>>>> df707550987198912432b603fcd33647c84dc408
			URL url = new URL(address + "?authcode=" + pass + "&data=" + data);
			URLConnection request = url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
