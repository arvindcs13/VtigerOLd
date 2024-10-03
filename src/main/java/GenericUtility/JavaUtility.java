package GenericUtility;

import java.util.Random;

public class JavaUtility {

	public int genrateRandomNum()  {
		Random rd = new Random();
		int num = rd.nextInt(1000);
		return num;

	}

}
