import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import logo from "../../assets/images/bookshelf.png";
import { loginUser } from "../../services/auth";
import "./LoginForm.css";

function LoginForm() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const navigate = useNavigate();

  const userLogin = async (e) => {
    try {
      e.preventDefault();

      if (email == "") {
        alert("Please enter your email");
        return;
      }
      if (password == "") {
        alert("Please enter your password");
        return;
      }

      const data = {
        email,
        password,
      };
      console.log(data);
      const res = await loginUser(data);

      console.log(res);
      alert(res.data.message);
      if (res.data.status == 200) {
        localStorage.setItem("token", res.data.data?.token);
        localStorage.setItem("fullname", res.data.data?.fullname);
        localStorage.setItem("roles", res.data.data?.roles[0].name);
        navigate("./home");
      }
    } catch (error) {
      console.log(error);
    }
  };

  return (
    <>
      <section className="form-container">
        <header>
          <img className="logo-image" src={logo} alt="dannnnn" />
        </header>
        <section className="form-desc-sect">
          <h1>Login</h1>
          <p>Welcome Back, Please Login to your account</p>
        </section>
        <section className="form-input-sect">
          <div className="form-input">
            {/* <label for="email-input">Email Address</label> */}
            <input
              type="email"
              name="email-input"
              id="email-input"
              placeholder="Enter your email address"
              onChange={(e) => setEmail(e.target.value)}
            />
          </div>
          <div className="form-input">
            {/* <label for="password-input">Password</label> */}
            <input
              type="password"
              name="password-input"
              id="password-input"
              placeholder="Enter your password"
              onChange={(e) => setPassword(e.target.value)}
            />
          </div>
        </section>
        <section className="form-addon-sect">
          <div>
            <input type="checkbox" name="remember-me" id="remember-me" />
            {/* <label for="remember-me">Remember me</label> */}
          </div>
          <a href="" id="forgot-password">
            Forgot Password?
          </a>
        </section>
        <section className="form-button-sect">
          <Link className="login-btn" id="login-btn-login" onClick={userLogin}>
            Login
          </Link>
          <Link to="./register" className="signup-btn" id="signup-btn-login">
            Sign up
          </Link>
        </section>
        <footer>
          <p>
            By signing up, you agree to Book’s
            <span>Terms and Conditions</span> & <span>Privacy Policy</span>
          </p>
        </footer>
      </section>
    </>
  );
}

export default LoginForm;
