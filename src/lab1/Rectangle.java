package lab1;

import java.util.Objects;


public class Rectangle extends Shape{
	private double side_a, side_b;//стороны прямоугольника
	
	public Rectangle() {
		super();
		side_a = 1;
		side_b = 1;
		
		System.out.println("Создан прямоугольник по-умолчанию");
	}
	
	public Rectangle(double a, double b) {
		super();
		if (a < MIN_INT || a > MAX_INT) {
			System.out.println("Длина стороны 'a' прямоугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		if (b < MIN_INT || b > MAX_INT) {
			System.out.println("Длина стороны 'b' прямоугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		
		side_a = a;
		side_b = b;
	}
	
	
	public double getSide_a() {
		return side_a;
	}

	public void setSide_a(double side_a) {
		this.side_a = side_a;
	}

	public double getSide_b() {
		return side_b;
	}

	public void setSide_b(double side_b) {
		this.side_b = side_b;
	}
	
	@Override
	public double area() {
		return side_a * side_b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(side_a, side_b);
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
		Rectangle other = (Rectangle) obj;
		return Double.doubleToLongBits(side_a) == Double.doubleToLongBits(other.side_a)
				&& Double.doubleToLongBits(side_b) == Double.doubleToLongBits(other.side_b);
	}

	@Override
	public String toString() {
		return "Rectangle [side_a=" + side_a + ", side_b=" + side_b  + ", color=" + color + ", area=" + area() + "]";
	}

}
