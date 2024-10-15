document.addEventListener('DOMContentLoaded', function() {
    const loginForm = document.getElementById("loginForm");
    loginForm.addEventListener("submit", function(event) {
        event.preventDefault();  // Evita a submissão padrão do formulário

        const email = document.getElementById("inputEmail").value.trim().toLowerCase();
        const senha = document.getElementById("inputPassword").value.trim();
        const remember = document.getElementById("inputRememberPassword").checked;

        const headers = new Headers();
        headers.append("Content-Type", "application/json");

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
            const user = users.find(user => user.email.toLowerCase() === email && user.senha === senha);

            if (user) {
                
                if (remember) {
                    setCookie("rememberedEmail", email, 30);
                } else {
                    setCookie("rememberedEmail", "", -1);
                }

                setCookie("authToken", user.idUsuario, 1);
                
                // Salva os dados do usuário no localStorage
                localStorage.setItem("userData", JSON.stringify(user));

                window.location.href = "index.html";  // Redireciona para a página principal
            } else {
                alert("E-mail ou senha incorretos!");
            }
        })
        .catch(error => {
            console.error("Erro ao verificar usuário:", error);
            alert("Erro ao verificar usuário: " + error.message);
        });
    });

    function setCookie(name, value, days) {
        let expires = "";
        if (days) {
            const date = new Date();
            date.setTime(date.getTime() + (days * 24 * 60 * 60 * 1000));
            expires = "; expires=" + date.toUTCString();
        }
        document.cookie = name + "=" + (value || "") + expires + "; path=/";
    }

    function getCookie(name) {
        let nameEQ = name + "=";
        let ca = document.cookie.split(';');
        for(let i=0;i < ca.length;i++) {
            let c = ca[i];
            while (c.charAt(0)==' ') c = c.substring(1,c.length);
            if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
        }
        return null;
    }
});
