package for_projectdos;

public class Crypto {
	
    double open;
    double high;
    double low;
    double close;
    double adjClose;
    double volume;
	
	public Crypto(double open, double high, double low, double close, double adjClose, double volume) {
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.adjClose = adjClose;
		this.volume = volume;
	}
		
	public double getOpen() { 
		return open; 
	}
	
	public double getHigh() { 
		return high; 
	}
	
	public double getLow() { 
		return low;
	}
	
	public double getClose() { 
		return close; 
	}
	public double getAdjClose() {
		return adjClose; 
	}
	public double getVolume() { 
		return volume; 
	}
	
	public String toString() {
		return "Change in open: " + open + ". Change in high: " + high + ". Change in low: " + low + ". Change in close: " + close + ". Change in adjust close: " + adjClose + ". Change in volume: " + volume + ".";
	}
}