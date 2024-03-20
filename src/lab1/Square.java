package lab1;

import java.util.Objects;

public class Square extends Shape {
	
	private double side_a; // сторона квадрата
	
	public Square() {
		super();
		side_a = 1;//  по-умолчанию генерируется квадрат со стороной, равной 1.
		System.out.println("Создан квадрат по-умолчанию");
	}
	
	public Square(double a) {
		super();
		
		if (a < MIN_INT || a > MAX_INT) {
			System.out.println("Сторона квадрата доолжна быть положительным числом от 0 о 99");
			return;
		}
	
		side_a = a;
		
	}
	
	
	public double getSide_a() {
		return side_a;
	}

	public void setSide_a(double side_a) {
		if (side_a < MIN_INT || side_a > MAX_INT) {
			System.out.println("Сторона квадрата доолжна быть положительным числом от 0 о 99");
			return;
		}
		
		this.side_a = side_a;
	}

	@Override
	public double area() {
		return Math.pow(side_a, 2); // находим площадь квадрата по формуле S = а^2
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side_a);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Square other = (Square) obj;
		return Double.doubleToLongBits(side_a) == Double.doubleToLongBits(other.side_a);
	}

	@Override
	public String toString() {
		return "Square [side_a=" + side_a + ", color=" + color + ", area=" + area() + "]";
	}
}
