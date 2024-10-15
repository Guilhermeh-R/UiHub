document.addEventListener("DOMContentLoaded", function() {
    const userData = JSON.parse(localStorage.getItem("userData"));
    const usuarioId = userData.idUsuario;
    const apiUrl = `http://localhost:8080/lojas/usuario/${usuarioId}`;

    let visitantes = 0; // Variável para armazenar o número de visitantes

    // Função para buscar os dados da loja
    async function fetchLojaData() {
        try {
            const response = await fetch(apiUrl);
            if (!response.ok) {
                throw new Error("Erro ao buscar dados da loja");
            }
            const loja = await response.json();
            visitantes = loja.visitantes; // Armazenar o número de visitantes
            populateForm(loja);
        } catch (error) {
            console.error("Erro ao buscar dados da loja:", error);
        }
    }

    // Função para preencher o formulário com os dados da loja
    function populateForm(loja) {
        document.getElementById("inputNomeLoja").value = loja.nome;
        document.getElementById("inputLinkFotoBanner").value = loja.banner;
        document.getElementById("inputCorMenu").value = loja.cor_menu;
        document.getElementById("inputCorTextoMenu").value = loja.cor_texto_menu;
        document.getElementById("inputCorPagina").value = loja.cor_fundo;
    }

    // Função para validar URL
    function isValidURL(url) {
        try {
            new URL(url);
            return true;
        } catch (_) {
            return false;
        }
    }

    // Função para validar formulário
    function validateForm(loja) {
        if (!loja.nome || !loja.banner || !loja.cor_menu || !loja.cor_texto_menu || !loja.cor_fundo) {
            alert("Todos os campos devem ser preenchidos.");
            return false;
        }
        if (!isValidURL(loja.banner)) {
            alert("O link da foto de banner deve ser um URL válido.");
            return false;
        }
        return true;
    }

    // Evento para salvar as edições do formulário
    document.getElementById("formCadastroProduto").addEventListener("submit", async function(event) {
        event.preventDefault();

        const loja = {
            nome: document.getElementById("inputNomeLoja").value,
            banner: document.getElementById("inputLinkFotoBanner").value,
            cor_menu: document.getElementById("inputCorMenu").value,
            cor_texto_menu: document.getElementById("inputCorTextoMenu").value,
            cor_fundo: document.getElementById("inputCorPagina").value,
            visitantes: visitantes // Incluir o número de visitantes
        };

        if (!validateForm(loja)) {
            return;
        }

        try {
            const response = await fetch(apiUrl, {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(loja)
            });

            if (!response.ok) {
                throw new Error("Erro ao salvar dados da loja");
            }

            alert("Dados da loja atualizados com sucesso!");
            location.reload(); // Recarregar a página
        } catch (error) {
            console.error("Erro ao salvar dados da loja:", error);
            alert("Erro ao salvar dados da loja. Tente novamente.");
        }
    });

    // Buscar os dados da loja ao carregar a página
    fetchLojaData();
});
