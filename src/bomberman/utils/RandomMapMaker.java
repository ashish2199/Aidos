/**
 * Used to create random maps for testing purposes
 * @author tialim
 */
package bomberman.utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomMapMaker {

	private static List<String> distribution = entityDistribution();

	public static String makeRandomMap() {
		String map = "";
		for (int i = 0; i < 13; i++) {
			
			if (i == 0 || i == 12) {
				// create 31 repeated walls at the top or bottom
				map += lineOfWalls();
			}
			else if (i == 1) {
				map += "WP";
				map += generateRandomString(28);
				map += "W\n";
			}
			else {
				map += generateRandomRow();
			}
		}
		return map;
	}

	private static String lineOfWalls() {
		char[] repeat = new char[31];
		Arrays.fill(repeat, 'W');
		return new String(repeat) + "\n";
	}
	
	private static String generateRandomRow() {
		String s = "W";
		s += generateRandomString(29);
		return s + "W\n";
	}

	private static String generateRandomString(int length) {
		String s = "";
		for (int i = 0; i < length; i++) {
			int index = (int)(Math.random() * 100);
			s += distribution.get(index);
		}
		return s;
	}

	private static List<String> entityDistribution() {
		String[] d = new String[100];
		Arrays.fill(d, 0, 50, " ");
		Arrays.fill(d, 50, 75, "W");
		Arrays.fill(d, 70, 97, "#");
		Arrays.fill(d, 97, 98, "B");
		Arrays.fill(d, 98, 99, "E");
		Arrays.fill(d, 99, 100, "D");
		List<String> result = Arrays.asList(d);
		Collections.shuffle(result);
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(makeRandomMap());
	}

}
