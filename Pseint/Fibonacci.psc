Algoritmo Fibonacci
	Escribir "Ingresa la cantidad de números que deseas conocer"
	Leer N
	i<-0
	a<-0
	b<-1
	c<-0
	Mientras i<N Hacer
		Escribir a
		c<-a+b
		a<-b
		b<-c
		i<-i+1
	FinMientras
FinAlgoritmo
