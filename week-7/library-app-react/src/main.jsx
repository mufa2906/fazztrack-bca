import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import LoginForm from "./components/loginForm/LoginForm.jsx";
import Auth from "./pages/auth/index.jsx";
import RegisForm from "./components/regisForm/RegisForm.jsx";
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min.js'
import './index.css'
import Home from "./pages/home/index.jsx";

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
    element: <Home />,
  }
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
