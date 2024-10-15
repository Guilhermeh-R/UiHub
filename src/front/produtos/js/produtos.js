document.addEventListener('DOMContentLoaded', () => {
    const userData = JSON.parse(localStorage.getItem('userData'));
    const userId = userData.idUsuario;

    fetch('http://localhost:8080/produtos')
        .then(response => response.json())
        .then(data => {
            const tbody = document.querySelector('#datatablesSimple tbody');
            tbody.innerHTML = ''; // Limpa o conteúdo atual do tbody

            // Filtra os produtos para exibir apenas os associados ao usuário
            const filteredProducts = data.filter(produto => produto.loja.usuario.idUsuario === userId);

            filteredProducts.forEach(produto => {
                tbody.innerHTML += `
                    <tr data-id="${produto.idProduto}">
                        <td><img src="${produto.foto}" class="img-fluid img-square" style="width: 50px;"></td>
                        <td>${produto.nome}</td>
                        <td>R$ ${produto.preco.toFixed(2)}</td>
                        <td>${produto.estoque}</td>
                        <td>
                            <div class="d-flex gap-2">
                                <button type="button" class="btn btn-primary edit-btn">Editar</button>
                                <button type="button" class="btn btn-danger delete-btn">Deletar</button>
                            </div>
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

            // Adiciona evento de clique aos botões de deletar
            document.querySelectorAll('.delete-btn').forEach(button => {
                button.addEventListener('click', (event) => {
                    const tr = event.target.closest('tr');
                    const id = tr.getAttribute('data-id');
                    fetch(`http://localhost:8080/produtos/${id}`, {
                        method: 'DELETE'
                    })
                    .then(response => {
                        if (response.ok) {
                            tr.remove(); // Remove a linha da tabela
                            alert('Produto deletado com sucesso!');
                        } else {
                            alert('Erro ao deletar o produto');
                        }
                    })
                    .catch(error => console.error('Erro ao deletar o produto:', error));
                });
            });

            // Adiciona evento de clique aos botões de editar
            document.querySelectorAll('.edit-btn').forEach(button => {
                button.addEventListener('click', (event) => {
                    const tr = event.target.closest('tr');
                    const id = tr.getAttribute('data-id');
                    window.location.href = `edicao.html?idProduto=${id}`;
                });
            });
        })
        .catch(error => console.error('Erro ao buscar os produtos:', error));
});
