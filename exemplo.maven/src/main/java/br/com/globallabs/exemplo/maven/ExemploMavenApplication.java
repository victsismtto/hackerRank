package br.com.globallabs.exemplo.maven;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class ExemploMavenApplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String size_list = in.nextLine();
		Integer size_number = Integer.parseInt(size_list);
		String list = in.nextLine();
		String[] numbers_string = list.split(" ");
		ArrayList list_input = new ArrayList<>();

		if (numbers_string.length == size_number) {
			for (int i = 0; i < numbers_string.length; i++) {
				list_input.add(numbers_string[i]);
			}
		}
		String queries_string = in.nextLine();
		Integer queries_number = Integer.parseInt(queries_string);
		Integer contador = 0;
		while (contador < queries_number) {
			String querie = in.nextLine();
			String parameters = in.nextLine();
			if (querie.equals("Insert")) {
				String[] parameters_insert_string = parameters.split(" ");
				int index = Integer.parseInt(parameters_insert_string[0]);
				if (index < list_input.size()) {
					list_input.add(index, parameters_insert_string[1]);
				} if (index == list_input.size()) {
					list_input.add(parameters_insert_string[1]);
				}

			} else {
				int parameters_ajustment = Integer.parseInt(parameters);
				if (list_input.size() > parameters_ajustment) {
					list_input.remove(parameters_ajustment);
				}
			}
			contador++;
		}

		System.out.print(list_input.get(0));
		for (int i  = 1; i < list_input.size(); i++) {
			System.out.print(" " + list_input.get(i));
		}

	}
}
