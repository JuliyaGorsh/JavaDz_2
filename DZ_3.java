
//1.Реализовать алгоритм сортировки слиянием

import java.util.Arrays;
public class DZ_3 {
	public static int[] mergeSort(int[] sortArr) {
		int[] temp1 = Arrays.copyOf(sortArr, sortArr.length);
		int[] temp2 = new int[sortArr.length];
		int[] result = mergeSortInner(temp1, temp2, 0, sortArr.length);
		return result;
	}
	public static int[] mergeSortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
		if (startIndex >= endIndex - 1) {
			return buffer1;
		}
		int middle = startIndex + (endIndex - startIndex) / 2;
		int[] sorted1 = mergeSortInner(buffer1, buffer2, startIndex, middle);
		int[] sorted2 = mergeSortInner(buffer1, buffer2, middle, endIndex);

		int index1 = startIndex;
		int index2 = middle;
		int newIndex = startIndex;
		int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
		while (index1 < middle && index2 < endIndex) {
			result[newIndex++] = sorted1[index1] < sorted2[index2]
					? sorted1[index1++] : sorted2[index2++];
		}
		while (index1 < middle) {
			result[newIndex++] = sorted1[index1++];
		}
		while (index2 < endIndex) {
			result[newIndex++] = sorted2[index2++];
		}
		return result;
	}
	public static void main(String args[]) {
		int[] sortArr = {3, 7, 2, 11, 1, 23, 5, 30};
		int[] result = mergeSort(sortArr);
		System.out.println(Arrays.toString(sortArr));
		System.out.println(Arrays.toString(result));
	}
}

//
//2.Пусть дан произвольный список целых чисел, удалить из него четные числа
//
//import java.util.ArrayList;
//import java.util.Random;
//
//public class DZ_3 {
//	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
//		ArrayList<Integer> list1 = new ArrayList<>();
//		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
//			list.add(random.nextInt(1, 10));
//		}
//		System.out.println("Начальный список:");
//		System.out.println(list);
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) % 2 != 0){
//				list1.add(list.get(i));
//			}
//		}
//		System.out.println("Список без четных чисел:");
//		System.out.println(list1);
//	}
//}



//3.Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое этого списка.

//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Random;
//
//public class DZ_3 {
//	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>();
//		Random random = new Random();
//		for (int i = 0; i < 10; i++) {
//			list.add(random.nextInt(1, 25));
//		}
//		System.out.println("Начальный список:");
//		System.out.println(list);
//		int srAr = 0;
//		double res = 0;
//		for (int i = 0; i < list.size(); i++) {
//			srAr = srAr + list.get(i);
//		}
//		res = srAr  / (double) list.size();
//		System.out.printf("Минимальное значение - %d"+ "\n", Collections.min(list));
//		System.out.printf("Максимальное значение - %d"+ "\n", Collections.max(list));
//		System.out.printf("Среднее арифметическое - %s"+ "\n", res);
//	}
//}