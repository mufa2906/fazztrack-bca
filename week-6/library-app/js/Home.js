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

dropdownAlltimes.addEventListener("click", () =>{
  menuDropdownAlltimes.style.position = "absolute";
  menuDropdownAlltimes.style.top = "100%";
  menuDropdownAlltimes.classList.toggle("show");
})
