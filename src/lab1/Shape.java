package lab1;

import java.util.Objects;
import java.util.Random;

public abstract class Shape { 
	protected String color;
	
	protected static int MIN_INT = 0;
	protected static int MAX_INT = 100;
	

	public Shape() {
		super();
		
		/*Цвет выбираем случайным образом из трех вариантов*/
		String[] colors = {"RED", "GREEN", "BLUE"};
		Random random = new Random();
		int pos = random.nextInt(colors.length);
		color = colors[pos];
	}

	
	public abstract double area();
	
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
