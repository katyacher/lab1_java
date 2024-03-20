package lab1;
import java.util.ArrayList;
import java.util.Scanner;
/** 
 * 
 * */
 


public class Main {
	private static final int MIN_INT = 0;
    private static final int MAX_INT = 6;
    
    protected static final int MIN_D = 0;
	protected static final int MAX_D = 100;
    
    public static ArrayList<Shape> shapes = new ArrayList<>();// коллекия фигур
    public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		String s= "";
		int answer = 0;

        while( !"5".equals(s)){
        	System.out.println("");
            System.out.println("Выберете действие:");
            System.out.println("1. Добавить новый элемент "); //(Элементы должны добавляться в коллекцию элементов типа базового класса. Необходимо предусмотреть возможность добавления любого объекта производного класса в данную коллекцию).
            System.out.println("2. Удалить элемент по индексу");
            System.out.println("3. Вывод всех элементов в консоль");
            System.out.println("4. Сравнение двух элементов на равенство (по индексам)");
            System.out.println("5. Завершение работы приложения.");
            
            s = scanner.next(); 
            
            try {
            	answer = Integer.parseInt(s);
            	
            	if(answer > MIN_INT && answer < MAX_INT){
                    switch (answer) {
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            show();
                            break;
                        case 4:
                            compare();
                            break;
                        case 5:
                        	System.out.println("Exit");
                            scanner.close();
                            return;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Некорректный диапазон, попробуйте снова!");
                    answer = 0; // устанавливаем answer в 0 для повторного ввода
                }
            	
            }catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число от 1 до 5.");
            };
            
        }
	}
       

	
	public static void add() {
		System.out.println("Выберете тип добавляемой фигуры (Triangle, Rectangle, Square)");
		scanner.skip(".*\n");
		String ans = scanner.nextLine();
		
		String s = "";		
		if(ans.equals("Triangle")) {
			System.out.println("Введите значения сторон треугольника:");
			
			try{
				System.out.println("a = ");
				s = scanner.next(); 
				double a = Double.parseDouble(s);
				
				System.out.println("b = ");
				s = scanner.next(); 
				double b = Double.parseDouble(s);
				
				System.out.println("c = ");
				s = scanner.next(); 
				double c = Double.parseDouble(s);
				
				if (a < MIN_D || a > MAX_D) {
					System.out.println("Длина стороны 'a' треугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				if (b < MIN_D || b > MAX_D) {
					System.out.println("Длина стороны 'b' треугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				if (c < MIN_D || c > MAX_D) {
					System.out.println("Длина стороны 'c' треугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				
				Shape triangle = new Triangle(a, b, c);
				shapes.add(triangle);
				
			}catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число.");
            };
			
		} else if(ans.equals("Rectangle")) {
			System.out.println("Введите значения сторон прямоугольника:");
			
			try{
				System.out.println("a = ");
				s = scanner.next(); 
				double a = Double.parseDouble(s);
				
				System.out.println("b = ");
				s = scanner.next(); 
				double b = Double.parseDouble(s);
				
				if (a < MIN_D || a > MAX_D) {
					System.out.println("Длина стороны 'a' прямоугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				if (b < MIN_D || b > MAX_D) {
					System.out.println("Длина стороны 'b' прямоугольника доолжна быть положительным числом от 0 о 99");
					return;
				}
				
				Shape rectangle = new Rectangle(a, b);
				shapes.add(rectangle);
				
			}catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число.");
            };
			
		} else if(ans.equals("Square")) {
			System.out.println("Введите значения стороны квадрата:");
			
			try{
				System.out.println("a = ");
				s = scanner.next(); 
				double a = Double.parseDouble(s);
				
				if (a < MIN_D || a > MAX_D) {
					System.out.println("Сторона квадрата доолжна быть положительным числом от 0 о 99");
					return;
				}
				
				Shape square = new Square(a);
				shapes.add(square);
				
			}catch ( NumberFormatException e) {
            	System.out.println("Необходимо ввести число.");
            }
			
		}else {
			System.out.println("Неизвестная фигура");
		}
		
		return;
	}
	
	public static void remove() {
		if(shapes.size() == 0) {
			System.out.println("Коллекция пуста");
			return;
		}
		
		System.out.println("Введите индекс удаляемого элемента от 0 до " + (shapes.size()-1) );
		int ans = 0;
		while(true) {
			if(!scanner.hasNextInt()){
	            System.out.println("Некорректные данные, попробуйте снова.");
	            scanner.next(); /* считываем все данные, сбрасывая ввод*/
	        } else {
	        	ans = scanner.nextInt();
	            if(ans >= 0 && ans < shapes.size()){
	            	shapes.remove(ans);
	            	break;
	            } else {
	            	System.out.println("Некорректный диапазон, попробуйте снова.");
	            	ans = 0; // устанавливаем ans в 0 для повторного ввода
	            }
	       }
		}
		
		return;
	}
	
	public static void show() {
		if(shapes.size() == 0) {
			System.out.println("Коллекция пуста");
			return;
		} 
		
		for(int i = 0; i < shapes.size(); ++i ) {
			System.out.println("[" + i + "] " + shapes.get(i).toString());
		}
	}
	
	public static void compare() {
		if(shapes.size() == 0) {
			System.out.println("Коллекция пуста");
			return;
		}
		if(shapes.size() == 1) {
			System.out.println("Недостаточно элементов для сравнения");
			return;
		} 
		
		int index_1, index_2 = 0;
		
		System.out.println("Введите индекс первого элемента от 0 до " + (shapes.size()- 1));
		
		while(true) {
			if(!scanner.hasNextInt()){
	            System.out.println("Некорректные данные, попробуйте снова!");
	            scanner.next(); /* считываем все данные, сбрасывая ввод*/
	        } else {
	        	index_1 = scanner.nextInt();
	            if(index_1 >= 0 && index_1 < shapes.size()){
	            	break;
	            } else {
	            	System.out.println("Некорректный диапазон, попробуйте снова!");
	            	index_1 = 0; // устанавливаем ans в 0 для повторного ввода
	            }
	        }
		}
		
		System.out.println("Введите индекс второго элемента от 0 до " + (shapes.size()- 1));
		
		while(true) {
			if(!scanner.hasNextInt()){
	            System.out.println("Некорректные данные, попробуйте снова!");
	            scanner.next(); /* считываем все данные, сбрасывая ввод*/
	        } else {
	        	index_2 = scanner.nextInt();
	            if(index_2 >= 0 && index_2 < shapes.size()){
	            	break;
	            } else {
	            	System.out.println("Некорректный диапазон, попробуйте снова!");
	            	index_2 = 0; // устанавливаем ans в 0 для повторного ввода
	            }
	        }
		}
		
		boolean result = shapes.get(index_1).equals(shapes.get(index_2));
		
		System.out.println(result);
		return;
	}
}




