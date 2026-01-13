const stories = [
  {
    id: 'HU-01',
    title: 'Control de Acceso Seguro',
    persona: 'Como miembro de la KGD',
    want: 'quiero autenticarme con una contraseña secreta',
    purpose: 'para acceder al panel de control asegurar que solo personal autorizado de la KGD opere el dron.',
    criteria: [
      'Solicita usuario y contrasena a cada miembro, incluyendo el siguiente usuario (patmic,123)',
      'Bloquea el acceso después de 3 intentos fallidos.',
      'Mostrar mensaje de bienvenida al éxito.',
      'Muestra ficha del equipo (cedula, nombre) tras autenticacion'
    ],
    status: 'Completa',
    priority: 'Alta'
  },
  {
    id: 'HU-02',
    title: 'Carga de Datos de Inteligencia ',
    persona: 'Como miembro de la KGD',
    want: 'quiero cargar el archivo CSV',
    purpose: 'para ver coordenadas, horario y arsenal',
    criteria: [
      'Carga archivo Grupo##.csv y valida formato por columna',
      'Muestra una animación de carga (`|/- por cada linea antes de presentar la fila',
      'Presenta tabla con geoposicion, dia y tipo de arsenal'
    ],
    status: 'Completa',
    priority: 'Alta'
  },
  {
    id: 'HU-03',
    title: 'Validación de Objetivos (BBA) ',
    persona: 'Como Inteligencia Artificial',
    want: 'quiero evaluar el automata determinista BBA',
    purpose: 'para validar si un "Tipo de Arsenal" es un objetivo legítimo de destrucción.',
    criteria: [
      'El autómata debe basarse en el lenguaje L (según los últimos dígitos de las cédulas).',
      'Retornar True si la palabra es aceptada y False si no (acepta/rechaza cada arsenal).',
      'Registrar la acción en la tabla de "Coordenadas Ucranianas a Destruir".'
    ],
    status: 'Completa',
    priority: 'Alta'
  },
  {
    id: 'HU-04',
    title: 'Transformacion TIPO_HORMIGA',
    persona: 'Como Sistema de Gestión de Hormigas',
    want: 'quiero que cada tipo de hormiga consuma un alimento específico ',
    purpose: 'para asegurar su supervivencia y evolución.',
    criteria: [
      'Implementa la jerarquía: HLarva (Néctar), HSoldado (Carnívoro).',
      'Controla estado de vida segun si come su ALIMENTO.',
      'Lanzar error o excepción si se intenta alimentar con el tipo incorrecto.'
    ],
    status: 'Completa',
    priority: 'Media'
  },
  {
    id: 'HU-05',
    title: 'Interfaz de Combate',
    persona: 'Como AntCiberDron',
    want: 'quiero gestionar mis extremidades (metralleta y láser) y mi turbo reactor ',
    purpose: 'para realizar maniobras de ataque y vuelo.',
    criteria: [
      'Asocia pata delantera derecha a metralleta y izquierda a laser',
      'Gestiona potencia segun fuente de poder recargable',
      'Permite vuelo con turbo reactor usando energia disponible'
    ],
    status: 'Completa',
    priority: 'Alta'
  },
  {
    id: 'HU-06',
    title: 'Entrenamiento de idiomas para IA',
    persona: 'Como experto parlante de idiomas',
    want: 'quiero cargar lexicos de ingles y espanol al AntCiberDron',
    purpose: 'para entrenar fonetica, gramatica y vocabulario',
    criteria: [
      'Solo expertos asignados pueden entrenar cada idioma',
      'Valida idioma y rol antes de actualizar el modelo',
      'Registra sesiones de entrenamiento por fecha y hora'
    ],
    status: 'Completa',
    priority: 'Media'
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
      'Lista hormigas activas y estado de energia'
    ],
    status: 'Completa',
    priority: 'Media'
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
      <div class="muted" style="margin-top:4px;">${story.priority} </div>
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
    <div class="muted" style="margin:6px 0;">Prioridad ${story.priority}</div>
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
