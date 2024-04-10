package for_projectdos;

import java.util.ArrayList;

public class Movement {
	
	public static MovementResult calculateMovement(ArrayList<Crypto> BTC) {
		int positiveMovementOpen = 0;
		int negativeMovementOpen = 0;
		int positiveMovementClose = 0;
		int negativeMovementClose = 0;
		int positiveMovementLow = 0;
		int negativeMovementLow = 0;
		
		for (int i = 1; i < BTC.size(); i++) {
			Crypto currentDay = BTC.get(i);
			Crypto previousDay = BTC.get(i-1);
			
			if (currentDay.getOpen() > 0 && previousDay.getHigh() > 0) {
				positiveMovementOpen++;
			} else if (currentDay.getOpen() < 0 && previousDay.getHigh() > 0) {
				negativeMovementOpen++;
			}
			
			if (currentDay.getClose() > 0 && previousDay.getHigh() > 0) {
				positiveMovementClose++;
			} else if (currentDay.getClose() < 0 && previousDay.getHigh() > 0) {
				negativeMovementClose++;
			}
			
			if (currentDay.getLow() > 0 && previousDay.getHigh() > 0) {
				positiveMovementLow++;
			} else if (currentDay.getLow() < 0 && previousDay.getHigh() > 0) {
				negativeMovementLow++;
			}
		}
		
		return new MovementResult(positiveMovementOpen, negativeMovementOpen, positiveMovementClose, negativeMovementClose, positiveMovementLow, negativeMovementLow);
	}
}