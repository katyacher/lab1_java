package lab1;
import java.util.Objects;



public class Triangle extends Shape {
	
	private double side_a, side_b, side_c; // стороны треугольника
	
	public Triangle() {
		super();
		side_a = 1;
		side_b = 1;
		side_c = 1;
		
		System.out.println("Создан треугольник по-умолчанию");
	}
	
	public Triangle(double a, double b, double c) {
		super();
		
		if (a < MIN_INT || a > MAX_INT) {
			System.out.println("Длина стороны 'a' треугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		if (b < MIN_INT || b > MAX_INT) {
			System.out.println("Длина стороны 'b' треугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		if (c < MIN_INT || c > MAX_INT) {
			System.out.println("Длина стороны 'c' треугольника доолжна быть положительным числом от 0 о 99");
			return;
		}
		
		side_a = a;
		side_b = b;
		side_c = c;
		
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

	public double getSide_c() {
		return side_c;
	}

	public void setSide_c(double side_c) {
		this.side_c = side_c;
	}

	@Override
	public double area() {
		/* Площадь треугольника по трем сторонам (формула Герона).*/
		
		double p = (side_a + side_b + side_c)/2; // p = (a + b + c) : 2 – полупериметр 
		
		return Math.sqrt(p * (p - side_a) * (p - side_b) * (p - side_c)); // S=√(p⋅(p−a)⋅(p−b)⋅(p−c))
	}
	
	@Override
	public int hashCode() {
		final int prime = 31; // простое число
		int result = super.hashCode();
		result = prime * result + Objects.hash(side_a, side_b, side_c);
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
		Triangle other = (Triangle) obj;
		return Double.doubleToLongBits(side_a) == Double.doubleToLongBits(other.side_a)
				&& Double.doubleToLongBits(side_b) == Double.doubleToLongBits(other.side_b)
				&& Double.doubleToLongBits(side_c) == Double.doubleToLongBits(other.side_c);
	}

	@Override
	public String toString() {
		return "Triangle [side_a=" + side_a + ", side_b=" + side_b + ", side_c=" + side_c +  ", color=" + color + ", area="  + area() + "]";
	}

}
