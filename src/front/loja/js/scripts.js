window.onload = function() {
    // Pega o ID da loja a partir da URL
    const params = new URLSearchParams(window.location.search);
    const idLoja = params.get('idLoja');

    // Verifica se idLoja é nulo, vazio, ou não é um número
    if (!idLoja || isNaN(idLoja)) {
        window.location.href = '../login.html';
    } else {
        // Se idLoja é válido, incrementa o número de visitantes
        fetch(`http://localhost:8080/lojas/usuario/${idLoja}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.json();
            })
            .then(data => {
                // Incrementa o número de visitantes
                const updatedData = { ...data, visitantes: data.visitantes + 1 };

                fetch(`http://localhost:8080/lojas/usuario/${idLoja}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(updatedData)
                })
                .then(updateResponse => {
                    if (!updateResponse.ok) {
                        throw new Error('Network response was not ok ' + updateResponse.statusText);
                    }
                    return updateResponse.json();
                })
                .then(updatedData => {
                    // Altera o title da página
                    document.title = updatedData.nome;

                    // Altera todos os elementos com a classe "nomeLoja"
                    const nomeLojaElements = document.getElementsByClassName("nomeLoja");
                    for (let element of nomeLojaElements) {
                        element.textContent = updatedData.nome;
                    }

                    // Altera o src de todos os elementos com a classe "bannerLoja"
                    const bannerLojaElements = document.getElementsByClassName("bannerLoja");
                    for (let element of bannerLojaElements) {
                        element.src = updatedData.banner;
                    }

                    // Atualiza o atributo "color" para a classe "corTextoMenu"
                    const corTextoMenuElements = document.getElementsByClassName("corTextoMenu");
                    for (let element of corTextoMenuElements) {
                        element.style.color = updatedData.cor_texto_menu;
                    }

                    // Atualiza o atributo "background-color" para a classe "corMenu"
                    const corMenuElements = document.getElementsByClassName("corMenu");
                    for (let element of corMenuElements) {
                        element.style.backgroundColor = updatedData.cor_menu;
                    }

                    // Atualiza o atributo "background-color" para a classe "corFundo"
                    const corFundoElements = document.getElementsByClassName("corFundo");
                    for (let element of corFundoElements) {
                        element.style.backgroundColor = updatedData.cor_fundo;
                    }
                })
                .catch(error => {
                    console.error('Erro ao atualizar os visitantes:', error);
                    window.location.href = '../login.html';
                });
            })
            .catch(error => {
                console.error('Fetch error:', error);
                window.location.href = '../login.html';
            });
    }
};

// Buscar e listar produtos
document.addEventListener('DOMContentLoaded', () => {
    const urlParams = new URLSearchParams(window.location.search);
    const idLoja = urlParams.get('idLoja');

    if (idLoja) {
        fetch('http://localhost:8080/produtos')
            .then(response => response.json())
            .then(data => {
                const products = data.filter(product => product.loja.idLoja == idLoja && product.estoque > 0);
                const productList = document.getElementById('product-list');
                const nomeLoja = document.querySelector('.nomeLoja');
                const bannerLoja = document.querySelector('.bannerLoja');
                
                if (products.length > 0) {
                    nomeLoja.textContent = products[0].loja.nome;
                    bannerLoja.src = products[0].loja.banner;
                }

                products.forEach(product => {
                    const productCard = document.createElement('div');
                    productCard.classList.add('col', 'mb-5');
                    productCard.innerHTML = `
                        <div class="card h-100">
                            <img class="card-img-top" src="${product.foto}" alt="${product.nome}" />
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
                        </div>
                    `;
                    productList.appendChild(productCard);
                });
            })
            .catch(error => console.error('Erro ao buscar produtos:', error));
    } else {
        console.error('idLoja não encontrado na URL');
    }
});

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
