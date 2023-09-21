import { Link } from "react-router-dom";
import "./card.css";

function Card(props) {
  const { imgProd, price, name, id } = props;

  return (
    <div className="card-container">
      <div className="image">
        <img src={imgProd} alt="Card Image is Loading" />
        <p>{price}</p>
      </div>
      <div className="desc">
        <Link to={`products/${id}`}>
          <p>{name}</p>
        </Link>
      </div>
    </div>
  );
}

export default Card;
