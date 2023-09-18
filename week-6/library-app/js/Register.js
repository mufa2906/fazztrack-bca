const signupBtn = document.querySelector(".signup-btn");

signupBtn.addEventListener("click", (e) => {
  e.preventDefault();
  const email = document.querySelector("#email-input").value;
  const password = document.querySelector("#password-input").value;
  const username = document.querySelector("#username-input").value;
  const fullname = document.querySelector("#fullname-input").value;

  if (!email || !password || !username || !fullname) {
    alert("Please enter all required information");
    return;
  }

  const users = localStorage.getItem("users");
  const existingUsers = users ? JSON.parse(users) : [];
  const isUser = existingUsers.find((user) => user.email === email);

  if (isUser) {
    alert("Email already registered. Please login!");
    return;
  }

  const newUser = {
    username: username,
    fullname: fullname,
    email: email,
    password: password,
  };

  const createUser = (newUser) => {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        existingUsers.push(newUser);

        const error = {
          status: 500,
          success: true,
          message: "Failed create user!",
        };

        if (!error.success) {
          reject(error.message);
        }

        resolve("Success create user!");
      }, 2000);
    });
  };

  createUser(newUser)
    .then((e) => {
      localStorage.setItem("users", JSON.stringify(existingUsers));
      alert(e);
    })
    .catch((err) => {
      alert(err);
    });
});
