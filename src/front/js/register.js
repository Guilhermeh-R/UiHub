document.addEventListener('DOMContentLoaded', function() {
    const registerButton = document.querySelector(".btn.btn-primary.btn-block");
    
    registerButton.addEventListener("click", function(event) {
        event.preventDefault();  // Evita a navegação padrão ao clicar no botão

        // Obtém os dados dos campos
        const nome = document.getElementById("inputFirstName").value.trim();
        const sobrenome = document.getElementById("inputLastName").value.trim();
        const email = document.getElementById("inputEmail").value.trim();
        const senha = document.getElementById("inputPassword").value.trim();
        const senhaConfirm = document.getElementById("inputPasswordConfirm").value.trim();

        // Verifica se o Nome foi preenchido
        if (nome === "") {
            alert("Por favor, preencha o campo Nome.");
            return;
        }

        // Verifica se o Sobrenome foi preenchido
        if (sobrenome === "") {
            alert("Por favor, preencha o campo Sobrenome.");
            return;
        }

        // Verifica se o Email foi preenchido
        if (email === "") {
            alert("Por favor, preencha o campo Email.");
            return;
        }

        // Verifica se a Senha foi preenchida
        if (senha === "") {
            alert("Por favor, preencha o campo Senha.");
            return;
        }

        // Verifica se a Confirmação de Senha foi preenchida
        if (senhaConfirm === "") {
            alert("Por favor, preencha o campo Confirmação de Senha.");
            return;
        }

        // Verifica se as senhas coincidem
        if (senha !== senhaConfirm) {
            alert("As senhas não coincidem!");
            return;
        }

        // Verifica se o e-mail está em um formato válido
        const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!emailPattern.test(email)) {
            alert("Por favor, insira um e-mail válido.");
            return;
        }

        // Configura o cabeçalho
        const headers = new Headers();
        headers.append("Content-Type", "application/json");

        // Prepara o objeto JSON
        const userData = {
            "nome": nome,
            "sobrenome": sobrenome,
            "email": email,
            "senha": senha
        };

        // Checa se o usuário já existe
        fetch("http://localhost:8080/usuarios", {
            method: "GET",
            headers: headers
        })
        .then(response => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return response.json();
        })
        .then(users => {
            const existingUser = users.find(user => user.email === email);

            if (existingUser) {
                alert("Já existe um usuário cadastrado com esse e-mail!");
            } else {
                // Cria um novo usuário
                fetch("http://localhost:8080/usuarios", {
                    method: "POST",
                    headers: headers,
                    body: JSON.stringify(userData)
                }).then(response => {
                    if (response.status === 201 || response.status === 200) {
                        alert("Usuário criado com sucesso!");
                        window.location.href = "login.html";
                    } else {
                        throw new Error(`HTTP error! status: ${response.status} - ${response.statusText}`);
                    }
                }).catch(error => {
                    console.error("Erro ao criar usuário:", error);
                    alert("Erro ao criar usuário: " + error.message);
                });
            }
        })
        .catch(error => {
            console.error("Erro ao verificar usuário existente:", error);
            alert("Erro ao verificar usuário existente: " + error.message);
        });
    });
});
