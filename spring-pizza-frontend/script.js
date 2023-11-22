const baseUrl = "http://localhost:8080/api/v1/pizze";
const root = document.getElementById("root");

const renderIngredients = (ingredients) => {
  let content;
  if (ingredients.length === 0) {
    content = "N.I.";
  } else {
    content = '<ul class="list-unstyled">';
    ingredients.forEach((cat) => {
      content += `<li>${cat.name}</li>`;
    });
    content += "</ul>";
  }
  return content;
};

const renderPizza = (element) => {
  return `
    <div class="card h-100" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">${element.name}</h5>
            <p class="card-text">${element.description}</p>
        </div>
        <ul class="list-group list-group-flush">
            <li class="list-group-item">${element.price} €</li>
            <li class="list-group-item">${renderIngredients(
              element.ingredients
            )}</li>
        </ul>
    </div>`;
};

const renderPizzaList = (data) => {
  let content;
  if (data.length > 0) {
    content = '<div class="row">';
    data.forEach((element) => {
      content += '<div class="col-3 pt-5">';
      content += renderPizza(element);
      content += "</div>";
    });
    content += "</div>";
  } else {
    content = '<div class="alert alert-info">La lista è vuota</div>';
  }
  // sostituisco il contenuto di root con il mio content
  root.innerHTML = content;
};

const getPizza = async () => {
  try {
    const response = await axios.get(baseUrl);
    renderPizzaList(response.data);
  } catch (error) {
    console.log(error);
  }
};

getPizza();
