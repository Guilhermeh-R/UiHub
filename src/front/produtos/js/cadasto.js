document.addEventListener('DOMContentLoaded', function () {
    // Função para capturar dados do LocalStorage
    function getUserData() {
        return JSON.parse(localStorage.getItem('userData'));
    }

    // Função para verificar se uma string é um URL válido
    function isValidURL(url) {
        try {
            new URL(url);
            return true;
        } catch (_) {
            return false;
        }
    }

    // Função para capturar os dados do formulário e enviar para a API
    function cadastrarProduto() {
        const userData = getUserData();
        const idLojaTransient = userData.idUsuario; // Obter o idUsuario do LocalStorage

        // Capturar os dados do formulário
        const nome = document.getElementById('inputNomeProduto').value.trim();
        const descricao = document.getElementById('inputDescricaoProduto').value.trim();
        const foto = document.getElementById('inputLinkFoto').value.trim();
        const preco = document.getElementById('inputPreco').value.trim();
        const estoque = document.getElementById('inputEstoque').value.trim();

        // Verificação de cada campo individualmente
        if (!nome) {
            alert('Por favor, preencha o campo Nome do Produto.');
            return;
        }

        if (!descricao) {
            alert('Por favor, preencha o campo Descrição do Produto.');
            return;
        }

        if (!foto) {
            alert('Por favor, preencha o campo Link da Foto do Produto.');
            return;
        }

        if (!isValidURL(foto)) {
            alert('Por favor, insira um URL válido para a foto do produto.');
            return;
        }

        if (!preco) {
            alert('Por favor, preencha o campo Preço.');
            return;
        }

        if (!estoque) {
            alert('Por favor, preencha o campo Estoque.');
            return;
        }

        // Obter a data atual no formato ISO
        const dataAtual = new Date().toISOString();

        // Criar o objeto produto
        const produto = {
            idLojaTransient: idLojaTransient,
            nome: nome,
            descricao: descricao,
            preco: parseFloat(preco),
            foto: foto,
            dataCriacao: dataAtual,
            dataAtualizacao: dataAtual,
            estoque: parseInt(estoque)
        };

        // Configurar a requisição
        fetch('http://localhost:8080/produtos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(produto)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Erro ao cadastrar o produto');
            }
            return response.json();
        })
        .then(data => {
            console.log('Produto cadastrado com sucesso:', data);
            alert('Produto cadastrado com sucesso!');
            // Redirecionar para a página inicial após o cadastro
            window.location.href = 'produtos.html';
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Erro ao cadastrar o produto. Tente novamente.');
        });
    }

    // Adicionar o evento de clique ao botão de salvar cadastro
    const salvarButton = document.getElementById('salvarCadastro');
    salvarButton.addEventListener('click', function (event) {
        event.preventDefault(); // Prevenir o comportamento padrão do link
        cadastrarProduto();
    });
});
