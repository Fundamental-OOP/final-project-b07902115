package entities;

public class Attribute {
    protected int currentVal;
    protected int maxVal;

    public Attribute(int maxVal) {
        this.maxVal = maxVal;
        this.currentVal = maxVal;
    }

    public Attribute(int maxVal, int initialVal) {
        this.maxVal = maxVal;
        this.currentVal = initialVal;
    }

    public void modVal(int delta) {
        this.setVal(this.currentVal + delta);
    }

    public void setVal(int value) {
        this.currentVal = value > maxVal ? maxVal : value;
    }

    public int getVal() {
        return this.currentVal;
    }

    public int getMax() {
        return this.maxVal;
    }
	
	public double getPercentage() {
		return (double)this.currentVal / this.maxVal;
	}

    public void reset() {
        this.currentVal = this.maxVal;
    }
}