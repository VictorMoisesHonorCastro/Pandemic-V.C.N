import java.util.Scanner;

public class Pandemic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Victor Moises Honor Castro
		Scanner teclado = new Scanner(System.in);
		
		String frase = "";
		String ciudad = "";
		
		
		System.out.println("Introduce la frase:");
		
		frase = teclado.nextLine();
		
		String[] separar = frase.split(";");
		String[] sepa = separar[2].split(",");
		String[] ciudades = separar[3].split(",");
		
		ciudad = separar[0];

		int[] numeros = new int[3];
		
		numeros[0] = Integer.parseInt(separar[1]);
		numeros[1] = Integer.parseInt(sepa[0]);
		numeros[2] = Integer.parseInt(sepa[1]);
				
		System.out.print("Silco actua en " + ciudad + " con los numeros ");
		
		for (int i = 0; i < numeros.length; i++) {
			
			if (i < 1) {
				System.out.print(numeros[i] + ", ");
			} else {
				System.out.print(numeros[i] + " y ");
			}
			
		}
		
		System.out.print("cuyas ciudades colindantes son ");
		
		for (int i = 0; i < ciudades.length; i++) {
			
			if (i < 2) {
				System.out.print(ciudades[i] + ", ");
			} else if (i == 2) {
				System.out.print(ciudades[i] + " y ");
			} else {
				System.out.print(ciudades[i] + ".");
			}
			
			
			
		}

	}

}
