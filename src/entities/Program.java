package entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Map<String, Integer> votes = new HashMap<>();		
		/* 	
		 * FILE ".csv":
		 * Alex Blue,15
		 * Maria Green,22
		 * Bob Brown,21
		 * Alex Blue,30
		 * Bob Brown,15
		 * Maria Green,27
		 * Maria Green,22
		 * Bob Brown,25
		 * Alex Blue,31
		 */
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))){

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(","); // fields[0] = name & fields[1] = votesQuantity
				
				if (votes.containsKey(fields[0])) {
					Integer sum = votes.get(fields[0]) + Integer.parseInt(fields[1]);
					votes.put(fields[0], sum);
				}
				else {
					votes.put(fields[0], Integer.parseInt(fields[1]));
				}
				line = br.readLine();
			}
			for (String key : votes.keySet()) {
				System.out.println(key + ":\t" + votes.get(key));
			}
		}
		catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
		sc.close();
	}
}
