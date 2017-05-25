/**
* ________ Inheritance and Polymorphism________
* - Methods override 
* - Abstract classes and methods
* - final usage
* #extends #super #@override #abstract #final
*
*@author Rechkunov Roman
*@version 24.05
*
*/

class Oop2 {
	public static void main(String[] args) {
	Animal elephant = new Animal("Elephant", 7,0,3);
	elephant.show();
	elephant.run(4);
	elephant.swim(6);
	elephant.jump(18);

	Cat kitty = new Cat("Barsik");
	Cat kotik = new Cat("Vaska");	
	kitty.show();
	kotik.show();
	kitty.showNick();
	kitty.run(230);
	kotik.showNick();
	kotik.jump(5);

	Dog dog = new Dog("Pluto");
	dog.say();
	}

}

class Animal {
	protected String name;
	protected int runlimit;
	protected int jumplimit;
	protected int swimlimit;
	protected String speech;
	Animal(String name,int run, int jump, int swim){
		this.name = name;
		this.runlimit = run;
		this.jumplimit = jump;
		this.swimlimit = swim;
	}

	Animal(){
		this.name = "Unknown Animal";
		this.runlimit = 0;
		this.jumplimit = 0;
		this.swimlimit = 0;
	}

	void run(int dist){
		if (dist <= this.runlimit) 
			System.out.printf("The %s ran this distance(%d km)\n",this.name,dist);
		else System.out.printf("The %s didn't ran this distance(%dkm)\n",this.name,dist);
	}

	void swim(int dist){
		if (this.swimlimit == 0){	
			System.out.printf("The %s can't swim\n",this.name);
			return;
		}
		if (dist <= this.swimlimit) 
			System.out.printf("The %s swam this distance(%dkm)\n",this.name,dist);
		else System.out.printf("The %s didn't swam this distance(%dkm)\n",this.name,dist);

	}

	void jump(int height){
		if (this.jumplimit == 0){	
			System.out.printf("The %s can't jump\n",this.name);
			return;
		}
		if (height <= this.jumplimit) 
			System.out.printf("The %s jump over the barrier(%dm)\n",this.name,height);
		else System.out.printf("The %s didn't jump over the barrier(%dm)\n",this.name,height);
	}
	void show(){
		System.out.printf("_______* %s *_______\n",this.name);
		System.out.printf("Run distance limit:\t%d\n",this.runlimit);
		System.out.printf("Swim distance limit:\t%d\n",this.swimlimit);
		System.out.printf("Jump heigth limit:\t%d\n",this.jumplimit);
		System.out.println("_________________________");
	}
	void say(){
		System.out.println(this.speech);
	}
}

class Cat extends Animal{
	private String nickname;

	Cat(){		
		super("Cat",200+(int)(Math.random()*6),2,0);
		this.nickname = "unnamed";
	}
	
	Cat(String nick){
		super("Cat",200+(int)(Math.random()*6)*20,2,0);
		this.nickname = nick;
	}
	@Override
	void show(){
		System.out.printf("_______* %s - %s *_______\n",this.name,this.nickname);
		System.out.printf("Run distance limit:\t%d\n",this.runlimit);
		System.out.printf("Swim distance limit:\t%d\n",this.swimlimit);
		System.out.printf("Jump heigth limit:\t%d\n",this.jumplimit);
		System.out.println("_________________________");
	}
	void showNick(){
		System.out.println(this.nickname);
	}
}

class Dog extends Animal{

	private String nickname;
	Dog(){
		super("Dog",500,3,20);
		this.nickname = "unnamed";
		speech = "woof-woof";
	}

	Dog(String nick){
		super("Dog",500,1,0);
		this.nickname = nick;
		speech = "woof-woof";
	}

}