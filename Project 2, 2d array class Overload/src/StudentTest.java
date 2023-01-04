import java.util.Scanner;

public class StudentTest {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.printf("How many classes?: ");
		int classes = input.nextInt();

		Student[][] dept = new Student[classes][];

		for (int i = 0; i < classes; i++) {

			System.out.printf("\nHow many students in class-%d:  ", i + 1);
			int students = input.nextInt();

			dept[i] = new Student[students];

			for (int j = 0; j < students; j++) {

				System.out.printf("Student name? ");
				String name = input.next();

				System.out.printf("Student GPA? ");
				double GPA = input.nextDouble();

				while (GPA <= 0 || GPA > 4.0) {

					System.out.printf("   The GPA must be in the range [0.0, 4.0], try again ");
					GPA = input.nextDouble();
				}
				dept[i][j] = new Student(name, GPA);
			}
		}

		System.out.printf("\nTo find the same name or same GPA" + "\n  1--to find the same name"
				+ "\n  2--to find the same GPA" + "\n  0--EXIT\n");
		int s = input.nextInt();

		while (s != 0) {
			switch (s) {

			case 1:
				System.out.printf("\nEnter the Name you are to find: ");
				String name = input.next();

				int count = 0;

				for (int row = 0; row < dept.length; row++) {
					for (int col = 0; col < dept[row].length; col++)

						if (dept[row][col].getName().equals(name)) {
							count++;
							System.out.printf("Class-%d: %s\n", row + 1, dept[row][col]);
						}
				}
				System.out.printf("A total of %d students having %s as their names.\n", count, name);

				break;

			case 2:
				System.out.printf("\nEnter the GPA you are to find: ");
				double GPA = input.nextDouble();

				int c = 0;

				for (int row = 0; row < dept.length; row++) {
					for (int col = 0; col < dept[row].length; col++)

						if (dept[row][col].getGPA().equals(GPA)) {
							c++;
							System.out.printf("Class-%d: %s\n", row + 1, dept[row][col]);
						}
				}
				System.out.printf("A total of %d students having %.2f as their GPAs.\n", c, GPA);

				break;

			}
			System.out.printf("\nTo find the same name or same GPA" + "\n  1--to find the same name"
					+ "\n  2--to find the same GPA" + "\n  0--EXIT\n");
			s = input.nextInt();

		}

		System.out.printf("Now to find in one class who have the highest GPAs"
				+ "\n--using one method-findHighestGPA(Student[])" + "\nEnter the class number: ");
		int oneClass = input.nextInt();

		getFindHighestGPA(dept[oneClass - 1]);

		System.out.printf("\nNow to find in All classes who have the highest GPAs"
				+ "\n--using another method-findHighestGPA(Student[][])"
				+ "\nThe follwing students have the highest GPAs:\n");

		getFindHighestGPA(dept);
	}

	public static void getFindHighestGPA(Student[] thisClass) {

		double maxGPA = thisClass[0].getGPA();

		for (int row = 0; row < thisClass.length; row++) {

			if (thisClass[row].getGPA() > maxGPA) {
				maxGPA = thisClass[row].getGPA();
			}
		}
		for (int row = 0; row < thisClass.length; row++) {

			if (thisClass[row].getGPA() == maxGPA) {
				maxGPA = thisClass[row].getGPA();
				System.out.printf("Class-%d: %s\n", row + 1, thisClass[row]);
			}
		}
	}

	public static void getFindHighestGPA(Student[][] allClasses) {

		double maxGPA = allClasses[0][0].getGPA();

		for (int row = 0; row < allClasses.length; row++) {
			for (int col = 0; col < allClasses[row].length; col++)
				if (allClasses[row][col].getGPA() > maxGPA) {
					maxGPA = allClasses[row][col].getGPA();
				}
		}
		for (int row = 0; row < allClasses.length; row++) {
			for (int col = 0; col < allClasses[row].length; col++)
				if (allClasses[row][col].getGPA() == maxGPA) {
					maxGPA = allClasses[row][col].getGPA();
					System.out.printf("Class-%d: %s\n", row + 1, allClasses[row][col]);
				}
		}
	}
}
