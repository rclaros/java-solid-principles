package p4.isp.violation;

public class EpsonMachine implements IMachine {

	public void print() {
		System.out.println("Printing");
	}

	public void scan() {
		System.out.println("Scan");
	}

	public void photoCopy() {
		System.out.println("Photo Copy");
	}
}