Texto plano – partes importantes (sin hesitaciones ni repeticiones):

La actividad corresponde a un workshop de Extreme Programming (XP) y forma parte de la nota final del segundo bimestre. El docente volverá a subir el material para que se pueda completar correctamente la actividad.

El problema principal de XP es que no existe un framework cerrado que indique paso a paso cómo aplicarlo. Por eso, el trabajo consiste en construir el framework de XP y, sobre esa base, desarrollar la aplicación que ya fue previamente diseñada.

El objetivo es que cada grupo repplique y personalice el framework según sus necesidades, entendiendo cómo funciona XP en la práctica.

Escenario general del proyecto

Se debe construir un escenario completo que cubra las cuatro fases de XP:

Planificación

Diseño

Desarrollo (coding)

Pruebas (testing)

En cada fase deben existir:

Actividades

Artefactos

Roles

Responsables

Resultados

Un error común es listar solo actividades. En XP siempre deben estar claros:

Qué se hace

Quién lo hace

Qué se entrega como resultado

XP trabaja obligatoriamente en pares, por lo que cada actividad debe ser realizada por dos personas.

Dashboard del proyecto

Se debe construir un dashboard (por ejemplo en HTML, JS, React u otra tecnología) que permita:

Visualizar las fases de XP

Controlar el avance del proyecto

Navegar por actividades, historias de usuario y diseño

Si se usa un framework (React, etc.), el proyecto debe incluir un Docker, de forma que el docente pueda ejecutarlo fácilmente.
Si no se usa framework, puede funcionar directamente desde el navegador.

El dashboard debe reflejar exactamente lo que aparece en las diapositivas, pero automatizado.

Historias de usuario

El sistema debe permitir:

Visualizar todas las historias de usuario

Hacer clic en una historia y ver su detalle

Asignar responsables

Definir fechas

Indicar estado (completada, pendiente, cerrada)

Indicar prioridad o dificultad

Las épicas no son obligatorias en XP, pero pueden usarse para agrupar historias por módulo (por ejemplo: interfaz, lógica, validaciones).

No es obligatorio usar puntos de historia ni métricas avanzadas; eso se verá más adelante en Scrum.

Iteraciones (sprints)

El proyecto debe manejar iteraciones:

Cada iteración ejecuta las cuatro fases de XP

Se puede medir el avance en horas

Se debe mostrar el nivel de cumplimiento por fase

El dashboard debe permitir ver:

En qué fase está el proyecto

Qué actividades están completas

Qué falta por desarrollar

Equipo y roles

El sistema debe mostrar el equipo de trabajo, con roles como:

Product Owner

Developer

Coach

Tester

No es necesario detallar demasiado, pero los roles deben existir y ser coherentes con XP.

Diseño, código y pruebas

En la fase de Design deben mostrarse:

Casos de uso

Diagramas de clases

Diagramas necesarios

Metáfora del sistema

Análisis del proceso

En la fase de Coding:

Código organizado según el diseño

Trazabilidad entre diseño y código

En la fase de Testing:

Pruebas unitarias

Pruebas de integración

Otras pruebas que consideren necesarias

Evidencias (parte más importante)

No basta con entregar el resultado final.

Cada artefacto debe tener evidencia en video:

Videos de máximo 3 minutos

El video debe mostrar cómo se construyó, no explicar el resultado

Debe verse a las personas trabajando (planning, diseño, codificación, pruebas)

Puede trabajarse en pares o en pares con IA

Ejemplos:

Planning → varios videos de 3 minutos

Diseño → varios videos de 3 minutos

Coding → varios videos de 3 minutos

Testing → varios videos de 3 minutos

Los videos deben organizarse en carpetas de evidencias dentro del proyecto.

Evaluación

La evaluación se basará en:

Correcta aplicación de XP

Existencia del framework

Dashboard funcional

Trazabilidad entre fases

Evidencias claras del trabajo realizado

La ficha de evaluación será subida al PIN.
Cualquier duda se resolverá por el grupo de comunicación.

Ese es el alcance completo del workshop de XP.

La IA se utilizará para crear un **dashboard** en HTML donde se organicen las **historias de usuario**. Cada historia tendrá un identificador (por ejemplo, Historia de Usuario 01, 02, etc.) y un nombre. Las historias pueden salir de los requerimientos existentes, ya sea uno por uno, agrupados o por hitos relevantes.

Al hacer clic en una historia de usuario desde el dashboard, se debe mostrar el **detalle de la historia**.

Una historia de usuario debe contener:

* Código o identificador.
* Título o funcionalidad (por ejemplo: *Inicio del sistema*).
* Estructura **“Yo como [rol] quiero [qué] para [para qué]”**.
* **Criterios de aceptación**.

En XP, la historia de usuario tradicionalmente es más simple que en Scrum: una descripción breve y, al reverso, los criterios de aceptación. Sin embargo, se recomienda usar la estructura “Yo como / Quiero / Para qué” porque es más metodológica y evita ambigüedades.

El **“Yo como”** identifica el **rol** que ejecuta la funcionalidad (por ejemplo: cajero, gerente). Esto permite definir desde el inicio permisos y accesos correctos, evitando errores de diseño y posteriores refactorizaciones.

El **“Quiero”** describe la acción o funcionalidad (por ejemplo: ingresar al sistema).

El **“Para qué”** justifica el valor de la funcionalidad y ayuda a validar si realmente aporta al negocio.

Los **criterios de aceptación** describen los pasos o condiciones que deben cumplirse para que la funcionalidad sea válida. También sirven como base para el **plan de pruebas**. Se recomienda expresarlos como checklist.

Un problema común es olvidar pasos importantes, lo que genera retrabajo y costos futuros. Para minimizar errores, se recomienda agregar un **prototipo o bosquejo** de la interfaz antes de programar. Esto permite retroalimentación temprana y detección de omisiones.

Además de los requerimientos funcionales, en los criterios de aceptación deben incluirse los **requerimientos no funcionales** (tiempos, desempeño, etc.), apoyándose también en prototipos.

Las historias de usuario deben tener una **estimación de tiempo** (en horas). Aunque en Scrum se usan puntos de historia, en XP es válido estimar directamente el tiempo. Esto puede organizarse en una tabla (HTML o Markdown) con cada historia y su duración estimada.

En la primera fase se desarrollan los artefactos (historias, estimaciones, prototipos). Luego se pasa a la fase de **diseño**, que inicia con la **metáfora** del proyecto: un texto breve que da contexto, inspiración, visión y roles del equipo.

En el diseño se utilizan **tarjetas de diseño**, como los **casos de uso**.
Los casos de uso:

* Se derivan directamente de las historias de usuario.
* Representan gráficamente el problema.
* Deben comenzar siempre con un **verbo** (crear, ingresar, generar, etc.).
* No se debe inventar funcionalidad ni actores que no existan en los requerimientos.

Cada requerimiento debe mapearse a un caso de uso; no deben aparecer casos de uso adicionales. El texto del caso de uso debe coincidir con el requerimiento original.

En el diagrama de casos de uso:

* Debe existir al menos un **actor** y el **sistema** que ejecuta la acción.
* No basta con representar el problema; el sistema debe resolverlo.
* Los actores deben ser reales y coherentes (personas o dispositivos existentes).
* Si algo no existe en el problema, no debe aparecer en el diagrama.

Un diagrama correcto muestra claramente quién solicita la acción y quién la ejecuta, sin inventar roles, funcionalidades ni comportamientos no especificados en los requerimientos.

**Texto plano – partes importantes (sin hesitaciones ni repeticiones):**

Las líneas en los diagramas tienen significado.
Si una línea conecta un elemento con el sistema, indica que el sistema gobierna o ejecuta las operaciones.
Si la línea conecta una acción con un elemento tangible, significa que esa acción se implementa o se ejecuta sobre ese elemento.
Las líneas solo deben usarse cuando representan elementos reales y justificables; no deben colocarse sin sentido.

El **diagrama de clases** no se inventa: se deriva directamente de los requerimientos, diálogos e historias de usuario. Todo lo que aparece en el diagrama de clases sale de lo ya definido previamente.

**Primer truco para crear un diagrama de clases:**
Los actores del sistema se convierten directamente en clases.
Por ejemplo: KGD, Sistema Ruso, Cyberdrone.
El diagrama se construye transformando lo que ya existe, sin inventar elementos.

Una clase tiene dos partes:

* **Atributos (datos)**
* **Métodos (operaciones)**

Los métodos se obtienen de los verbos del requerimiento.
Por ejemplo: *leer coordenadas*, *mostrar coordenadas*, *crear bomba*.

Al definir un método, se debe:

* Determinar si es público o privado.
* Definir parámetros (por ejemplo, la ruta del archivo).
* Definir el tipo de retorno.

Cada vez que se define un método, se debe preguntar:

* ¿Dónde se almacenan los datos que produce?
  Si se leen coordenadas, debe existir una estructura (por ejemplo, una lista) para guardarlas.

El **login y password** pertenecen al actor (por ejemplo, KGD), no al sistema.
Las clases deben relacionarse correctamente para reflejar quién posee los datos y quién valida la acción.

Las **relaciones entre clases** son clave:

* **Línea sólida**: alta dependencia. Una clase no puede existir sin la otra. En código implica crear el objeto con `new`.
* **Línea discontinua**: baja dependencia. El objeto puede existir sin el otro; solo se declara la referencia.

Las **composiciones** representan partes inseparables:

* Si un objeto forma parte esencial de otro (ejemplo: cabeza y cuerpo), existe alta dependencia.
* Si una parte puede agregarse después (ejemplo: patas), la dependencia es menor.

Las multiplicidades deben reflejar la realidad:

* No basta con decir “tiene patas”.
* Se debe indicar cuántas y cómo se distribuyen (por ejemplo, 3 izquierdas y 3 derechas) si el diseño lo requiere.
* Si no se necesita tanto detalle, basta con indicar la cantidad total.

Cuando un objeto solo necesita una funcionalidad específica de otro objeto, se usan **interfaces**:

* De todas las capacidades de una clase, solo se expone lo que se necesita.
* La interfaz define el método requerido (por ejemplo, *enseñar inglés*).
* La clase implementa esa interfaz.
* El consumidor solo depende de la interfaz, no de la clase completa.

El **diagrama de clases** ya está pensado para resolver el sistema:

* Cada método corresponde a una funcionalidad real.
* Cada atributo representa datos necesarios para operar.

**Regla clave para métodos:**

* Nunca dejar métodos “mudos” (sin parámetros ni retorno).
* Los parámetros controlan cómo se ejecuta el método.
* El valor de retorno permite continuar el flujo del sistema.

Cada método debe estar respaldado por datos:

* Si hay un método, debe existir una estructura donde se almacene su información.
* Siempre preguntarse dónde queda persistido el resultado.

Con estos criterios se puede diseñar el sistema sin escribir código y minimizar errores futuros.
Este enfoque es especialmente útil cuando solo se solicita diseño, como en proyectos bancarios.

Sobre los **actores y el sistema**:

* El sistema normalmente no es un actor; es lo que se modela.
* Solo sistemas externos o entidades reales deben representarse como actores.

En el proyecto:

* El código debe organizarse en carpetas claras.
* Debe existir trazabilidad entre diseño y código.
* La IA puede apoyar en la generación de código a partir de diseños (hasta un 50%), pero debe ajustarse.

El trabajo se realizará **en pares**, y también se permite trabajar en pares con IA.

**Evidencia del trabajo**:

* No basta con entregar el resultado final.
* Cada artefacto debe tener un video de máximo **3 minutos** mostrando **cómo se construyó**, no solo el resultado.
* El video debe mostrar a las parejas trabajando (planning, diseño, codificación, testing).
* El enfoque del video es el **cómo**, no el **qué**.

Cada fase del proceso debe quedar validada con su respectiva evidencia en video.

