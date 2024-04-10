package for_projectdos;

public enum CryptoType {
	BTC("BTC-USD.csv"),
	DOGE("DOGE-USD.csv"),
	ETH("ETH-USD.csv"),
	LINK("LINK-USD.csv"),
	LTC("LTC-USD.csv");
	
	private final String filename;
	
	CryptoType(String filename) {
		this.filename = filename;
	}
	
	public String getFileName() {
		return filename;
	}
}
