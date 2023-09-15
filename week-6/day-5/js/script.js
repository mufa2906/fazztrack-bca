const title = document.getElementsByClassName("title")[0];
const btnChange = document.querySelector(".btn-change");

btnChange.addEventListener("click", (e) => {
  e.preventDefault();
  title.style.color = "yellow";
  title.classList.toggle("hidden");
});

const email = document.querySelector("#email");
const password = document.querySelector("#password");
const nameText = document.querySelector(".name-text");
const titleText = document.querySelector(".title-text");

const btnLogin = document.querySelector(".btn-login");

btnLogin.addEventListener("click", (e) => {
  e.preventDefault;
  alert(`email ${email.value}, password ${password.value}`);
  // window.location.href = "https://fazztrack-bca.vercel.app/week-6/library-app/pages/home.html"
  fetch("https://jsonplaceholder.typicode.com/users/")
    .then((response) => response.json())
    .then((json) => getUsers(json));
});

getUsers = (data) => {
  output = "";
  for (let i = 0; i < data.length; i++) {
    const element = data[i];
    console.log(element);

    output += `<div>`;
    for (key in element) {
        output += `
            <p>${key}</p>
            <p>${element[key]}</p>
        `;
    };
    output += `</div>`;
  }
  const card = document.querySelector(".card");
  card.innerHTML = output;
};
