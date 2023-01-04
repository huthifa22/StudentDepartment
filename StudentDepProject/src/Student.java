
public class Student {

	private String name;
	private double GPA;

	public Student() {
		this(null, 0.0);
	}

	public Student(String name, double GPA) {
		this.name = name;
		this.GPA = GPA;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setGPA(double GPA) {
		this.GPA = GPA;
	}

	public Double getGPA() {
		return GPA;
	}

	@Override
	public String toString() {
		return String.format("Name: %s; GPA: %.2f.", getName(), getGPA());
	}

}
