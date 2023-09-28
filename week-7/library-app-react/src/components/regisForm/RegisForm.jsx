import logo from "../../assets/images/bookshelf.png";
import { Link } from "react-router-dom";
import "./RegisForm.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import {registerUser} from "../../services/auth"

function RegisForm() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [fullname, setFullname] = useState("");
  const [username, setUsername] = useState("");

  const navigate = useNavigate();
  const userRegis = async (e) => {
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
      if (username == "") {
        alert("Please enter your username");
        return;
      }
      if (fullname == "") {
        alert("Please enter your fullname");
        return;
      }

      const data = {
        email,
        password,
        username,
        fullname,
      };
      console.log(data);
      const res = await registerUser(data);
      // localStorage.setItem("token", res.data.data?.token);
      // localStorage.setItem("fullname", res.data.data?.fullname);
      // console.log(res);
      alert(res.data.message);
      if (res.data.status == 201) {
        navigate("/");
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
          <h1>Register</h1>
          <p>Welcome Back, Please Register to create account</p>
        </section>
        <section className="form-input-sect">
          <div className="form-input">
            {/* <label for="username-input">Username</label> */}
            <input
              type="text"
              name="username-input"
              id="username-input"
              placeholder="Enter your username"
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>
          <div className="form-input">
            {/* <label for="fullname-input">Full name</label> */}
            <input
              type="text"
              name="fullname-input"
              id="fullname-input"
              placeholder="Enter your full name"
              onChange={(e) => setFullname(e.target.value)}
            />
          </div>
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
        <section className="form-button-sect">
          <Link className="signup-btn" id="signup-btn-register" onClick={userRegis} >
            Sign up
          </Link>
          <Link to="/" className="login-btn" id="login-btn-register">
            Login
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

export default RegisForm;
