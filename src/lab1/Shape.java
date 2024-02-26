package lab1;

import java.util.Objects;

public abstract class Shape { 
	private static int id = 0;
	
	protected static int MIN_INT = 0;
	protected static int MAX_INT = 100;
	
	protected String color;

	public Shape() {
		super();
		id++;
	}

	
	
	public abstract double area();

	public static int getId() {
		return id;
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int hashCode() {
		return Objects.hash(color);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shape other = (Shape) obj;
		return Objects.equals(color, other.color);
	}

	@Override
	public String toString() {
		return "Shape [color=" + color + "]";
	}
	
	
}
