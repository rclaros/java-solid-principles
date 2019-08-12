package p3.lsp2.violation;

public class Bird {
	public void fly() { 
		System.out.println("fly: " + this.getClass().getSimpleName());
	}
	
	public void eat() { 
		System.out.println("eat");
	}
}
