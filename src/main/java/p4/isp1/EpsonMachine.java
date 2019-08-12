package p4.isp1;

public class EpsonMachine implements IPrinter, IScanner, IPhotoCopier {

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