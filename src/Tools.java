
public class Tools {
	
	/**
	 * +-+-+-+-+-+ object +-+-+-+-+-+
	 * @param tekst
	 */
	public static void track1(Object tekst) {	
		System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+- "+ tekst + "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
	}
	
	/**
	 * <<<<<<<<<< object >>>>>>>>>>>>
	 * @param tekst
	 */
	public static void track2(Object tekst) {	
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< "+ tekst + ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
	/**
	 * prints one line of : -------------------------
	 */
	public static void visibleLine(){
		System.out.println("-------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * || object ||
	 * @param tekst
	 */
	public static void track3(Object tekst) {	
		System.out.println(" || "+ tekst + " || ");
	}
	
	
	public static Object toNull(Object object) {
		if (object != null) {
			return object;
		}
		return (object);
	}
	
	public static void line() {
		System.out.println("");
	}
	/**
	 * Prints "number" of empty lines
	 * @param number
	 */
	public static void lines(int number) {
		for(int i = 1; i<=number; i++) {
			System.out.println("");
		}
	}
	public static void printObject(Object object) {
			System.out.println(object);
	}
	/**
	 * Finds the first available free slot in array and returns index, else it returns -1.
	 * @param object
	 * @return returns index to the available slot.
	 */
	public static int findFirstAvailableSlotInArray(Object[] object) {
		for (int i = 0; i < object.length; i++) {
			if (object[i] == null) {
				return i;
			}
		}
//		System.out.println("\nThis array is full\n");
		return -1;
	}
	/**
	 * Test if object is in array. Returns true if it is. 
	 * @param objectArray
	 * @param object
	 * @return
	 */
	public static boolean contains(Object[] objectArray, Object object ) {
		for (Object o : objectArray) {
			if (o == null) {
				continue;
			}
			if (o == object) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Check if an array contains a object. 
	 * @param objectArray
	 * @return
	 */
	public static boolean containsAnyObject(Object [] objectArray) {
		for (Object object: objectArray) {
			if (object != null) {
				return true;
			}
		}
		return false;
	}
}
