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
