package game.entities.identities;

public class MessageConstants {

	public static final String whitePlayer = "White";
	public static final String blackPlayer = "Black";
	private static final String inCheck = " is in check!";
	private static final String inCheckmate = " is in checkmate!";
	private static final String winLine = " wins!";
	public static final String whiteCheck = whitePlayer + inCheck;
	public static final String blackCheck = blackPlayer + inCheck;
	public static final String whiteWins = blackPlayer + inCheckmate + " " + whitePlayer + winLine;
	public static final String blackWins = whitePlayer + inCheckmate + " " + blackPlayer + winLine;
	
}
