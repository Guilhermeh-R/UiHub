document.addEventListener("DOMContentLoaded", function() {
    const urlParams = new URLSearchParams(window.location.search);
    const idPedido = urlParams.get('id_pedido');

    if (idPedido) {
        fetch(`http://localhost:8080/pedidos/${idPedido}`)
            .then(response => response.json())
            .then(data => {
                document.querySelectorAll('.idpedido').forEach(el => el.textContent = data.idPedido);
                document.querySelector('.nome').textContent = data.nome;
                document.querySelector('.email').textContent = data.email;
                document.querySelector('.endereco').textContent = data.endereco || "Endereço não informado";
                document.querySelector('.estado').textContent = data.estado;
                document.querySelector('.cep').textContent = data.cep;
                document.querySelector('.metodopagamento').textContent = data.metodopagamento;
                document.querySelector('.total').textContent = data.totalpedido.toFixed(2);
            })
            .catch(error => console.error('Erro ao buscar os detalhes do pedido:', error));
    } else {
        console.error('ID do pedido não fornecido na URL.');
    }
});
