package be.digitalia.fosdem.utils;

public class ArrayUtils {

	public static int indexOf(long[] array, long value) {
		for (int i = 0; i < array.length; ++i) {
			if (array[i] == value) {
				return i;
			}
		}
		return -1;
	}
}
