import axios from "axios";
import { useEffect, useState } from "react";
import Card from "../../components/card/Card";
import "./home.css";

const Home = () => {
  const [products, setProducts] = useState([]);

  const getData = async () => {
    try {
      const response = await axios.get(
        "https://hplussport.com/api/products"
      );
      console.log(response.data);
      setProducts(response.data);
    } catch (error) {}
  };

  useEffect(() => {
    getData();
  }, []);

  return (
    <div className="container">
      {/* navbar */}
      {/* <Navbar /> */}
      {/* main */}
      <main>
        <section className="header">
          <h2>Products</h2>
          <div className="input">
            <input type="text" name="search" id="search" />
          </div>
        </section>
        <section className="prod">
          {/* Card */}
          {/* <Card
            imgProd={
              "https://plus.unsplash.com/premium_photo-1694124534101-444a039aee89?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1632&q=80"
            }
            price={`Rp ${20000}`}
            name={"Bawang putih"}
          /> */}

          {products ? (products.map((product) => {
            return (
              <Card
                key={product.id}
                id={product.id}
                imgProd={product.image}
                price={product.price}
                name={product.name}
              />
            );
          })) : <h1>No Data</h1>
          }
        </section>
      </main>
    </div>
  );
};

export default Home;
