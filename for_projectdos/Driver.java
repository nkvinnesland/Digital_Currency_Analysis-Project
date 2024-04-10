package for_projectdos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner cryptoscan = new Scanner(System.in);
		System.out.println("Please select one of the following crypto to analyize (BTC is default selection): ");
		System.out.println("1. Bitcoin (BTC)");
		System.out.println("2. Dogecoin (DOGE)");
		System.out.println("3. Ethereum (ETH)");
		System.out.println("4. Chainlink (LINK)");
		System.out.println("5. Litecoin (LTC)");
		
        CryptoType selectedCrypto = CryptoType.BTC;
        boolean validChoice = false;

        while (!validChoice) {
            System.out.println("Enter your choice (1-5):");
            if (cryptoscan.hasNextInt()) {
                int selection = cryptoscan.nextInt();
                switch (selection) {
                    case 1:
                        selectedCrypto = CryptoType.BTC;
                        validChoice = true;
                        break;
                    case 2:
                        selectedCrypto = CryptoType.DOGE;
                        validChoice = true;
                        break;
                    case 3:
                        selectedCrypto = CryptoType.ETH;
                        validChoice = true;
                        break;
                    case 4:
                        selectedCrypto = CryptoType.LINK;
                        validChoice = true;
                        break;
                    case 5:
                        selectedCrypto = CryptoType.LTC;
                        validChoice = true;
                        break;
                    default:
                        System.out.println("Please select a valid choice.");
                        break;
                }
            } else {
                System.out.println("Please enter a number for your selection.");
                cryptoscan.next();
            }
        }
        
        System.out.println("Selected Crypto for Analysis: " + selectedCrypto);
		
        String filename = selectedCrypto.getFileName();
        File file = new File(filename);
		Scanner scan = new Scanner(file);
		
		scan.useDelimiter(", ");
		ArrayList<Crypto> BTC = new ArrayList<>();
		
		if (scan.hasNextLine()) {
			scan.nextLine(); // skip the header
		}
		
		while (scan.hasNext()) {
			String line = scan.nextLine();
			String[] values = line.split(",");
			double open = Double.parseDouble(values[0]);
			double high = Double.parseDouble(values[1]);
			double low = Double.parseDouble(values[2]);
			double close = Double.parseDouble(values[3]);
			double adjClose = Double.parseDouble(values[4]);
			double volume = Double.parseDouble(values[5]);
			if (low != 0 && high != 0 && close != 0 && open != 0) {
				Crypto bitcoin = new Crypto(open, high, low, close, adjClose, volume);
				BTC.add(bitcoin);
			}
		}
		MovementResult analysis = Movement.calculateMovement(BTC);
		System.out.println(analysis);
		
		double percentOpenUp = 0.0;
		double percentOpenDown = 0.0;
		double percentCloseUp = 0.0;
		double percentCloseDown = 0.0;
		double percentLowUp = 0.0;
		double percentLowDown = 0.0;
		
		int openUp = analysis.getPositiveMovementOpen();
		int openDown = analysis.getNegativeMovementOpen();
		int closeUp = analysis.getPositiveMovementClose();
		int closeDown = analysis.getNegativeMovementClose();
		int lowUp = analysis.getPositiveMovementLow();
		int lowDown = analysis.getNegativeMovementLow();
		
		int openUpDown = openUp + openDown;
		int closeUpDown = closeUp + closeDown;
		int lowUpDown = lowUp + lowDown;
		
		percentOpenUp = ((double)analysis.getPositiveMovementOpen() / openUpDown) * 100;
		percentOpenDown = ((double)analysis.getNegativeMovementOpen() / openUpDown) * 100;
		percentCloseUp = ((double)analysis.getPositiveMovementClose() / closeUpDown) * 100;
		percentCloseDown = ((double)analysis.getNegativeMovementClose() / closeUpDown) * 100;
		percentLowUp = ((double)analysis.getPositiveMovementLow() / lowUpDown) * 100;
		percentLowDown = ((double)analysis.getNegativeMovementLow() / lowUpDown) * 100;
		
		System.out.println("Bee Boop Bee Bop Boop. Computing... Computing...");
		System.out.println("....zzzz.....");
		System.out.println("*whack* OW! wha-? Oh right... boopity beep... your results are in...");
		System.out.println("Your still broke! HAH! Gotchya! Just kidding. That's for waking me up.");
		System.out.println("Anyway... Here are your actual results for bitcoin.");
		System.out.println("Hmm.. that's weird.. it just says you missed your chance to buy in 12 years ago because you were too busy making fun of everyone for buying fake money.");
		System.out.println("BOOM! Roasted again!");
		System.out.println("Okay quit messing around this is a professional setting.");
		System.out.println();
		System.out.println("Here are your results: ");
		System.out.println();
		System.out.printf("The amount of times that the opening value of %s was higher than that of a previous day AFTER the previous day's high also went up was %d.\n", selectedCrypto, openUp);
		System.out.printf("The amount of times that the opening value of %s was lower than that of a previous day AFTER the previous day's high went up was %d.\n", selectedCrypto, openDown);
		System.out.printf("This means that you could predict tomorrow's upward movement of the opening price and be correct %.2f percent of the time and incorrect %.2f percent of the time.\n", percentOpenUp, percentOpenDown);
		System.out.println();
		System.out.printf("The amount of times that the closing value of %s was higher than that of a previous day AFTER the previous day's high also went up was %d.\n", selectedCrypto, closeUp);
		System.out.printf("The amount of times that the closing value of %s was lower than that of a previous day AFTER the previous day's high went up was %d.\n", selectedCrypto, closeDown);
		System.out.printf("This means that you could predict tomorrow's upward movement of the closing price and be correct %.2f percent of the time and incorrect %.2f percent of the time.\n", percentCloseUp, percentCloseDown);
		System.out.println();
		System.out.printf("The amount of times that the low value of %s was higher than that of a previous day AFTER the previous day's high also went up was %d.\n", selectedCrypto, lowUp);
		System.out.printf("The amount of times that the low value of %s was lower than that of a previous day AFTER the previous day's high went up was %d.\n", selectedCrypto, lowDown);
		System.out.printf("This means that you could predict tomorrow's upward movement of the closing price and be correct %.2f percent of the time and incorrect %.2f percent of the time.\n", percentLowUp, percentLowDown);
		System.out.println();
		System.out.println("_______________________________OF IMPORTANCE_____________PLEASE READ_________________BEFORE INVESTING_____________ANY MONEYY________________________________");
		System.out.println();
		System.out.println("While some of these percentages may seem high and statistically like a strong incentive to invest, users should keep in mind that while the price may have a high chance of moving up, there is no way to calculate by how much or how little without using professional investment tools.");
		
	}

}
