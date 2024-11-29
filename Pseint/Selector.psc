Algoritmo Selector
	Escribir "¿Tiene valores? 1(Sí) 0(No)"
	Leer r1
	Si r1=1 Entonces
		Comp<-2
	FinSi
	Escribir "¿Tiene buen sentido del humor? 1(Sí) 0(No)"
	Leer r2
	Si r2=1 Entonces
		Comp<-Comp+1
	FinSi
	Escribir "¿Es responsable? 1(Sí) 0(No)"
	Leer r3
	Si r3=1 Entonces
		Comp<-Comp+2
	FinSi
	Escribir "¿Es atractivo/a  1(Sí) 0(No)"
	Leer r4
	Si r4=1 Entonces
		Comp<-Comp+2
	FinSi
	Escribir "¿Juega al LoL?"
	Leer r5
	Si r5=1 Entonces
		Comp<-Comp-1000
	FinSi
	Si Comp>=4 Entonces
		Escribir "Buenos gustos. Adelante"
	Sino 
		Escribir "Ahí no es herman@"
	FinSi
FinAlgoritmo
