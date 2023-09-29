import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.min.js";
import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, Navigate, RouterProvider } from "react-router-dom";
import LoginForm from "./components/loginForm/LoginForm.jsx";
import RegisForm from "./components/regisForm/RegisForm.jsx";
import "./index.css";
import Auth from "./pages/auth/index.jsx";
import Detail from "./pages/detail/index.jsx";
import Home from "./pages/home/index.jsx";

const PrivateRoute = ({ element }) => {
  const token = localStorage.getItem("token"); // Ambil token dari local storage atau dari mana pun Anda menyimpannya

  // Periksa apakah pengguna memiliki token
  if (!token) {
    // Jika tidak ada token, kembalikan pengguna ke halaman utama atau halaman login
    return <Navigate to="/" />;
  }

  // Jika pengguna memiliki token, izinkan akses ke elemen yang diberikan
  return element;
};

const router = createBrowserRouter([
  {
    path: "/",
    element: <Auth />,
    children: [
      {
        path: "/",
        element: <LoginForm />,
      },
      {
        path: "/register",
        element: <RegisForm />,
      },
    ],
  },
  {
    path: "/home",
    element: <PrivateRoute element={<Home />} />,
  },
  {
    path: "/books/:bookId",
    element: <PrivateRoute element={<Detail />} />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
