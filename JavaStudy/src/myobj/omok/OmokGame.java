package myobj.omok;

public class OmokGame {

	public static void main(String[] args) {
		Omok omok = new Omok();
		
//		omok.putBlack(3, 7);
//		omok.putBlack(4, 7);
//		omok.putBlack(5, 7);
//		omok.putBlack(6, 7);
//		omok.putBlack(7, 7);
		
//		omok.putBlack(7, 3);
//		omok.putBlack(7, 4);
//		omok.putBlack(7, 5);
//		omok.putBlack(7, 6);
//		omok.putBlack(7, 7);
		
		omok.putBlack(3, 3);
		omok.putBlack(4, 4);
		omok.putBlack(5, 5);
		omok.putBlack(6, 6);
		omok.putBlack(7, 7);
		
		System.out.println(omok.postCheck(7, 7, Omok.BLACK_STONE));
		
		omok.printBoard();
	}
}
