package DaoLibrary;

import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

public interface DaoLibrary {

	/**
	 * Recupère les membres contenus dans un fichier CSV
	 *
	 * @param filename Le chemin du fichier CSV
	 * @return Le nombre de membres récupérés
	 */
	/**
	 * @param filename
	 * @param people
	 * @return
	 */
	public default int loadMembers(String filename, ArrayList<Person> people) {
		int cpt = 0;

		File f = new File(filename);

		if (f.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			String[] data = null;

			try {
				try {
					fr = new FileReader(f);
					br = new BufferedReader(fr);

					// Convertir en objet Person
					// StringTokenizer st = new StringTokenizer(ligne, ";");
					String ligne = br.readLine();

					// Lire une ligne du fichier
					while ((ligne = br.readLine()) != null) {
						// "a7aa0ae7-9ce3-44bc-a72a-894edb9a4653;Bob Smith;2;01-03-20"
						// split : divise  ";" --->séparteur  
						data = ligne.split(";");
						Person p = new Person(UUID.fromString(data[0]), data[1]);

						// ajouter cette Person dans people
						people.add(p);
						cpt++;
					}
				} finally {
					br.close();
				}
			} catch (IOException e) {

			}

			System.out.println(people);
		}

		return cpt;
	}

	/**
	 * Recupère les livres contenus dans un fichier CSV
	 *
	 * @param filename Le chemin du fichier CSV
	 * @return Le nombre de livres récupérés
	 */
	public default int loadBooks(String filename, ArrayList<Book> books) {
		int cpt = 0;

		File f = new File(filename);

		if (f.exists()) {
			FileReader fr = null;
			BufferedReader br = null;
			String[] data = null;

			try {
				try {
					fr = new FileReader(f);
					br = new BufferedReader(fr);

					// Convertir en objet Book
					// StringTokenizer st = new StringTokenizer(ligne, ";");
					String ligne = br.readLine();

					// Lire une ligne du fichier
					while ((ligne = br.readLine()) != null) {

						data = ligne.split(";");
						
						Book b = new Book(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]),
								Integer.parseInt(data[4]), data[5]);


						// ajouter ce Book dans books
						books.add(b);
						cpt++;
					}
				} finally {
					br.close();
				}
			} catch (IOException e) {

			}

			System.out.println(books);
		}

		return cpt;
	}

	/**
	 * Ecrit un fichier CSV contenant les membres de la bibliothèques
	 *
	 * @param filename Le chemin du fichier
	 */
	public default void saveMembers(String filename, ArrayList<Person> people) {
		File f = new File(filename);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			try {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);

				for (Person p : people) {
					bw.write(p.getId().toString() + ";" + p.getName());
					bw.newLine();
				}

			} finally {
				bw.close();
			}
		} catch (IOException e) {
			System.out.println("IOException pour people");
		}

	}

	/**
	 * Ecrit un fichier CSV contenant les livres de la bibliothèque
	 *
	 * @param filename Le chemin du fichier
	 */
	public default void saveBooks(String filename, ArrayList<Book> books) {
		File f = new File(filename);

		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			try {
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);

				for (Book b : books) {
					bw.write(b.getTitle() + ";" + b.getAuthor() + ";" + b.getTotalPage() + ";" + b.getLoanPeriod()
							+ ";" + b.getRentalPrice() + ";" + b.getLanguage());
					bw.newLine();
				}

			} finally {
				bw.close();
			}

		} catch (IOException e) {

		}

	}
}
