package loopInvariants;

public class Partition {

	/**
	 * Method takes in an array and partitions it such that all integers larger than
	 * array[0] are to the right and all integers less than array[0] are to the left
	 * 
	 * @param      array: the array to be partitioned
	 * @param left : the lower bound of array index to be partitioned
	 * @param      right: the upper bound of array index to be partitioned
	 * @return
	 */
	public static int partition(int[] array, int left, int right) {
		int p = left;
		int temp = 0;

		while (right >= left) {

			while (right >= left && array[left] <= array[p]) {
				left++;
			}
			while (right >= left && array[right] > array[p]) {
				right--;
			}

			if (right > left) {
				temp = array[left];
				array[left] = array[right];
				array[right] = temp;
			}
		}
		temp = array[right];
		array[right] = array[p];
		array[p] = temp;

		return right;
	}

	/**
	 * helper method which takes a an array and message and prints out the array
	 * with he provided message used in testing
	 * 
	 * @param arr: the array to be printed
	 * @param msg: the message to be printed
	 */
	public static void printArray(int[] arr, String msg) {
		System.out.println("\n" + msg + ": ");
		for (int j = 0; j < arr.length; j++) {
			System.out.print(arr[j] + ", ");
		}
		System.out.println("\n");
	}

	/**
	 * method to select the k smallest element from an array
	 * 
	 * @param a: array to be processed
	 * @param k: order of smallest number to be selected
	 * @return the value of the k smallest number
	 */
	public static int select(int a[], int k) {
		return selectKernel(a, k, 0, (a.length - 1));
	}

	/**
	 * kernel method for select which recursively calls itself to return the k
	 * smallest element from an array
	 * 
	 * @param      a: array to be processed
	 * @param      k: order of smallest number to be selected
	 * @param left : the lower bound of array index to be partitioned
	 * @param      right: the upper bound of array index to be partitioned
	 * @return
	 */
	public static int selectKernel(int a[], int k, int left, int right) {
		if ((right - left) < 2) {
			return a[left];
		} else {
			int middle = partition(a, left, right);
			if (middle == (k - 1)) {
				return a[middle];
			} else if (middle > (k - 1)) {
				return selectKernel(a, k, left, (middle - 1));
			} else if (middle < (k - 1)) {
				return selectKernel(a, k, (middle + 1), right);
			}
		}
		return 0;
	}

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static int median(int a[]) {
		return select(a, ((a.length + 1) / 2));
	}

	/**
	 * 
	 * @param a
	 */
	public static void quicksort(int a[]) {
		quicksortKernel(a, 0, a.length - 1);
	}

	/**
	 * 
	 * @param a
	 * @param left
	 * @param right
	 */
	public static void quicksortKernel(int a[], int left, int right) {
		if (right >= left) {
			int middle = partition(a, left, right);
			quicksortKernel(a, left, middle - 1);
			quicksortKernel(a, middle + 1, right);
		}
	}

	/**
	 * Method to implement the Dutch national flag algorithm in the order red,
	 * white,blue,unsorted; represented as red : 0, white:1, blue:2
	 * 
	 * @param a: array to be processed
	 */
	public static void dutch1(int a[]) {
		int red = 0;
		int white = 0;
		int blue = 0;
		int u = 0;
		int length = a.length;
		int temp = -1;

		while (u < length) {
			if (a[u] == 0) {
				temp = a[u];
				a[u] = a[blue];
				a[blue] = a[white];
				a[white] = a[red];
				a[red] = temp;
				white++;
				blue++;
				u++;
			} else if (a[u] == 1) {
				temp = a[u];
				a[u] = a[blue];
				a[blue] = a[white];
				a[white] = temp;
				blue++;
				u++;
			} else if (a[u] == 2) {
				u++;
			}
		}
	}

	/**
	 * Method to implement the Dutch national flag algorithm in the order red,
	 * white, unsorted, blue; represented as red : 0, white:1, blue:2
	 * 
	 * @param a: array to be processed
	 */
	public static void dutch2(int a[]) {
		int red = 0;
		int white = 0;
		int blue = a.length;
		int u = 0;
		int temp = -1;

		while (u < blue) {
			if (a[u] == 0) {
				temp = a[u];
				a[u] = a[white];
				a[white] = a[red];
				a[red] = temp;
				white++;
				u++;
			} else if (a[u] == 1) {
				u++;
			} else if (a[u] == 2) {
				blue--;
				temp = a[u];
				a[u] = a[blue];
				a[blue] = temp;
			}

		}
	}

	/**
	 * Method used to run tests
	 */
	public static void main(String args[]) {
		int Values[] = { 5, 2, 3, 5, 11, 76, 43, 6, 7, 1, 22 };
		int Values2[] = { 1, 8, 3, 4, 5, 6, 7, 7, 9, 10 };
		int Values3[] = { 5, 10, 9, 8, 3, 7, 4, 3, 2, 1 };
		int Values4[] = { 3, 10, 9, 8, 3, 7, 4, 3, 2, 1 };
		int Values5[] = { 8, 22 };

		System.out.println("Testing for partition(), select() and median()");

		printArray(Values, "Initial array ");
		System.out.println("Middle : " + partition(Values, 0, 10));
		System.out.println("3rd Smallest Element : " + select(Values, 3));
		System.out.println("Median Element : " + median(Values));
		printArray(Values, "Final array ");

		printArray(Values2, "Initial array ");
		System.out.println("Middle : " + partition(Values2, 0, 9));
		System.out.println("2nd Smallest Element : " + select(Values2, 2));
		System.out.println("Median Element : " + median(Values2));
		printArray(Values2, "Final array ");

		printArray(Values3, "Initial array ");
		System.out.println("Middle : " + partition(Values3, 0, 9));
		System.out.println("1st Smallest Element : " + select(Values3, 1));
		System.out.println("Median Element : " + median(Values3));
		printArray(Values3, "Final array ");

		printArray(Values4, "Initial array ");
		System.out.println("Middle : " + partition(Values4, 0, 9));
		System.out.println("5th Smallest Element : " + select(Values4, 5));
		System.out.println("Median Element : " + median(Values4));
		printArray(Values4, "Final array ");

		printArray(Values5, "Initial array ");
		System.out.println("Middle : " + partition(Values5, 0, 1));
		System.out.println("2th Smallest Element : " + select(Values5, 2));
		System.out.println("Median Element : " + median(Values5));
		printArray(Values5, "Final array ");

		System.out.println("Testing for quickSort");
		printArray(Values, "Initial array ");
		quicksort(Values);
		printArray(Values, "Final array ");

		printArray(Values2, "Initial array ");
		quicksort(Values2);
		printArray(Values2, "Final array ");

		printArray(Values3, "Initial array ");
		quicksort(Values3);
		printArray(Values3, "Final array ");

		printArray(Values4, "Initial array ");
		quicksort(Values4);
		printArray(Values4, "Final array ");

		printArray(Values5, "Initial array ");
		quicksort(Values5);
		printArray(Values5, "Final array ");

		System.out.println("Testing for dutch1()");
		int Flag[] = { 0, 1, 2, 0, 0, 2, 1, 2 };
		dutch1(Flag);
		printArray(Flag, "Final array ");

		int Flag2[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
		dutch1(Flag2);
		printArray(Flag2, "Final array ");

		int Flag3[] = { 2, 2, 2, 1, 1, 1, 0, 0, 0 };
		dutch1(Flag3);
		printArray(Flag3, "Final array ");

		int Flag4[] = { 1, 1, 1, 2, 2, 2, 0, 0, 0 };
		dutch1(Flag4);

		System.out.println("Testing for dutch2()");
		printArray(Flag4, "Final array ");
		int Flag5[] = { 0, 1, 2, 0, 0, 2, 1, 2 };
		dutch2(Flag5);
		printArray(Flag5, "Final array ");

		int Flag6[] = { 0, 0, 0, 1, 1, 1, 2, 2, 2 };
		dutch2(Flag6);
		printArray(Flag6, "Final array ");

		int Flag7[] = { 2, 2, 2, 1, 1, 1, 0, 0, 0 };
		dutch2(Flag7);
		printArray(Flag7, "Final array ");

		int Flag8[] = { 1, 1, 1, 2, 2, 2, 0, 0, 0 };
		dutch2(Flag8);
		printArray(Flag8, "Final array ");

	}

}
