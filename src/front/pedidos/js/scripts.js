document.addEventListener('DOMContentLoaded', function() {
    const authToken = getCookie("authToken");

    if (!authToken) {
        window.location.href = "login.html";
    } else {
        fetch("http://localhost:8080/usuarios", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then(response => response.json())
        .then(users => {
            const user = users.find(user => user.idUsuario === parseInt(authToken));
            if (user) {
                // Atualiza o nome do usuário no elemento com a classe "nomeUser"
                document.querySelectorAll(".nomeUser").forEach(function(element) {
                    element.textContent = user.nome;
                });

                // Busca a loja do usuário
                fetch(`http://localhost:8080/lojas/usuario/${user.idUsuario}`, {
                    method: "GET",
                    headers: {
                        "Content-Type": "application/json"
                    }
                })
                .then(response => response.json())
                .then(loja => {
                    // Atualiza o link da loja
                    document.querySelectorAll(".link-loja").forEach(function(element) {
                        element.href = `../loja/index.html?idLoja=${loja.idLoja}`;
                    });
                })
                .catch(error => {
                    console.error("Erro ao buscar loja:", error);
                    alert("Erro ao buscar loja: " + error.message);
                });
            } else {
                alert("Usuário não encontrado. Por favor, faça login novamente.");
                logout();
            }
        })
        .catch(error => {
            console.error("Erro ao buscar usuário:", error);
            alert("Erro ao buscar usuário: " + error.message);
            logout();
        });
    }

    function getCookie(name) {
        let nameEQ = name + "=";
        let ca = document.cookie.split(';');
        for (let i = 0; i < ca.length; i++) {
            let c = ca[i];
            while (c.charAt(0) == ' ') c = c.substring(1, c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length, c.length);
        }
        return null;
    }

    function logout() {
        document.cookie = "authToken=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
        localStorage.removeItem("userData");
        window.location.href = "login.html";
    }

    document.querySelector(".sair").addEventListener('click', logout);
});
