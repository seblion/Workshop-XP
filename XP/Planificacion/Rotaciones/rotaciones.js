// Datos de rotaciones por iteración
const rotacionesData = [
  {
    id: 1,
    nombre: 'Iteración 1',
    pares: [
      {
        persona1: { nombre: 'Angel Anguaya', rol: 'Developer' },
        persona2: { nombre: 'Alexis Sotomayor', rol: 'Developer' }
      },
      {
        persona1: { nombre: 'Alexis Sotomayor', rol: 'Developer' },
        persona2: { nombre: 'Eduardo Arcos', rol: 'Developer' }
      }
    ],
    releases: ['Release 1.0', 'Release 2.0'],
    tiempoHoras: 1
  },
  {
    id: 2,
    nombre: 'Iteración 2',
    pares: [
      {
        persona1: { nombre: 'Angel Anguaya', rol: 'Developer' },
        persona2: { nombre: 'Eduardo Arcos', rol: 'Developer' }
      },
      {
        persona1: { nombre: 'Alexis Sotomayor', rol: 'Tester' },
        persona2: { nombre: 'Evelin Rocha', rol: 'Tester' }
      }
    ],
    releases: ['Release 3.0'],
    tiempoHoras: 1
  }
];

// Todos los releases disponibles
const allReleases = ['Release 1.0', 'Release 2.0', 'Release 3.0'];

// Roles disponibles
const rolesDisponibles = ['Developer', 'Tester'];
