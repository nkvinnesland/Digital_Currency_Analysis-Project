package for_projectdos;

public class MovementResult {
    private int positiveMovementOpen;
    private int negativeMovementOpen;
    private int positiveMovementClose;
    private int negativeMovementClose;
    private int positiveMovementLow;
    private int negativeMovementLow;

    public MovementResult(int positiveMovementOpen, int negativeMovementOpen, int positiveMovementClose, int negativeMovementClose, int positiveMovementLow, int negativeMovementLow) {
        this.positiveMovementOpen = positiveMovementOpen;
        this.negativeMovementOpen = negativeMovementOpen;
        this.positiveMovementClose = positiveMovementClose;
        this.negativeMovementClose = negativeMovementClose;
        this.positiveMovementLow = positiveMovementLow;
        this.negativeMovementLow = negativeMovementLow;
        
    }

    // Getters
    public int getPositiveMovementOpen() {
        return positiveMovementOpen;
    }

    public int getNegativeMovementOpen() {
        return negativeMovementOpen;
    }
    
    public int getPositiveMovementClose() {
        return positiveMovementClose;
    }

    public int getNegativeMovementClose() {
        return negativeMovementClose;
    }
    public int getPositiveMovementLow() {
        return positiveMovementLow;
    }

    public int getNegativeMovementLow() {
        return negativeMovementLow;
    }
    
    public String toString() {
    	return "Your data is being analyzed.";
    }
}
