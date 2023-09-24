import { Outlet } from "react-router-dom";
import AuthLayout from "../../layout/auth/AuthLayout";

function Login() {
  return (
    <AuthLayout>
      <Outlet />
    </AuthLayout>
  );
}

export default Login;
