package lab.ssafy.corona.virus;

//다중 상속(class) 지원 안함
//다중 구현(Interface)은 지원   -> 넓은 의미로 상속으로 보는 사람도 있음. 다중 상속처럼 구현할 수 있다.


//상속, 일반화
// 호랑이, 사자, 동물, 사과나무 => 객체지향(class)
//is a 관계(일반화) , has a 관계
//호랑이는 동물이다, 사자는 동물이다.

//바이러스, 코로나 바이러스
//코로나 바이러스는 바이러스이다. -->일반화(상속)

//has a 관계
//컴퓨터,SSD,Memory,CPU
//컴퓨터는 SSD를 가지고 있다.(포함하고 있다, has a 관계)
//컴퓨터는 MEM를 가지고 있다.(포함하고 있다, has a 관계)
//컴퓨터는 CPU를 가지고 있다.(포함하고 있다, has a 관계)

class SSD {}
class MEM {}
class CPU {}
class 컴퓨터 {           //이런식으로 has a 관계가 있따면 이런식으로 특정 클래스에 멤버 변수화 하면됨.(상속은아님)
	SSD ssd;
	MEM mem;
	CPU cpu;
	
}







public class Corona extends Virus{
	//private String name;
	private int spreadSpeed;

	public int getSpreadSpeed() {
		return spreadSpeed;
	}

	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}
	
	public void showinfo() {
		String info = super.getName() + " "+super.getLevel()+" "+this.spreadSpeed; //name이나 level이 private이면 이렇게 못씀.
		System.out.println(info);
		
	}
	public Corona() {}
	public Corona(String name, int level, int spreadSpeed) {
//		super.setName(name);
//		super.setLevel(level);
		super(name,level);         //Virus에 생성자가 public일때 
		this.spreadSpeed = spreadSpeed;
	}
}
