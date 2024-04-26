function showLoginForm() {window.location.href = '/login';}

function showSignupForm() {window.location.href = '/signup';}

//этого еще нет
function logout() {
    alert('Logged out');
    document.getElementById('authButtons').style.display = 'block';
    document.getElementById('userButtons').style.display = 'none';
}
//этого нет: показать что я заказывала
function viewOrders() {alert('Viewing orders');}

function fetchProducts() {
    fetch('/api/products')
        .then(response => response.json())
        .then(products => {
            const container = document.getElementById('content');
            container.innerHTML = '';

            products.forEach(product => {
                const productElement = document.createElement('div');
                productElement.classList.add('product');

                /*Название*/
                const productName = document.createElement('h2');
                productName.textContent = product.title;

                /*Описание*/
                const productDescription = document.createElement('p');
                productDescription.textContent = product.description;

                /*Цена*/
                const productPrice = document.createElement('p');
                productPrice.textContent = 'Цена: ' + product.price;

                /* Добавляем изображение товара, если оно есть*/

                if (product.imageUrl) {
                    const productImage = document.createElement('img');
                    productImage.src = product.previewImageId;
                    productElement.appendChild(productImage);
                }

                productElement.appendChild(productName);
                productElement.appendChild(productDescription);
                productElement.appendChild(productPrice);
                container.appendChild(productElement);
            });
        })
        .catch(error => console.error('Error fetching products:', error));
}

window.onload = fetchProducts;