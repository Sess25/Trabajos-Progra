Algoritmo Num_azar
	int <- 10
	nsec <- azar(100)+1
	Escribir 'Adivine el numero secreto (entre 1 y 100) en 10 intentos o menos'
	Leer ning
	Mientras int>=1 Y nsec<>ning Hacer
		Si nsec>ning Entonces
			Escribir 'Muy bajo, pruebe otro numero'
		SiNo
			Escribir 'Muy alto, pruebe otro numero'
		FinSi
		Escribir 'Le quedan ' int " intentos"
		int <- int-1
		Leer ning
	FinMientras
	Si int<1 Entonces
		Escribir 'Fin del juego. El numero secreto era ', nsec
	FinSi
	Si nsec=ning Entonces
		Escribir 'Muy bien! Logró adivinar en ', 11-int, ' intentos'
	FinSi
FinAlgoritmo
