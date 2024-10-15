document.addEventListener('DOMContentLoaded', () => {
    const userData = JSON.parse(localStorage.getItem('userData'));
    const userId = userData.idUsuario;

    function convertArrayToDate(dateArray) {
        const [year, month, day, hour, minute, second, millisecond] = dateArray;
        return new Date(year, month - 1, day, hour, minute, second, millisecond);
    }

    fetch(`http://localhost:8080/pedidos/loja/${userId}`)
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#datatablesSimple tbody');
            tbody.innerHTML = ''; // Limpa o conteúdo atual do tbody

            // Itera sobre os pedidos para exibir na tabela
            data.forEach(pedido => {
                const dataPedido = convertArrayToDate(pedido.loja.usuario.data_de_registro).toLocaleDateString('pt-BR');
                tbody.innerHTML += `
                    <tr data-id="${pedido.idPedido}">
                        <td>#${pedido.idPedido}</td>
                        <td>${dataPedido}</td>
                        <td>R$ ${pedido.totalpedido.toFixed(2)}</td>
                        <td>${pedido.nome}</td>
                        <td>${pedido.metodopagamento}</td>
                        <td>
                            <a href="detalhes.html?id_pedido=${pedido.idPedido}">
                            <button type="button" class="btn btn-primary details-btn">Detalhes do Pedido</button>
                            </a>
                            </td>
                    </tr>
                `;
            });

            // Inicializa a tabela
            const datatablesSimple = new simpleDatatables.DataTable("#datatablesSimple", {
                columns: [
                    { select: 0, sortable: false },
                    { select: 1, sortable: true },
                    { select: 2, sortable: true },
                    { select: 3, sortable: true },
                    { select: 4, sortable: true },
                    { select: 5, sortable: true },
                    { select: 6, sortable: false }
                ],
                labels: {
                    placeholder: "Buscar...",
                    perPage: "pedidos por página",
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

            // Adiciona evento de clique aos botões de detalhes
            document.querySelectorAll('.details-btn').forEach(button => {
                button.addEventListener('click', (event) => {
                    const tr = event.target.closest('tr');
                    const id = tr.getAttribute('data-id');
                    window.location.href = `detalhes_pedido.html?idPedido=${id}`;
                });
            });
        })
        .catch(error => console.error('Erro ao buscar os pedidos:', error));
});
