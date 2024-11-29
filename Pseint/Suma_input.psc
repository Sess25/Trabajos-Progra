Algoritmo Suma_input
	Escribir "Dame un número menor a 100"
	Leer N
	N1<-N
	Suma<-1
	Cont<-1
	Si N>=100 Entonces
		Escribir "Introduce un número válido"
	Sino 
		Mientras Cont<=N1 Hacer
			Escribir N+Suma
			N<-N+Suma
			Suma<-Suma+1
			Cont<-Cont+1
		FinMientras
	FinSi
FinAlgoritmo
