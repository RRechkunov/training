/**
* ________ Inheritance and Polymorphism________
* - Methods override 
* - Abstract classes and methods
* - final usage
* #extends #super #@override #abstract #final
*
*@author Rechkunov Roman
*@version 29.05
*
*/

class Oop2 {
	public static void main(String[] args) {

	Animal kitty = new Cat(320,3,500);	
	Animal puppy = new Dog(110,1,20);
	kitty.show();
	puppy.show();
	kitty.run(230);
	puppy.jump(5);
	kitty.swim(30);
	}

}

abstract class Animal {
	protected int runlimit;
	protected int jumplimit;
	protected int swimlimit;
	Animal(int run, int jump, int swim){
		this.runlimit = run;
		this.jumplimit = jump;
		this.swimlimit = swim;
	}
	Animal(){
		this.runlimit = 0;
		this.jumplimit = 0;
		this.swimlimit = 0;
	}

	void run(int dist){
		if (dist <= this.runlimit) 
			System.out.printf("The %s ran this distance(%d km)\n",this.getClass().getName(), dist);
		else System.out.printf("The %s didn't ran this distance(%dkm)\n",this.getClass().getName(),dist);
	}

	void swim(int dist){
		if (this.swimlimit == 0){	
			System.out.printf("The %s can't swim\n",this.getClass().getName());
			return;
		}
		if (dist <= this.swimlimit) 
			System.out.printf("The %s swam this distance(%dkm)\n",this.getClass().getName(),dist);
		else System.out.printf("The %s didn't swam this distance(%dkm)\n",this.getClass().getName(),dist);

	}

	void jump(int height){
		if (this.jumplimit == 0){	
			System.out.printf("The %s can't jump\n",this.getClass().getName());
			return;
		}
		if (height <= this.jumplimit) 
			System.out.printf("The %s jump over the barrier(%dm)\n",this.getClass().getName(),height);
		else System.out.printf("The %s didn't jump over the barrier(%dm)\n",this.getClass().getName(),height);
	}
	void show(){
		System.out.printf("_______* %s *_______\n",this.getClass().getName());
		System.out.printf("Run distance limit:\t%d\n",this.runlimit);
		System.out.printf("Swim distance limit:\t%d\n",this.swimlimit);
		System.out.printf("Jump heigth limit:\t%d\n",this.jumplimit);
		System.out.println("_________________________");
	}
	
}

class Cat extends Animal{
	Cat(int run, int jump, int swim){		
		super(run,jump,swim);
	}
	@Override
	void swim(int dist){
		System.out.printf("The %s can't swim\n",this.getClass().getName());		
	}
}

class Dog extends Animal{

	Dog(int run, int jump, int swim){		
		super(run,jump,swim);
	}



}