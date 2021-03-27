package hello;

import static java.nio.file.StandardOpenOption.APPEND;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DetermineDuplicateNo {

	public static void main(String[] args) {

		File file = new File("F:/vino--programs-2021/duplicatenumbers.txt");
		Path path = Paths.get(file.toString());

		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			OutputStream output = new BufferedOutputStream(Files.newOutputStream(path, APPEND));
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;

			while ((line = reader.readLine()) != null) {
				int values = Integer.parseInt(line);
				list.add(values);

			}
			System.out.println("ArrayList Elements: " + list);

			Object[] object_array = list.toArray();
			int objectarray_length = object_array.length;

			int[] array = new int[objectarray_length];

			System.out.println("Array Element :");
			for (int i = 0; i < objectarray_length; i++) {

				array[i] = (int) object_array[i];
				System.out.print(array[i] + " ");

			}

			int[] frequency = new int[array.length];

			for (int i = 0; i < array.length; i++) {

				int number = array[i];
				int count = 1;
				for (int j = i + 1; j < array.length; j++) {
					if (number == array[j]) {
						count++;
						frequency[j] = -1;

					}

				}

				if (frequency[i] != -1) {
					frequency[i] = count;

				}

			}

			int[] duplicate = new int[array.length];
			int j = 0;
			for (int i = 0; i < frequency.length; i++) {
				if (frequency[i] > 1) {
					duplicate[j] = array[i];
					j++;

				}
			}
			System.out.println();
			System.out.println("Duplicate Elements:");
			for (int i = 0; i < duplicate.length; i++) {
				if (duplicate[i] > 0)
					System.out.println(duplicate[i] + " ");
			}
			reader.close();

		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

}