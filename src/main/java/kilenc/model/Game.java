package kilenc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Games")

public abstract class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private double price;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "type")
	private String type = "";
	
	
	
	public Game(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	public Game(String name, int age, double price) {
		this(name, age);
		setPrice(price);
	}
	
	public Game() {
		this("", 0);
	}
	
	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	private void setAge(int age) {
		this.age = age;
	}
	
	
	public  void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}

	public String getType() {
		return type;
	}
}
