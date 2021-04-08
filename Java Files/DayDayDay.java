public class DayDayDay {

	public static void main (String [] args) {
		String answer;

		answer = solution ("Sat", 23);
		System.out.println (answer);
	}

	public static String solution (String s, int k) {
		String [] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
		int i;
		int day;

		day = 0;
		i = 0;

		do {
			
			if (week [i].equals (s)) {
				day = i + 1;
				break;
			}
			i = i + 1;
		} while (i < 7);
		
		int end = day + k;

		do {
			if (i >= 6) {
				i = 0;	
			}
			else {
				i = i + 1;
			}
			day = day + 1;

		} while (day != end);
		
		return week [i];
	}
}