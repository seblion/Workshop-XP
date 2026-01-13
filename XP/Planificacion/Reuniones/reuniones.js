// Datos de reuniones
const reunionesData = [
  {
    id: 1,
    titulo: "Repartición de roles e inicio de la planificación",
    fecha: "2025-12-29",
    objetivo: "Repartir roles y artefactos",
    queSeHizo:
      "Se repartió los roles, luego se hizo grupos para asignarnos los distintos artefactos de la planificación, diseño y desarrollo.",
  },
  {
    id: 2,
    titulo: "Reunión para hacer los artefactos",
    fecha: "2025-12-30",
    objetivo:
      "Realizar los artefactos de la fase de planificación correspondiente al plan de entrega, rotaciones y reuniones.",
    queSeHizo:
      "Se realizó tres releases en la parte de plan de entrega y se añadió las historias de usuario, luego en las rotaciones se asignó los desarrolladores y testers que van a rotar y en cuanto tiempo se va a rotar, y se hizo el artefacto de las reuniones.",
  },
  {
    id: 3,
    titulo: "Revisión de planificación",
    fecha: "2026-01-01",
    objetivo:
      "Revisar los artefactos correspondientes a la fase de planificación",
    queSeHizo:
      "Se revisaron y validaron los artefactos de la fase de planificación (Plan de Entrega, Historias de Usuario y acordar las Rotaciones a lo largo del desarrollo) para asegurar su consistencia.",
  },
  {
    id: 8,
    titulo: "Metafora del Sistema",
    fecha: "2026-01-03",
    objetivo: "Establecer una visión compartida y un lenguaje común para el diseño del sistema.",
    queSeHizo: "Se definió una metáfora central que describe el funcionamiento del sistema de forma sencilla, facilitando la comunicación entre desarrolladores y clientes.",
  },
  {
    id: 9,
    titulo: "Tarjetas CRC",
    fecha: "2026-01-02",
    objetivo: "Diseñar las clases del sistema identificando sus responsabilidades y colaboraciones.",
    queSeHizo: "Se realizaron sesiones de modelado utilizando tarjetas físicas para representar las clases, sus tareas específicas y cómo interactúan entre sí para cumplir las historias de usuario.",
  },
  {
    id: 10,
    titulo: "Soluciones Puntuales",
    fecha: "2026-01-02",
    objetivo: "Explorar soluciones técnicas para problemas complejos o desconocidos (Spikes).",
    queSeHizo: "Se investigaron y prototiparon soluciones para los desafíos técnicos más críticos, reduciendo la incertidumbre antes de la implementación definitiva.",
  },
  {
    id: 11,
    titulo: "Funcionalidad minima",
    fecha: "2026-01-03",
    objetivo: "Asegurar que el diseño se mantenga simple y enfocado en la funcionalidad actual.",
    queSeHizo: "Se revisó el diseño para eliminar cualquier complejidad innecesaria, priorizando siempre la solución más simple que cumpla con los requisitos del cliente.",
  },
  {
    id: 12,
    titulo: "Reciclaje",
    fecha: "2026-01-03",
    objetivo: "Fomentar la reutilización de código y la consistencia en el diseño.",
    queSeHizo: "Se identificaron componentes y patrones comunes que pueden ser reutilizados en diferentes partes del sistema, optimizando el tiempo de desarrollo y la mantenibilidad.",
  },
  {
    id: 4,
    titulo: "Disponibilidad del cliente",
    fecha: "2026-01-04",
    objetivo: "Garantizar la presencia del cliente para resolver dudas y validar funcionalidades.",
    queSeHizo: "Se coordinó con el cliente los horarios de disponibilidad para consultas rápidas y validaciones, estableciendo canales directos de comunicación para evitar bloqueos durante el desarrollo.",
  },
  {
    id: 5,
    titulo: "Unidad de Pruebas",
    fecha: "2026-01-05",
    objetivo: "Diseñar y ejecutar pruebas unitarias para asegurar el correcto funcionamiento de los componentes.",
    queSeHizo: "Se definieron y escribieron los casos de prueba unitarios para las funcionalidades core antes de iniciar la codificación, asegurando una cobertura integral y siguiendo el enfoque TDD.",
  },
  {
    id: 6,
    titulo: "Programacion por parejas",
    fecha: "2026-01-03",
    objetivo: "Implementar la práctica de programación en parejas para mejorar la calidad del código y fomentar el aprendizaje.",
    queSeHizo: "Se asignaron las parejas de trabajo para la primera iteración, estableciendo rotaciones periódicas para compartir el conocimiento del dominio y mantener una revisión de código constante.",
  },
  {
    id: 7,
    titulo: "Integracion",
    fecha: "2026-01-06",
    objetivo: "Integrar el código desarrollado de manera continua para mantener la estabilidad del sistema.",
    queSeHizo: "Se configuró el entorno de integración continua para fusionar y validar el código diariamente, resolviendo conflictos de inmediato y manteniendo una versión estable del producto siempre disponible.",
  },
];
