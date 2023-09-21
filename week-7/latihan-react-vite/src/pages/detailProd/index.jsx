import axios from "axios";
import { useEffect } from "react";
import { useParams } from "react-router-dom";
import "./detailProd.css";
import { useState } from "react";

function DetailProd() {
  const { productId } = useParams();
  const [product, setProduct] = useState({});

  const getProductById = async () => {
    try {
      const response = await axios.get(
        `https://hplussport.com/api/products?id=${productId}`
      );
      setProduct(response.data[0])
    } catch (error) {}
  };

  useEffect(() => {
    getProductById();
  }),
    [];

  return (
    <div className="detail-container">
      <div className="detail-img">
        <img src={product.image} alt="" />
      </div>
      <div className="detail-price">{product.price}</div>
      <div className="detail-name">{product.name}</div>
      <div className="detail-desc">{product.description}</div>
    </div>
  );
}

export default DetailProd;
