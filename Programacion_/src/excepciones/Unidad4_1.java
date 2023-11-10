package excepciones;

class DivisionInexactaException extends Exception {
	int n;
	int d;

	DivisionInexactaException(int i, int j) {
		n = i;
		d = j;
	}

	String mensaje() {
		return "El resultado de dividir " + n + " entre " + d + " no es un exacto";
	}
}

class RacionalExacto {
	int numerador;
	int denominador;

	RacionalExacto(int numerador, int denominador) throws DivisionInexactaException {
		if (numerador % denominador != 0)
			throw new DivisionInexactaException(numerador, denominador);
		this.numerador = numerador;
		this.denominador = denominador;
	}
}

class Unidad4_1 {
	public static void main(String[] args) {
		int numerador = 10;
		int denominador = 3;
		RacionalExacto r1 = null;
		RacionalExacto r2 = null;
		
		try {
			r1 = new RacionalExacto(10, 2);
			System.out.println("NUMERO RACIONAL EXACTO O.K.");
			r2 = new RacionalExacto(10, 3);
			System.out.println("NUMERO RACIONAL EXACTO O.K.");
		} catch (DivisionInexactaException exc) {
			// aquí instrucciones con r si el Racional NO es exacto
			System.out.println(exc.mensaje());
		}
		System.out.println("r1: " + r1);
		System.out.println("r2: " + r2);
	}
}
