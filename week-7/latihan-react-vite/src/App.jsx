// import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { Outlet } from "react-router-dom";
import Navbar from "./components/navbar/Navbar";

// export async function loader() {
//   const card = await getCard();
//   return { card };
// }

function App() {
  // const {card} = useLoaderData();
  return (
    <>
      <Navbar />
      {/* routing tapi cuma render yang diperlukan, misal navbar kan semua web sama ga perlu diubah */}
      <div className="app">
        <Outlet />
      </div>
    </>
  );
}

export default App;
