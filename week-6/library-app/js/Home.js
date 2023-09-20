const userFullname = document.querySelector("#user-fullname");

const user = JSON.parse(localStorage.getItem("userLogin"));
userFullname.textContent = user.fullname;

const logoutBtn = document.querySelector(".logout-btn");
logoutBtn.addEventListener("click", () => {
  localStorage.removeItem("userLogin");
});

//bawaan bootstrap ager tidak ke parentnya
const sidebarClose = document.querySelector(".sidebar-close");
sidebarClose.addEventListener("click", (event) => {
  event.stopPropagation();
});

//sidebar dom manipulation
const collapseClose = document.querySelector("#collapseClose");
const collapseOpen = document.querySelector("#collapseOpen");
collapseClose.style.cursor = "pointer";

collapseClose.addEventListener("click", () => {
  collapseOpen.classList.toggle("collapse");
});

//dropdown
const dropdownAlltimes = document.querySelector("#dropdown-alltimes");
const menuDropdownAlltimes = document.querySelector("#menu-dropdown-alltimes");

dropdownAlltimes.addEventListener("click", () => {
  menuDropdownAlltimes.style.position = "absolute";
  menuDropdownAlltimes.style.top = "100%";
  menuDropdownAlltimes.classList.toggle("show");
});

//modal
const addBookBtn = document.querySelector("#add-book-btn");
const addBookModal = document.querySelector("#addBookModal");
addBookModal.style.zIndex = "1060";

//modal backdrop
const modalBackdrop = document.createElement("div");
modalBackdrop.classList.add("modal-backdrop", "hide");
modalBackdrop.style.opacity = 0.5;

document.body.appendChild(modalBackdrop);

addBookBtn.addEventListener("click", () => {
  addBookModal.classList.toggle("show");
  modalBackdrop.classList.toggle("hide");
});

const buttonCloseModal = document.querySelector("#button-close");
buttonCloseModal.addEventListener("click", () => {
  addBookModal.classList.toggle("show");
  modalBackdrop.classList.toggle("hide");
});

//add Book to List
const saveAddBookBtn = document.querySelector("#save-add-book-home-button");
const listBookWrapper = document.querySelector("#list-book-wrapper");

saveAddBookBtn.addEventListener("click", () => {
  const urlImageBook = document.querySelector("#url-image").value;
  const titleBook = document.querySelector("#title").value;
  const descriptionBook = document.querySelector("#description-book").value;

  if (!urlImageBook || !titleBook || !descriptionBook) {
    alert("Please enter all required information");
    return;
  }

  const capitalize = (title) => {
    const array = title.split(" ");
    const textCapilatize = [];
    array.forEach((word) => {
      text = word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
      textCapilatize.push(text);
    });
    console.log(textCapilatize);
    return textCapilatize.join(" ");
  };

  title = capitalize(titleBook);

  const newBook = document.createElement("a");
  newBook.classList.add("col", "justify-content-center");
  newBook.href = "./detail2.html";
  newBook.innerHTML = `
                <div class="card h-100 rounded-4 card-book-list">
                  <img
                    src="../assets/${urlImageBook}"
                    class="card-img-top"
                    alt="..."
                  />
                  <div class="card-body">
                    <h5 class="card-title text-center title-book">
                      ${title}
                    </h5>
                    <p class="card-text desc-title-book">
                      ${descriptionBook}
                    </p>
                  </div>
                </div>
  `;
  listBookWrapper.appendChild(newBook);

  const object = {
    urlImage: `../assets/${urlImageBook}`,
    title: title,
    description: descriptionBook,
  };

  localStorage.setItem("bookDetail", JSON.stringify(object));
  addBookModal.classList.toggle("show");
  modalBackdrop.classList.toggle("hide");
});
