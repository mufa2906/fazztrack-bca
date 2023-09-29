import { Outlet } from "react-router-dom";
import AuthLayout from "../../layout/auth/AuthLayout";
import { Navigate } from "react-router-dom";

function Auth() {
  const token = localStorage.getItem("token");
  return token ? (
    <Navigate to="/home" />
  ) : (
    <AuthLayout>
      <Outlet />
    </AuthLayout>
  );
}

export default Auth;
