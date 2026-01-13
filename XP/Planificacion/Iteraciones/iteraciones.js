// Datos de iteraciones, equipo y evidencias
const iterations = [
  {
    name: 'Iteracion 1',
    goal: 'Seguridad, Gestion CSV y Automata BBA base',
    start: '2025-12-30',
    end: '2026-01-01',
    hours: 24,
    progress: { Planificacion: 100, Diseno: 100, Coding: 100, Testing: 100 }
  },
  {
    name: 'Iteracion 2',
    goal: 'Hormiguero virtual y entrenamiento idiomas',
    start: '2026-01-02',
    end: '2026-01-05',
    hours: 16,
    progress: { Planificacion: 100, Diseno: 100, Coding: 100, Testing: 100 }
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
