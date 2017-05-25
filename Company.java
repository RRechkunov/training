class Company {
	
	public static void main(String[] args) {
		Worker person1 = new Worker();
		person1.showWorker();

		Worker[] itdepartment = new Worker[5];
		itdepartment[0] = new Worker("Kozlov Ivan Vladimirovitch", 35,"Anykey ingineer",37000,"235-102");
		itdepartment[1] = new Worker("Slonov Gennadiy Petrovich", 46,"Programmer",53500,"235-104");
		itdepartment[2] = new Worker("Kukuruzina Svetlana Petrovna", 27,"WEB designer",42000,"235-106");
		itdepartment[3] = new Worker("Borodin Pavel Andreevich", 54,"Administrator",48000,"235-109");
		itdepartment[4] = new Worker("Slepov Nikolay Ivanovich", 45,"Dirrector",67000,"235-100");
		for (int i=0;i<5;i++) {
			if (itdepartment[i].getAge() > 40) itdepartment[i].showWorker();
		}
	}
}

class Worker {
	private String fio, position, email, tel;
	private int salary, age;
	private final String CNAME = "Coca-Cola";
	
	Worker(){
		this.fio = "Ivanov Ivan";
		this.age = 30;
		this.position = "Manager";
		this.salary = 45000;
		this.email = makeEmail(this.fio); 
		this.tel = "235-045";
	}

	Worker(String fio, int age, String position, int salary,String tel){
		this.fio = fio;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.email = makeEmail(fio); 
		this.tel = tel;
	}

	void showWorker(){
		System.out.printf("_______Worker file________\nName:\t\t%s\nAge:\t\t%d\nPosition:\t%s\nSalary:\t\t%d\nE-mail:\t\t%s\nTel:\t\t%s\n",this.fio,this.age,this.position,this.salary,this.email,this.tel);
	}

	String makeEmail(String fio){
		return fio.charAt(fio.indexOf(" ")+1) + fio.substring(0,fio.indexOf(" "))+"@"+CNAME+".com";
	}

	int getAge(){
		return this.age;
	}
}