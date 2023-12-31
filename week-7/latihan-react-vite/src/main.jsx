import React from "react";
import ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";
import App from "./App.jsx";
import DetailProd from "./pages/detailProd";
import Home from "./pages/home";
import AddProd from "./pages/addProd/index.jsx";
// import './index.css'

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    // loader: rootLoader,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "products/:productId",
        element: <DetailProd />,
      },
      {
        path: "add",
        element: <AddProd />,
      },
    ],
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
