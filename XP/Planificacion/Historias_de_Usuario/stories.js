const stories = [
  {
    id: 'HU-01',
    title: 'Login seguro para equipo KGD',
    persona: 'Como miembro de la KGD',
    want: 'quiero autenticarme con hasta 3 intentos',
    purpose: 'para acceder al panel y presentar el equipo al profesor',
    criteria: [
      'Solicita usuario y contrasena a cada integrante y al profesor (patmic,123)',
      'Bloquea al tercer intento fallido y registra evento',
      'Muestra ficha del equipo (cedula, nombre) tras autenticacion'
    ],
    status: 'En progreso',
    priority: 'Alta',
    estimate: 6,
    iteration: 'Iteracion 1',
    owner: 'Par A',
    module: 'Seguridad',
    due: '2025-01-12'
  },
  {
    id: 'HU-02',
    title: 'Lectura del archivo Grupo##.csv',
    persona: 'Como operador KGD',
    want: 'quiero cargar el archivo CSV desencriptado',
    purpose: 'para ver coordenadas, horario y arsenal',
    criteria: [
      'Carga archivo Grupo##.csv y valida formato por columna',
      'Muestra loading por cada linea antes de presentar la fila',
      'Presenta tabla con geoposicion, dia y tipo de arsenal'
    ],
    status: 'En progreso',
    priority: 'Alta',
    estimate: 8,
    iteration: 'Iteracion 1',
    owner: 'Par B',
    module: 'Datos',
    due: '2025-01-15'
  },
  {
    id: 'HU-03',
    title: 'Automata BBA para arsenales 5 y 9',
    persona: 'Como ingeniero de IA',
    want: 'quiero evaluar el automata determinista BBA',
    purpose: 'para decidir si la bomba explota segun el lenguaje',
    criteria: [
      'Define DFA que reconoce L = { abcdt+, ab* } (coordenadas 5 y 9)',
      'Muestra grafo, transiciones y acepta/rechaza cada arsenal',
      'Regresa true/false y muestra coordenada a impactar'
    ],
    status: 'Pendiente',
    priority: 'Alta',
    estimate: 10,
    iteration: 'Iteracion 1',
    owner: 'Par C',
    module: 'IA y bombas',
    due: '2025-01-18'
  },
  {
    id: 'HU-04',
    title: 'Transformacion TIPO_HORMIGA',
    persona: 'Como biologo de campo',
    want: 'quiero definir la metamorfosis de HLarva segun alimento',
    purpose: 'para obtener HSoldado, HZangano o HRastreadora segun grupo',
    criteria: [
      'Mapea ALIMENTO a TIPO_HORMIGA segun grupo (1-2, 3-4, 5)',
      'Controla estado de vida segun si come su ALIMENTO',
      'Persistencia de estado para trazabilidad del enjambre'
    ],
    status: 'Pendiente',
    priority: 'Media',
    estimate: 5,
    iteration: 'Iteracion 2',
    owner: 'Par A',
    module: 'Dominio hormigas',
    due: '2025-01-24'
  },
  {
    id: 'HU-05',
    title: 'AntCiberDron armado y energia',
    persona: 'Como tactico KGD',
    want: 'quiero equipar extremidades y gestionar energia',
    purpose: 'para disparar metralleta o laser y volar con turbo reactor',
    criteria: [
      'Asocia pata delantera derecha a metralleta y izquierda a laser',
      'Gestiona potencia segun fuente de poder recargable',
      'Permite vuelo con turbo reactor usando energia disponible'
    ],
    status: 'En progreso',
    priority: 'Alta',
    estimate: 9,
    iteration: 'Iteracion 2',
    owner: 'Par B',
    module: 'Hardware',
    due: '2025-01-26'
  },
  {
    id: 'HU-06',
    title: 'Entrenamiento de idiomas para IA',
    persona: 'Como entrenador de idiomas',
    want: 'quiero cargar lexicos de ingles y espanol',
    purpose: 'para entrenar fonetica, gramatica y vocabulario',
    criteria: [
      'Solo expertos asignados pueden entrenar cada idioma',
      'Valida idioma y rol antes de actualizar el modelo',
      'Registra sesiones de entrenamiento por fecha y hora'
    ],
    status: 'Pendiente',
    priority: 'Media',
    estimate: 6,
    iteration: 'Iteracion 2',
    owner: 'Par C',
    module: 'IA y bombas',
    due: '2025-01-28'
  },
  {
    id: 'HU-07',
    title: 'Hormiguero virtual para KGD',
    persona: 'Como operador del hormiguero',
    want: 'quiero crear y gestionar hormigas y su alimento',
    purpose: 'para administrar el enjambre y asignar misiones',
    criteria: [
      'CRUD de hormigas con tipo, energia y alimento asignado',
      'Asigna coordenadas y arsenal a cada hormiga',
      'Dashboard lista hormigas activas y estado de energia'
    ],
    status: 'Pendiente',
    priority: 'Media',
    estimate: 8,
    iteration: 'Iteracion 2',
    owner: 'Par B',
    module: 'UI hormiguero',
    due: '2025-01-30'
  },
  {
    id: 'HU-08',
    title: 'Evidencias en video por fase',
    persona: 'Como auditor XP',
    want: 'quiero registrar videos de max 3 min por actividad',
    purpose: 'para validar trazabilidad del trabajo en pares',
    criteria: [
      'Carpetas por fase: planning, diseno, coding, testing',
      'Cada video muestra el como se construyo el artefacto',
      'Checklist de cobertura por actividad y rol'
    ],
    status: 'Completa',
    priority: 'Baja',
    estimate: 3,
    iteration: 'Iteracion 1',
    owner: 'Par A',
    module: 'Evidencias',
    due: '2025-01-10'
  },
  {
    id: 'HU-09',
    title: 'Backlog XP visible y asignable',
    persona: 'Como coach XP',
    want: 'quiero gestionar el backlog de historias',
    purpose: 'para asignar responsables, fechas y prioridad con trazabilidad',
    criteria: [
      'Listado de todas las HU con estado, prioridad/dificultad y estimacion en horas',
      'Al hacer clic se muestra detalle completo (Yo como / Quiero / Para) y criterios de aceptacion',
      'Permite asignar responsable(es) y fecha objetivo por HU',
      'Indica estado (pendiente, en progreso, completa) y permite actualizarlo',
      'Permite marcar prioridad Alta/Media/Baja y registrar iteracion',
      'Mantiene evidencia vinculada a cada HU (ruta a video o carpeta)'
    ],
    status: 'En progreso',
    priority: 'Alta',
    estimate: 7,
    iteration: 'Iteracion 1',
    owner: 'Coach',
    module: 'Backlog',
    due: '2025-01-14'
  }
];

if (typeof window !== 'undefined') {
  window.stories = stories;
}
// Inicializador local para la vista de historias de usuario (sin reutilizar funciones de main.js)
// Toma los datos globales (stories) ya cargados por main.js, pero redefine el renderizado aquí.

const statusColorLocal = (window.statusColor) || {
  'Completa': 'pill-ok',
  'En progreso': 'pill-warn',
  'Pendiente': 'pill-danger'
};

function renderStoriesLocal() {
  const list = document.getElementById('story-list');
  const detailId = 'story-detail';
  if (!list || !Array.isArray(window.stories)) return;

  const statusFilter = document.getElementById('filter-status')?.value || 'todos';
  const priorityFilter = document.getElementById('filter-priority')?.value || 'todas';
  const iterationFilter = document.getElementById('filter-iteration')?.value || 'todas';

  const filtered = window.stories.filter(story => {
    const statusOk = statusFilter === 'todos' || story.status === statusFilter;
    const priorityOk = priorityFilter === 'todas' || story.priority === priorityFilter;
    const iterationOk = iterationFilter === 'todas' || story.iteration === iterationFilter;
    return statusOk && priorityOk && iterationOk;
  });

  list.innerHTML = filtered.map(story => `
    <div class="card story-item" data-id="${story.id}" onclick="selectStoryLocal('${story.id}')">
      <div class="row"><strong>${story.id}</strong><span class="badge ${statusColorLocal[story.status]}">${story.status}</span></div>
      <div>${story.title}</div>
      <div class="muted" style="margin-top:4px;">${story.priority} · ${story.estimate}h · Due ${story.due}</div>
    </div>
  `).join('');

  if (filtered.length > 0) selectStoryLocal(filtered[0].id);
  else document.getElementById(detailId).innerHTML = '<div class="muted">Sin historias filtradas.</div>';
}

function selectStoryLocal(id) {
  const story = (window.stories || []).find(s => s.id === id);
  const detail = document.getElementById('story-detail');
  if (!story || !detail) return;

  document.querySelectorAll('#story-list .story-item').forEach(el => {
    if (el.dataset.id === id) el.classList.add('active'); else el.classList.remove('active');
  });

  detail.innerHTML = `
    <div class="row"><h3 style="margin:0;">${story.id} - ${story.title}</h3><span class="badge ${statusColorLocal[story.status]}">${story.status}</span></div>
    <div class="muted" style="margin:6px 0;"><strong>Historia:</strong> ${story.persona} ${story.want} ${story.purpose}</div>
    <div class="muted" style="margin:6px 0;">Prioridad ${story.priority} · Estimacion ${story.estimate}h · Due ${story.due}</div>
    <div style="margin-top:10px;">
      <div class="muted"><strong>Criterios de aceptacion:</strong></div>
      <div class="list" style="margin-top:6px;">${story.criteria.map(item => `<div class="muted">• ${item}</div>`).join('')}</div>
    </div>
  `;
}

document.addEventListener('DOMContentLoaded', () => {
  renderStoriesLocal();

  ['filter-status', 'filter-priority', 'filter-iteration'].forEach(id => {
    const el = document.getElementById(id);
    if (el) el.addEventListener('change', renderStoriesLocal);
  });
});
