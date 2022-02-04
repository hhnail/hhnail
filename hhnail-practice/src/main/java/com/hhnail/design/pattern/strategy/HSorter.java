package com.hhnail.design.pattern.strategy;

public class HSorter<T> {

	public void sort(T[] arr, HComparator<T> comparator) {
		for (int j = 0; j < arr.length; j++) {
			int minIndex = j;
			for (int i = j; i < arr.length; i++) {
				if (comparator.compare(arr[i], arr[minIndex]) < 0) {
					minIndex = i;
				}
			}
			swap(arr, minIndex, j);
		}
	}

	public void swap(T[] arr, int index1, int index2) {
		T temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

}
