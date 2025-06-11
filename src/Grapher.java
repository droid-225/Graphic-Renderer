public class Grapher {
	public void showGraph() {
		int x = 9;
		
		for(int i = 0; i < 11; i++) {
			if(x != -1)
				System.out.print(x-- + " ");
			else
				System.out.print("  ");

			for(int j = 0; j < 10; j++) {
				if(i == 10)
					System.out.print(j + " ");
				else
					System.out.print("* ");
			}

			System.out.println();
		}
	}
}