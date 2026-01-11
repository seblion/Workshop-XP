FASES XP – Extreme Programming (formato texto)

Extreme Programming

I. Planificación

Historias de Usuario

Plan de Entregas

Velocidad de Proyecto

Iteraciones

Rotaciones

Reuniones

II. Diseño

Metáfora del Sistema

Tarjetas CRC

Soluciones Puntuales

Funcionalidad mínima

Reciclaje

III. Desarrollo

Disponibilidad del cliente

Unidad de Pruebas

Programación por parejas

Integración

IV. Pruebas

Implantación

Pruebas de Aceptación

FASES XP – Extreme Programming (formato texto)

Extreme Programming

I. Planificación

Historias de Usuario

Plan de Entregas

Velocidad de Proyecto

Iteraciones

Rotaciones

Reuniones

II. Diseño

Metáfora del Sistema

Tarjetas CRC

Soluciones Puntuales

Funcionalidad mínima

Reciclaje

III. Desarrollo

Disponibilidad del cliente

Unidad de Pruebas

Programación por parejas

Integración

IV. Pruebas

Implantación

Pruebas de Aceptación

REQUERIMIENTOS: 
La KGD en Rusia financia el proyecto ANTDRON2K25 para ganar la guerra a Ucrania. El proyecto está inspirado en las hormigas 
guerreras rusas que usaran exoesqueleto (AntCiberDron) para que dominen la tierra y aire.  
Por otro lado; la OTAN han proporcionado arsenal bélico de última generación a UCRANIA y generan la siguiente estrategia de 
guerra definiendo coordenadas, horarios y tipo de arsenal: 
La KGD ha hackeado y desencriptado el archivo ucraniano con el detalle de la coordenadas, horarios y tipo de arsenal y solita la 
creación de un AntCiberDron que integre una bomba basada en autómatas BBA. 
• Crear un archivo “Grupo##.csv” con el detalle de la coordenadas, horarios y tipo de arsenal para el ataque a Rusia. Este archivo de 
texto debe contener las coordenadas que correspondan a los número de cédula del equipo. La última columna contendrá ejemplos de 
palabras (w) que correspondan lenguaje (autómata) de cada coordenada.  
Ejemplo del archivo apellidoNombre.csv para el número de cedula es 11036359: 
Geoposición ; Lunes      
Coord-01;   
; Martes    ; Miércoles     ; Jueves       
01-02 ;       
Coord-01;   
Coord-00;         
Coord-03;         
Coord-06;         
Coord-03;         
Coord-05;         
Coord-09;   
01-02 ;       
;       
;       
;       
;       
;          
;          
;          
; 03-06    
;          
;        
;        
;        
;        
; Viernes     ; Tipo Arsenal 
;        ; aaaa 
;        ; a 
;        ; aa 
;        
; abc 
; 04-08  ;        ; abcdttttt 
; 03-06    
;       
01-02 ;       
;          
;          
;        
;        
;        
;        
; abc 
; 05-10  ; abcdttt 
;        ; ab  
• Al iniciar el sistema debe solicitar autenticación (usuario y contraseña) para todos los integrantes del grupo y profesor (“patmic”,”123”) 
con máximo 3 intentos, se debe presentar el Equipo y alumnos (cedula, nombre); luego, leer y presentar los datos del archivo 
“Grupo##.csv”. Al procesar el archivo por cada línea/coordenada leída primero se debe presentar un loading de carga que usando:  
\l/-l 100% 
[+] TEAM [1]: Transformers 
• Alumno 1:    11036359 | Pepito Alimaña 
• Alumno 2:    11036353 | Juana Galarza 
• … 
[+] COORDENADAS UCRANIANAS: 
Loading  | Geoposición | Lunes      | Martes  | Miércoles    | Jueves      | Viernes    | Tipo Arsenal 
100%     Coord-01|   
100%     Coord-01|   
100%     Coord-00|         
100%     Coord-03|         
100%     Coord-06|         
100%     Coord-03|         
100%     Coord-05|         
/ 10% 
... 
01-02 |       
01-02 |       
|       
|          
|          
|          
|       
|       
|       
|       
| 03-06    
|          
| 03-06    
|          
|        
|        
|        
|        
|        
|        
|        
|        
| 04-08  |        
|        
|        
|        
| aaaa 
| a 
| aa 
| abc 
| abcdttttt 
| abc 
| 05-10  | abcdttt 
• La KGD requiere crear una bomba “BBA” que debe ser integrada a su tipo de hormiga para garantizar destruir exclusivamente el tipo 
de arsenal bélico definido en el autómata. Su Autómata debe ser Finito Determinista con su grafo y detallar: 
Code is life, life is code   
METODOLOGÍAS AGILES  
FACULTA DE INGENIERÍA EN INFORMATICA 
ESCUELA POLITÉCNICA NACIONAL 
Para construir el autómata debe tomar el último dígitos de su cédula integrante del equipo, por ejemplo: 1103635 1503639; entonces, el tipo 
de arsenal a destruir son las coordenadas 5 y 9, por lo tanto debe diseñar el autómata que reconozca L = { abcdt+ , ab* } 
• La KGD requiere crear un TIPO_HORMIGA que derive de “Hormiga”. Su TIPO_HORMIGA nace como HLarva que comen néctar para 
vivir pero si comen ALIMENTO se transforman en su TIPO_HORMIGA. Su TIPO_HORMIGA vive si come su ALIMENTO. 
TIPO_HORMIGA   
HLarva   
HSoldado   
HZángano  
HRastreadora  
ALIMENTO (VIVE)  
Néctar   
Carnívoro   
Omnívoro   
Herbívoro   
GRUPO 
todos   
1, 2 
3, 4 
5 
• AntCiberDron implementa de la inteligencia artificial que tiene una interfaz para buscar el Tipo de arsenal y valora si la bomba debe 
explotar según el autómata regresando True o False. La acción de buscar debe presentar la coordenada donde la bomba “BBA” explota.  
. . . 
COORDENADAS UCRANIANAS A DESTRUIR: 
Geoposición |   Tipo Arsenal      |   Acción   
Coord-05  |  abcdttt       
true 
Coord-09  |  ab            
true 
• AntCiberDron se compone de las mismas extremidades de la hormiga, la pata delantera derecha puede cargar una metralleta y el 
izquierdo un láser cuya potencia varía según la energía de la fuente de poder. 
• AntCiberDron tiene un turbo reactor en la parte de la espalda que le permiten volar usando energía de la fuente de poder. La fuente 
de poder es recargable y reemplazable bajo la asistencia del IIA. 
• AntCiberDron tiene capacidad para aprender inglés y español y requiere de expertos parlantes de inglés y español quienes son los 
únicos que deben entrenar el léxico, gramática y fonética. 
• Crear pantallas para que usuarios de la KGD puedan tener su hormiguero virtual y crear sus hormigas  
NOTA: Si su solución tiene algún tipo issues/errors/crash  o No cumple con las instrucciones del presente: -0.5 puntos por incidente 
CUESTIONARIO:  
Se requiere seguir la metodología XP. Adicionalmente se debe disponer de los siguiente artefactos de forma obligatoria: Diseño tangible 
funcional acorde al diagrama de clases, caso de uso, grafo y gramática del autómata, modelo entidad relación, diagrama de la arquitectura.


Geoposición ; Lunes ; Martes ; Miércoles ; Jueves ; Viernes ; Tipo Arsenal

Coord-01 ; 01-02 ; ; ; ; ; a+
Coord-02 ; ; 02-04 ; ; ; ; ab+
Coord-03 ; ; ; 03-06 ; ; ; abc
Coord-04 ; ; ; ; 04-08 ; ; abcd+
Coord-05 ; ; ; ; ; 05-10 ; abcdt+
Coord-06 ; ; ; ; 04-08 ; ; abcd+
Coord-07 ; ; ; 03-06 ; ; ; abcd+
Coord-08 ; ; 02-04 ; ; ; ; abc
Coord-09 ; 01-02 ; ; ; ; ; ab+
Coord-00 ; ; ; ; ; ; a+

Código – Arsenal Bélico

a → Avión
b → Barco
c → Convoy
d → Dron
t → Tanque

COACH - sebas
DEVELOPER - Angel, Alexis
TRACKER - sebas
TESTER -  evelin
