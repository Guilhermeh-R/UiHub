document.addEventListener('DOMContentLoaded', function () {
  'use strict';

  // Ocultar/Mostrar dados do cartão de crédito
  const paymentRadios = document.querySelectorAll('input[name="paymentMethod"]');
  const cardDetails = document.querySelector('.dadoscartao');

  paymentRadios.forEach(radio => {
    radio.addEventListener('change', function () {
      if (this.value === 'Boleto' || this.value === 'PIX') {
        cardDetails.style.display = 'none';
        document.getElementById('cc-name').removeAttribute('required');
        document.getElementById('cc-number').removeAttribute('required');
        document.getElementById('cc-expiration').removeAttribute('required');
        document.getElementById('cc-cvv').removeAttribute('required');
      } else {
        cardDetails.style.display = 'block';
        document.getElementById('cc-name').setAttribute('required', 'required');
        document.getElementById('cc-number').setAttribute('required', 'required');
        document.getElementById('cc-expiration').setAttribute('required', 'required');
        document.getElementById('cc-cvv').setAttribute('required', 'required');
      }
    });
  });

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  var forms = document.querySelectorAll('.needs-validation');

  // Loop over them and prevent submission
  Array.prototype.slice.call(forms)
    .forEach(function (form) {
      form.addEventListener('submit', function (event) {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
          console.log("Formulário inválido.");
        } else {
          event.preventDefault();
          console.log("Formulário válido. Enviando pedido...");
          fetchProductAndSubmitOrder();
        }

        form.classList.add('was-validated');
      }, false);
    });

  function fetchProductAndSubmitOrder() {
    const urlParams = new URLSearchParams(window.location.search);
    const idProduto = urlParams.get('id_produto');

    fetch(`http://localhost:8080/produtos/${idProduto}`)
      .then(response => response.json())
      .then(data => {
        console.log('Produto carregado com sucesso:', data);
        submitOrder(data);
      })
      .catch(error => {
        console.error('Erro ao carregar o produto:', error);
      });
  }

  function submitOrder(product) {
    const form = document.getElementById('checkoutForm');
    const formData = new FormData(form);

    // Extrair dados do formulário
    const nome = formData.get('firstName');
    const email = formData.get('email');
    const endereco = formData.get('address');
    const complemento = formData.get('address2') || '';
    const cep = formData.get('zip');
    const estado = formData.get('state');
    const metodoPagamento = formData.get('paymentMethod');
    const totalPedido = product.preco; // Calculando o total do pedido com base no preço do produto

    // Obter parâmetros da URL
    const urlParams = new URLSearchParams(window.location.search);
    const idLoja = urlParams.get('idLoja');

    const produtosPedido = [{
      id_produto: product.idProduto,
      quantidade: 1
    }];

    const pedido = {
      nome: nome,
      endereco: endereco,
      cep: cep,
      estado: estado,
      complemento: complemento,
      metodopagamento: metodoPagamento,
      totalpedido: totalPedido,
      email: email,
      loja: {
        idLoja: parseInt(idLoja)
      },
      produtosPedido: produtosPedido
    };

    fetch('http://localhost:8080/pedidos', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(pedido)
    })
    .then(response => response.json())
    .then(data => {
      console.log('Pedido realizado com sucesso:', data);
      alert('Compra realizada com sucesso!');
      updateProductStock(product, idLoja);
      window.location.href = `../index.html?idLoja=${idLoja}`;
    })
    .catch(error => {
      console.error('Erro ao realizar o pedido:', error);
      alert('Erro ao realizar o pedido. Por favor, tente novamente.');
    });
  }

  function updateProductStock(product, idLoja) {
    const updatedProduct = {
      ...product,
      estoque: product.estoque - 1,
      idLojaTransient: idLoja
    };

    fetch(`http://localhost:8080/produtos/${product.idProduto}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(updatedProduct)
    })
    .then(response => response.json())
    .then(data => {
      console.log('Estoque atualizado com sucesso:', data);
    })
    .catch(error => {
      console.error('Erro ao atualizar o estoque:', error);
    });
  }

  function updateCartDisplay() {
    const urlParams = new URLSearchParams(window.location.search);
    const idProduto = urlParams.get('id_produto');
    fetch(`http://localhost:8080/produtos/${idProduto}`)
      .then(response => response.json())
      .then(data => {
        if (data) {
          document.getElementById('cart-items').innerHTML = `
            <li class="list-group-item d-flex justify-content-between lh-sm">
              <div>
                <h6 class="my-0">${data.nome}</h6>
                <small class="text-muted">${data.descricao}</small>
              </div>
              <span class="text-muted">R$${data.preco}</span>
            </li>
          `;
        }
      })
      .catch(error => console.error('Erro ao carregar o produto:', error));
  }

  updateCartDisplay();
});
