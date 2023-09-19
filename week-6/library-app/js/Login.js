const loginBtn = document.querySelector(".login-btn");

loginBtn.addEventListener("click", (e) => {
  e.preventDefault();
  const email = document.querySelector("#email-input").value;
  const password = document.querySelector("#password-input").value;

  if (!email || !password) {
    alert("Please enter all required information");
    return;
  }

  const loginUser = () => {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const users = localStorage.getItem("users");
        const existingUsers = users ? JSON.parse(users) : [];
        const isUser = existingUsers.find(
          (user) => user.email === email && user.password === password
        );

        if (!isUser) {
          reject("Email or Password is wrong. Please try again!");
        } else{
          resolve("Login Success");
          localStorage.setItem("userLogin", JSON.stringify(isUser))
        }
      }, 2000);
    });
  };

  loginUser()
    .then((e) => {
      alert(e);
      window.location.href = "../pages/home.html";
    })
    .catch((err) => {
      alert(err);
    });
});
