window.addEventListener('DOMContentLoaded', event => {
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple, {
            columns: [
                { select: 0, sortable: false },
                { select: 1, sortable: true },
                { select: 2, sortable: true },
                { select: 3, sortable: true },
                { select: 4, sortable: false }
            ],
            labels: {
                placeholder: "Buscar...",
                perPage: "produtos por página",
                noRows: "Nenhum registro encontrado",
                info: "Mostrando {start} a {end} de {rows} registros",
                loading: "Carregando...",
                infoFiltered: " - filtrado de {rows} registros",
                next: "Próximo",
                prev: "Anterior",
                first: "Primeiro",
                last: "Último",
                noResults: "Nenhum resultado encontrado para sua busca"
            }
        });
    }
});