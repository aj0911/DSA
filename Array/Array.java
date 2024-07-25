package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    private int[] arr;
    Scanner sc = new Scanner(System.in);

    // To take Input
    public Array(int length) {
        arr = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Enter the " + i + "th element: ");
            arr[i] = sc.nextInt();
        }
    }

    // To take input in this order "[2,3,4,5,6]"
    public Array(String inputString) {
        String trimString = inputString.substring(1, inputString.length() - 1);
        String[] strArr = trimString.split(",");
        arr = new int[strArr.length];
        for(int i=0;i<arr.length;i++)arr[i]=Integer.parseInt(strArr[i]);
    }

    // To Display the array
    @Override
    public String toString() {
        String arrString = "[";
        for (int i = 0; i < arr.length; i++)
            arrString += String.valueOf(arr[i]) + (i == arr.length - 1 ? "]" : ",");
        return arrString;
    }

    // To Display the size of an array
    public int size() {
        return arr.length;
    }

    // To find the maximum element of an array
    public int max() {
        int max = Integer.MIN_VALUE;
        for (int val : arr)
            if (val > max)
                max = val;
        return max;
    }

    // To find the minimum element of an array
    public int min() {
        int min = Integer.MAX_VALUE;
        for (int val : arr)
            if (val < min)
                min = val;
        return min;
    }

    // To swap two elements of an array
    public void swap(int i, int j) {
        arr[i] += arr[j];
        arr[j] = arr[i] - arr[j];
        arr[i] = arr[i] - arr[j];
    }

    // Searching Techniques
    // 1. Linear Search
    public int linearSearch(int data) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == data)
                return i;
        return -1;
    }

    // 2. Binary Search - Note!!! Array should be sorted
    public int binarySearch(int data) {
        int l = 0;
        int h = arr.length - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] > data)
                h = mid - 1;
            else if (arr[mid] < data)
                l = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    // Sorting Techniques
    // 1. Bubble Sort
    public void bubbleSort() {
        for (int counter = 0; counter < arr.length - 1; counter++) {
            for (int j = 0; j < arr.length - 1 - counter; j++) {
                if (arr[j] > arr[j + 1])
                    this.swap(j, j + 1);
            }
        }
    }

    // 2. Selection Sort
    public void selectionSort() {
        for (int counter = 0; counter < arr.length - 1; counter++) {
            int min = counter;
            for (int j = counter + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            if (min != counter)
                this.swap(min, counter);
        }
    }

    // 3. Insertion Sort
    public void insertionSort() {
        for (int counter = 1; counter < arr.length; counter++) {
            int val = arr[counter];
            int j = counter - 1;
            while (j >= 0 && arr[j] > val) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = val;
        }
    }

    // To find the lower bound
    public int lowerBound(int data) {
        int h = arr.length - 1;
        int l = 0;
        int ans = -1;
        while (h >= l) {
            int mid = (h + l) / 2;
            if (arr[mid] == data) {
                ans = mid;
                h = mid - 1;
            } else if (arr[mid] > data)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return ans;
    }

    // To find the upper bound
    public int upperBound(int data) {
        int h = arr.length - 1;
        int l = 0;
        int ans = -1;
        while (h >= l) {
            int mid = (h + l) / 2;
            if (arr[mid] == data) {
                ans = mid;
                l = mid + 1;
            } else if (arr[mid] > data)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return ans;
    }

    // To reverse an Array
    public void reverse() {
        for (int i = 0; i < arr.length / 2; i++)
            this.swap(i, arr.length - 1 - i);
    }

}
