package p3.lsp.violation2ocp;

public class Square extends Shape {
	private int sideLength;

	public Square() {
	}

	public Square(int sideLength) {
		this.sideLength = sideLength;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public int area() {
		return sideLength * sideLength;
	}
}