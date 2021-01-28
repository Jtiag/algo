import java.util.Scanner;

/**
 * @author Jtiag
 * @desc
 * @time 2021/1/27 下午6:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[0];
        if (scanner.hasNext()) {
            String numString = scanner.next();
            String[] split = numString.split(" ");
            array = new int[split.length];
            for (int j = 0; j < split.length; j++) {
                int num = Integer.parseInt(split[j]);
                array[j] = num;
            }
        }
        quickSort(array, array.length);
        for (int i = array.length-1; i >= array.length-3; i--) {
            System.out.println(array[i] + " ");
        }
    }

    private static void quickSort(int[] array, int size) {
        quickSortInternally(array, 0, size - 1);
    }

    private static void quickSortInternally(int[] array, int p, int r) {
        if (p >= r) {
            return;
        }
        int n = partition(array, p, r);
        quickSortInternally(array, p, n - 1);
        quickSortInternally(array, n + 1, r);
    }

    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j = i; j < r; ++j) {
            if (array[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = array[i];
                    array[i++] = array[j];
                    array[j] = tmp;
                }
            }
        }
        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;
        return i;
    }
}
