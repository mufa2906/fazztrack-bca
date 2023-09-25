import { Outlet } from "react-router-dom";
import AuthLayout from "../../layout/auth/AuthLayout";

function Auth() {
  return (
    <AuthLayout>
      <Outlet />
    </AuthLayout>
  );
}

export default Auth;
