package Game;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row,column;
		System.out.println("Mayın tarlasına hoşgeldiniz !");
		System.out.println("Lütfen oynamak istediğiniz boyutları giriniz: ");
		System.out.print("Satır ->");
		row = scan.nextInt();
		System.out.print("Sütün->");
		column = scan.nextInt();
		
		MayinTarlasi mayin = new MayinTarlasi(row, column);
		mayin.run();
        scan.close();
	}

}
