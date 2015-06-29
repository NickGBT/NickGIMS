import java.util.Random;
public class RandomStock {
	
	private String product;
	
	int stockLevelDecrement;
	
	String getProduct() {
		return product;
	}
		
	public static final void main(String... aArgs) {
		log("Generating random integer between 1 and 10");
		
		int START = 1;
		
		int END = 10;
		Random random = new Random();
		for (int idx = 1; idx <= 1; ++idx){
			getRandomInteger(START, END, random);
		}
		
		log("Done.");
	}
	
	private static void getRandomInteger(int aStart, int aEnd, Random aRandom){
		if (aStart > aEnd){
			throw new IllegalArgumentException("Start number cannot exceed end.");
		}
		//get the range of the generator, cast to long to avoid overflows
		long range = (long) aEnd - (long) aStart + 1;
		// calculate a fraction of the range, 0 <- frac < range
		long fraction = (long) (range * aRandom.nextDouble());
		int stockLevelDecrement = (int)(fraction + aStart);
		log("Generated : " + stockLevelDecrement);
	}
	
	private static void log(String aMessage) {
		System.out.println (aMessage);
	}
	//random stock generation, set stock level using random decrements to a current stock value returned from products, send to gui for stock drop simulation
	
}
