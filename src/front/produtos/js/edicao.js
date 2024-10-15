document.addEventListener("DOMContentLoaded", function() {
    // Função para obter o parâmetro "idProduto" da URL
    function getParameterByName(name) {
        const urlParams = new URLSearchParams(window.location.search);
        return urlParams.get(name);
    }

    // Função para buscar dados do produto pela API
    async function fetchProductData(idProduto, idLoja) {
        try {
            const response = await fetch(`http://localhost:8080/produtos`);
            const products = await response.json();
            return products.find(product => product.idProduto == idProduto && product.loja.idLoja == idLoja);
        } catch (error) {
            console.error("Erro ao buscar dados do produto:", error);
        }
    }

    // Função para atualizar o HTML com os dados do produto
    function updateProductDetails(product) {
        if (product) {
            document.querySelectorAll(".nomeProduto").forEach(el => el.textContent = product.nome);
            document.getElementById("inputNomeProduto").value = product.nome;
            document.getElementById("inputDescricaoProduto").value = product.descricao;
            document.getElementById("inputLinkFoto").value = product.foto;
            document.getElementById("inputPreco").value = product.preco;
            document.getElementById("inputEstoque").value = product.estoque;
        }
    }

    // Função para salvar os dados do produto na API
    async function saveProductData(idProduto, productData) {
        try {
            const response = await fetch(`http://localhost:8080/produtos/${idProduto}`, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(productData)
            });

            if (response.ok) {
                alert("Produto atualizado com sucesso!");
                window.location.href = "produtos.html"; // Redirecionar para produtos.html
            } else {
                alert("Erro ao atualizar o produto. Tente novamente.");
            }
        } catch (error) {
            console.error("Erro ao salvar dados do produto:", error);
            alert("Erro ao salvar dados do produto. Tente novamente.");
        }
    }

    // Função para validar os campos do formulário
    function validateForm() {
        const nomeProduto = document.getElementById("inputNomeProduto").value.trim();
        const descricaoProduto = document.getElementById("inputDescricaoProduto").value.trim();
        const linkFoto = document.getElementById("inputLinkFoto").value.trim();
        const preco = document.getElementById("inputPreco").value.trim();
        const estoque = document.getElementById("inputEstoque").value.trim();

        if (!nomeProduto) {
            alert("O campo 'Nome do Produto' é obrigatório.");
            return false;
        }
        if (!descricaoProduto) {
            alert("O campo 'Descrição do Produto' é obrigatório.");
            return false;
        }
        if (!linkFoto) {
            alert("O campo 'Link da Foto do Produto' é obrigatório.");
            return false;
        }
        if (!preco) {
            alert("O campo 'Preço' é obrigatório.");
            return false;
        }
        if (!estoque) {
            alert("O campo 'Estoque' é obrigatório.");
            return false;
        }
        return true;
    }

    // Obter "idProduto" da URL
    const idProduto = getParameterByName("idProduto");

    // Obter "userData" do LocalStorage
    const userData = JSON.parse(localStorage.getItem("userData"));
    const idLoja = userData.idUsuario;

    // Buscar e atualizar os dados do produto
    fetchProductData(idProduto, idLoja).then(product => {
        updateProductDetails(product);

        // Adicionar evento de envio ao formulário
        document.getElementById("formCadastroProduto").addEventListener("submit", function(event) {
            event.preventDefault(); // Evitar o envio padrão do formulário

            // Verificar se todos os campos estão preenchidos
            if (validateForm()) {
                const productData = {
                    idLojaTransient: idLoja,
                    nome: document.getElementById("inputNomeProduto").value,
                    descricao: document.getElementById("inputDescricaoProduto").value,
                    preco: parseFloat(document.getElementById("inputPreco").value),
                    foto: document.getElementById("inputLinkFoto").value,
                    dataCriacao: product.dataCriacao, // Usar a data de criação original
                    dataAtualizacao: new Date().toISOString(),
                    estoque: parseInt(document.getElementById("inputEstoque").value)
                };

                saveProductData(idProduto, productData);
            }
        });
    });
});
