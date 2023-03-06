//
//1 . Дана строка sql-запроса "select * from students where ".
//Сформируйте часть WHERE этого запроса, используя StringBuilder.
//Данные для фильтрации приведены ниже в виде json строки.
//Если значение null, то параметр не должен попадать в запрос.
//Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;
public class DZ_2 {
	public static void main(String[] args) {
		String students = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\": null }";
		System.out.println(createRequest(students));
	}
	static String createRequest(String jsonStr) {
		Gson gson = new Gson();
		Map<String, Object> studentMap = gson.fromJson(jsonStr, new TypeToken<Map<String, Object>>(){}.getType());
		StringBuilder sb = new StringBuilder("SELECT * FROM students WHERE ");
		for (Map.Entry<String, Object> entry : studentMap.entrySet()) {
			if (entry.getValue() != null) {
				sb.append(entry.getKey());
				sb.append("=");
				sb.append(entry.getValue());
				sb.append(" and ");
			}
		}
		return sb.toString().substring(0, sb.toString().length() - 5);
	}
}

//2 . Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

//import java.io.IOException;
//		import java.util.Arrays;
//		import java.util.logging.FileHandler;
//		import java.util.logging.Logger;
//		import java.util.logging.SimpleFormatter;
//public class DZ_2 {
//	private static Logger logger;
//	public static void main(String[] args) {
//
//		FileHandler fileHandler;
//		try {
//			fileHandler = new FileHandler("DZ_2_log.log", true);
//		} catch (IOException e) {
//			throw new RuntimeException(e);
//		}
//		SimpleFormatter sFormatter = new SimpleFormatter();
//		fileHandler.setFormatter(sFormatter);
//		logger = Logger.getLogger(DZ_2.class.getName());
//		logger.addHandler(fileHandler);
//		logger.setUseParentHandlers(false);
//
//		int[] intArray = new int[]{4, 6, 2, 8, 3, 9, 11, 10, 5, 7, 1};
//		System.out.println(Arrays.toString(intArray));
//
//		bubbleSort(intArray);
//		System.out.println(Arrays.toString(intArray));
//	}
//
//	public static void bubbleSort(int[] arr) {
//		logger.info(String.format("""
//                Новая сортировка.
//
//                Исходный вид массива: %s""", Arrays.toString(arr)));
//		for (int i = 0; i < arr.length - 1; i++) {
//			for (int j = 0; j < arr.length - i - 1; j++) {
//				if (arr[j] > arr[j + 1]) {
//					int temp = arr[j];
//					arr[j] = arr[j + 1];
//					arr[j + 1] = temp;
//				}
//			}
//			logger.info(String.format("Массив после итерации № %d: %s", i + 1, Arrays.toString(arr) + "\n"));
//		}
//		logger.info(String.format("""
//                Сортировка завершена
//
//                Окончательный вид массива: %s""", Arrays.toString(arr)));
//	}
//}