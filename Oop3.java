/**
* ________ OOP lesson 3 ________
* - Interaction of objects.  on #one #two #tree
*  
*  
*
*@author Rechkunov Roman
*@version 29.05
*
*/

class Oop3 {
	
	public static void main(String[] args) {
		
		Cat [] kitty = { new Cat("Vaska",30),new Cat("Tolik",40),new Cat("Barsik",35),new Cat("Pushok",15)};
		Plate plate = new Plate(100);
		plate.info();
		for (Cat cat: kitty){								
			cat.eat(plate);									// #One
			plate.info();
			cat.info();
		}	
		plate.fillPlate();
		plate.info();
	}	
}

class Cat{
	private String nickname;
	private int appetite;
	private boolean full;

	Cat(String nickname,int appetite){
		this.nickname = nickname;
		this.appetite = appetite;
		this.full = false;
	}

	public void eat(Plate p){								// #Two
		full = p.decreaseFood(appetite);
	}

	public boolean isFull(){
		return full;
	}
	public void info(){
		System.out.printf("Cat %s is ",nickname);
		System.out.println((isFull())?"full":"hungry");
	}
}

class Plate {
	private int food;

	Plate(int food){
		this.food = food;
	}

	public void info(){
		System.out.printf("Plate: %s\n",food);
	}

	public boolean decreaseFood(int n){						// #Three
		if (food>n) {
			food -= n;
			return true;
		} else return false;	
	} 
	public void fillPlate(){
		System.out.println("Put some feed in the plate");	
		food = 100;
	}
}