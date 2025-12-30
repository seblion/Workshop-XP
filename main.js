// Datos base alineados a indicaciones y workshop
const phases = [
  {
    name: 'Planificacion',
    progress: 65,
    activities: ['Historias de usuario', 'Plan de entregas', 'Velocidad y rotaciones', 'Reuniones y acuerdos de pares'],
    artifacts: ['Backlog HU con estimacion en horas', 'Plan de iteraciones', 'Roles y responsables'],
    roles: ['Product Owner', 'Dev Pair', 'Coach'],
    results: 'Backlog priorizado y fechas pactadas'
  },
  {
    name: 'Diseno',
    progress: 40,
    activities: ['Metafora del sistema', 'Casos de uso y CRC', 'Modelos: clases, ER, arquitectura'],
    artifacts: ['Tarjetas CRC', 'Diagramas (casos de uso, clases, automata, ER, arquitectura)', 'Prototipos UI hormiguero'],
    roles: ['Dev Pair', 'Tester', 'Coach'],
    results: 'Traza clara HU -> diseno -> codigo'
  },
  {
    name: 'Coding',
    progress: 30,
    activities: ['Programacion en pares', 'Integracion continua', 'Traza HU -> codigo'],
    artifacts: ['Codigo organizado por modulos', 'Pruebas unitarias en progreso'],
    roles: ['Dev Pair', 'Product Owner disponible'],
    results: 'Incrementos listos por iteracion'
  },
  {
    name: 'Testing',
    progress: 20,
    activities: ['Pruebas de aceptacion por HU', 'Pruebas unitarias e integracion', 'Validacion de criterios'],
    artifacts: ['Suite de pruebas', 'Evidencia de ejecucion'],
    roles: ['Tester', 'Dev Pair', 'Cliente'],
    results: 'HU aceptadas con evidencia'
  }
];

const stories = (typeof window !== 'undefined' && window.stories) ? window.stories : [];

const iterations = [
  {
    name: 'Iteracion 1',
    goal: 'Seguridad, ingestion CSV y automata BBA base',
    start: '2025-01-05',
    end: '2025-01-18',
    hours: 80,
    progress: { Planificacion: 90, Diseno: 55, Coding: 35, Testing: 15 }
  },
  {
    name: 'Iteracion 2',
    goal: 'AntCiberDron, hormiguero y entrenamiento idiomas',
    start: '2025-01-19',
    end: '2025-02-02',
    hours: 82,
    progress: { Planificacion: 70, Diseno: 45, Coding: 25, Testing: 20 }
  }
];

const team = [
  { name: 'Product Owner', people: ['Profesor'], focus: 'Prioriza backlog, valida entrega' },
  { name: 'Developer Pair A', people: ['Alumno 1', 'Alumno 2'], focus: 'Seguridad y dominio' },
  { name: 'Developer Pair B', people: ['Alumno 3', 'Alumno 4'], focus: 'CSV, hormiguero, hardware' },
  { name: 'Developer Pair C', people: ['Alumno 5', 'Alumno 6'], focus: 'IA, automata, idiomas' },
  { name: 'Tester', people: ['Alumno 7'], focus: 'Pruebas aceptacion, cobertura' },
  { name: 'Coach', people: ['Alumno 8'], focus: 'Practicas XP, rotaciones' }
];

const designWork = [
  { name: 'Metafora del sistema', detail: 'Hormiguero militar coordinando AntCiberDron para neutralizar arsenales ucranianos.', phase: 'Diseno' },
  { name: 'Casos de uso', detail: 'Autenticarse, Cargar CSV, Evaluar arsenal con BBA, Gestionar hormiguero, Entrenar idiomas.', phase: 'Diseno' },
  { name: 'Diagrama de clases', detail: 'Actores se vuelven clases: KGD, AntCiberDron, Hormiga, BombaBBA, FuentePoder, Autenticacion.', phase: 'Diseno' },
  { name: 'Automata DFA', detail: 'Estados para L = { abcdt+, ab* } con transiciones deterministas.', phase: 'Testing' },
  { name: 'Codigo', detail: 'Modulos por dominio: seguridad, datos, automata, hardware, UI hormiguero.', phase: 'Coding' },
  { name: 'Pruebas', detail: 'Unitarias por automata y autenticacion; integracion en carga CSV; aceptacion por HU.', phase: 'Testing' }
];

const evidences = [
  { name: 'Planning', items: ['Video backlog HU (<=3 min)', 'Video plan de iteraciones', 'Video definicion roles y rotaciones'] },
  { name: 'Diseno', items: ['Video metafora y casos de uso', 'Video grafo automata y clases', 'Video prototipo UI hormiguero'] },
  { name: 'Coding', items: ['Video programacion en pares', 'Video integracion CSV + automata', 'Video AntCiberDron hardware logico'] },
  { name: 'Testing', items: ['Video ejecucion pruebas HU', 'Video validacion criterios', 'Video checklist evidencia'] }
];

const statusColor = {
  'Completa': 'pill-ok',
  'En progreso': 'pill-warn',
  'Pendiente': 'pill-danger'
};

function renderPhases(containerId) {
  const container = document.getElementById(containerId);
  if (!container) return;
  container.innerHTML = phases.map(phase => `
    <div class="card">
      <div class="row"><strong>${phase.name}</strong><span class="badge">${phase.progress}%</span></div>
      <div class="progress" aria-label="progreso ${phase.name}"><span style="width:${phase.progress}%"></span></div>
      <div class="muted" style="margin-top:6px;">${phase.results}</div>
      <div class="muted" style="margin-top:8px;">Actividades: ${phase.activities.join(', ')}</div>
      <div class="muted" style="margin-top:6px;">Artefactos: ${phase.artifacts.join(', ')}</div>
      <div class="muted" style="margin-top:6px;">Roles: ${phase.roles.join(', ')}</div>
    </div>
  `).join('');
}

function renderStories(listId, detailId, filters) {
  const list = document.getElementById(listId);
  if (!list) return;
  const statusFilter = filters?.status?.value || 'todos';
  const priorityFilter = filters?.priority?.value || 'todas';
  const iterationFilter = filters?.iteration?.value || 'todas';

  const filtered = stories.filter(story => {
    const statusOk = statusFilter === 'todos' || story.status === statusFilter;
    const priorityOk = priorityFilter === 'todas' || story.priority === priorityFilter;
    const iterationOk = iterationFilter === 'todas' || story.iteration === iterationFilter;
    return statusOk && priorityOk && iterationOk;
  });

  list.innerHTML = filtered.map(story => `
    <div class="card story-item" data-id="${story.id}" onclick="selectStory('${story.id}','${detailId}','${listId}')">
      <div class="row"><strong>${story.id}</strong><span class="badge ${statusColor[story.status]}">${story.status}</span></div>
      <div>${story.title}</div>
      <div class="muted" style="margin-top:4px;">${story.priority} · ${story.estimate}h · Due ${story.due}</div>
    </div>
  `).join('');

  if (filtered.length > 0) selectStory(filtered[0].id, detailId, listId);
  else document.getElementById(detailId).innerHTML = '<div class="muted">Sin historias filtradas.</div>';
}

function selectStory(id, detailId, listId) {
  const story = stories.find(s => s.id === id);
  const detail = document.getElementById(detailId);
  if (!story || !detail) return;
  document.querySelectorAll(`#${listId} .story-item`).forEach(el => {
    if (el.dataset.id === id) el.classList.add('active'); else el.classList.remove('active');
  });
  detail.innerHTML = `
    <div class="row"><h3 style="margin:0;">${story.id} - ${story.title}</h3><span class="badge ${statusColor[story.status]}">${story.status}</span></div>
    <div class="muted" style="margin:6px 0;"><strong>Historia:</strong> ${story.persona} ${story.want} ${story.purpose}</div>
    <div class="muted" style="margin:6px 0;">Prioridad ${story.priority} · Estimacion ${story.estimate}h · Due ${story.due}</div>
    <div style="margin-top:10px;">
      <div class="muted"><strong>Criterios de aceptacion:</strong></div>
      <div class="list" style="margin-top:6px;">${story.criteria.map(item => `<div class="muted">• ${item}</div>`).join('')}</div>
    </div>
    <div class="muted" style="margin-top:10px;">Evidencia: ${story.evidence}</div>
  `;
}

function renderIterations(tableId) {
  const table = document.getElementById(tableId);
  if (!table) return;
  table.innerHTML = `
    <tr>
      <th>Iteracion</th>
      <th>Objetivo</th>
      <th>Rango</th>
      <th>Horas</th>
      <th>Planificacion</th>
      <th>Diseno</th>
      <th>Coding</th>
      <th>Testing</th>
    </tr>
    ${iterations.map(it => `
      <tr>
        <td>${it.name}</td>
        <td>${it.goal}</td>
        <td>${it.start} - ${it.end}</td>
        <td>${it.hours}h</td>
        <td><div class="mini-bar"><span style="width:${it.progress.Planificacion}%"></span></div></td>
        <td><div class="mini-bar"><span style="width:${it.progress.Diseno}%"></span></div></td>
        <td><div class="mini-bar"><span style="width:${it.progress.Coding}%"></span></div></td>
        <td><div class="mini-bar"><span style="width:${it.progress.Testing}%"></span></div></td>
      </tr>
    `).join('')}
  `;
}

function renderTeam(containerId) {
  const container = document.getElementById(containerId);
  if (!container) return;
  container.innerHTML = team.map(member => `
    <div class="card">
      <div class="row"><strong>${member.name}</strong><span class="badge">${member.people.join(', ')}</span></div>
      <div class="muted" style="margin-top:6px;">${member.focus}</div>
    </div>
  `).join('');
}

function renderDesign(containerId) {
  const container = document.getElementById(containerId);
  if (!container) return;
  container.innerHTML = designWork.map(item => `
    <div class="card">
      <div class="row"><strong>${item.name}</strong><span class="badge">${item.phase}</span></div>
      <div class="muted" style="margin-top:6px;">${item.detail}</div>
    </div>
  `).join('');
}

function renderEvidence(containerId) {
  const container = document.getElementById(containerId);
  if (!container) return;
  container.innerHTML = evidences.map(ev => `
    <div class="card">
      <div class="row"><strong>${ev.name}</strong><span class="badge">Videos <= 3 min</span></div>
      <div class="list">${ev.items.map(it => `<div class="muted">• ${it}</div>`).join('')}</div>
    </div>
  `).join('');
}

function renderHomeHighlights(containerId) {
  const container = document.getElementById(containerId);
  if (!container) return;
  const top = stories.slice(0, 3);
  container.innerHTML = top.map(story => `
    <div class="card">
      <div class="row"><strong>${story.id}</strong><span class="badge ${statusColor[story.status]}">${story.status}</span></div>
      <div>${story.title}</div>
      <div class="muted" style="margin-top:6px;">${story.priority} · ${story.estimate}h · ${story.iteration}</div>
    </div>
  `).join('');
}

function initPage() {
  const page = document.body.dataset.page;
  if (page === 'home') {
    renderPhases('phase-cards');
    renderHomeHighlights('highlight-stories');
    renderIterations('iteration-table');
  }
  if (page === 'stories') {
    renderStories('story-list', 'story-detail', {
      status: document.getElementById('filter-status'),
      priority: document.getElementById('filter-priority'),
      iteration: document.getElementById('filter-iteration')
    });
    ['filter-status','filter-priority','filter-iteration'].forEach(id => {
      const el = document.getElementById(id);
      if (el) el.addEventListener('change', () => renderStories('story-list','story-detail', {
        status: document.getElementById('filter-status'),
        priority: document.getElementById('filter-priority'),
        iteration: document.getElementById('filter-iteration')
      }));
    });
  }
  if (page === 'iterations') {
    renderIterations('iteration-table');
    renderTeam('team-cards');
    renderDesign('design-cards');
  }
  if (page === 'evidencias') {
    renderEvidence('evidence-cards');
  }
}

document.addEventListener('DOMContentLoaded', initPage);
