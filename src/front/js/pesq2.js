window.onload = () => {
    const urlParams = new URLSearchParams(window.location.search);
    const searchTerm = urlParams.get('search');
    const content = decodeURIComponent(searchTerm).toLowerCase();
    if (searchTerm) {
       showcards(content);
    } else {
        alert('Nenhum Item foi encontrado');
        window.location.href='index.html';
    }
};

const showcards = (content) =>
{
    const cardContainer = document.getElementById('card-container')
    cardContainer.innerHTML = ''; //limapa os cards anteriores

    fetch('http://localhost:8080/produtos')
    .then(response => response.json())
    .then(data =>
    {
        data = data.filter(element => element.nome.toLowerCase() === content);
        if (data.length === 0) {
            alert('Nenhum produto encontrado');
            window.location.href = 'index.html';
            return;
        }
        data.forEach(item => 
        {
            const card = document.createElement('div');
            card.classList.add('cards');
            card.innerHTML =`<img src="${item.foto}" height="150" width="200">
            <h1>${item.nome}</h1>
            <p>${item.preco}</p>`;
            cardContainer.appendChild(card);
        });
    })
}
const checkboxes = document.querySelectorAll('.filter-checkbox');
const cardContainer = document.getElementById('card-container');

checkboxes.forEach(checkbox => {
    checkbox.addEventListener('change', () => {
        cardContainer.innerHTML = ''; // Limpa os cartões anteriores

        const checkedCheckboxes = Array.from(checkboxes).filter(cb => cb.checked);
        
        fetch('http://localhost:8080/produtos')
            .then(response => response.json())
            .then(data => {
                // Aplica todos os filtros de uma vez
                const filteredData = data.filter(item =>
                    checkedCheckboxes.every(cb =>
                        item.categoria.toLowerCase() === cb.value.toLowerCase()
                    )
                );

                if (filteredData.length === 0) {
                    alert('Nenhum produto encontrado');
                } else {
                    filteredData.forEach(item => {
                        const card = document.createElement('div');
                        card.classList.add('cards');
                        card.innerHTML = `<img src="${item.foto}" height="150" width="200">
                                          <h1>${item.nome}</h1>
                                          <p>${item.preco}</p>`;
                        cardContainer.appendChild(card);
                    });
                }
            })
            .catch(error => {
                console.error('Erro ao buscar dados:', error);
                // Tratar o erro de busca de dados, se necessário
            });
    });
});

