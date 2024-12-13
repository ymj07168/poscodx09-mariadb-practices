package emaillist;

import java.util.Scanner;

public class EmaillistApp {
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true) {
			System.out.print("(l)ist (d)elete (i)nsert (q)uit > ");
			String command = scanner.nextLine();
			
			if("l".equals(command)) {
				doList();
			} else if("d".equals(command)) {
				doDelete();
			} else if("i".equals(command)) {
				doInsert();
			} else if("q".equals(command)) {
				break;
			}
		}
		
		if(scanner != null) {
			scanner.close();
		}
	}

	private static void doInsert() {
		System.out.println("doInsert");
	}

	private static void doDelete() {
		System.out.println("이메일");
		String email = scanner.nextLine();
		
		new EmaillistDao().deleteByEmail(email);
		
		doList();
	}

	private static void doList() {
		System.out.println("doList");
	}

}
