window.onload = () => {
    const urlParams = new URLSearchParams(window.location.search);
    const searchTerm = urlParams.get('search');
    const content = decodeURIComponent(searchTerm).toLowerCase();
    if (searchTerm) {
       showcards(content);
    } else {
        alert('Nenhum Item foi encontrado');
    }
};

const showcards = (content) =>
{
    const urlParams = new URLSearchParams(window.location.search);
    const idLoja = urlParams.get('idLoja');
    if(!idLoja){
        alert('sem loja')
    }

    const cardContainer = document.getElementById('card-container')
    cardContainer.innerHTML = ''; //limapa os cards anteriores

    fetch('http://localhost:8080/produtos')
    .then(response => response.json())
    .then(data =>
    {
        data = data.filter(element => element.nome.toLowerCase() === content);
        data = data.filter(product => product.loja.idLoja == idLoja);
        if (data.length === 0) {
            alert('Nenhum produto encontrado');
            window.location.href = 'index.html';
            return;
        }
        data.forEach(product => 
        {
            const card = document.createElement('div');
            card.classList.add('cards');
            card.innerHTML =`<div class="card h-100">
                            <img class="card-img-top" src="${product.foto}" alt="${product.nome}" height = 250px/>
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <h5 class="fw-bolder">${product.nome}</h5>
                                    <p>${product.descricao}</p>
                                    <span>R$${product.preco.toFixed(2)}</span>
                                </div>
                            </div>
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto buybtn" href="checkout/index.html?idLoja=${idLoja}&id_produto=${product.idProduto}">Comprar</a></div>
                            </div>
                        </div>`;
            cardContainer.appendChild(card);
        });
    })
}
document.getElementById('searchFormLoja').addEventListener('submit', function(event) {
    event.preventDefault(); // Previne o comportamento padrão do formulário

    const urlParams = new URLSearchParams(window.location.search);
    const idLoja = urlParams.get('idLoja');
    const searchTerm = document.getElementById('searchInput').value;

    if (searchTerm) {
        const encodedSearchTerm = encodeURIComponent(searchTerm);
        if (idLoja) {
            window.location.href = `pesq2.html?idLoja=${idLoja}&search=${encodedSearchTerm}`;
        } else {
            alert('A loja específica não foi encontrada');
        }
    } else {
        alert('Digite algo');
    }

    sla(idLoja);
});

const sla = (content) => {
    console.log(`${content}`);
}
