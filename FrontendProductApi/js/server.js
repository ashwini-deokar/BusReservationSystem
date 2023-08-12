document.getElementById("btnProducts").addEventListener("click", getProducts);
const getProductURL = "http://localhost:8080/products";
function getProducts() {
    console.log("btn click for getting product");
    fetch(getProductURL).then((response) => {
        if (!response.ok) {
            throw Error(response.statusText);
        }
        return response.json();
    }).then((data) => {
        let output = document.getElementById("allProducts");

        data.forEach(element => {

            output.innerHTML += `
            <div>PRODUCT ID:: ${element.productId}</div>
            <div>PRODUCT NAME:: ${element.productName}</div>
            <div>PRODUCT QUANTITY:: ${element.productquantity}</div>
            <div>PRODUCT PRICE:: ${element.productPrice}</div></br></br>
            `;

        });
    }).catch((error) => {
        console.log(error);
    })
}


document.getElementById("post-product").addEventListener("submit", productFormSubmit);
function productFormSubmit(event) {
    event.preventDefault();
    const form = event.currentTarget;
    const url = form.action;
    const productObj = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",

        },
        body: JSON.stringify(Object.fromEntries(new FormData(form).entries()))
    };
    fetch(url, productObj).then((response) => {
        if (!response.ok) {
            throw Error(response.statusText);
        }
        return response.json();

    }).then((data) => {

        console.log(data);
    }).catch((error) => {
        console.log(error);
    })
}
