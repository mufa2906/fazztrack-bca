import "./card.css"

function Card({imgProd, price, name}) {
  return (
    <div className="card-container">
      <div className="image">
        <img src={imgProd} alt="Card Image is Loading" />
        <p>{price}</p>
      </div>
      <div className="desc">
        <a href="#">
          <p>{name}</p>
        </a>
      </div>
    </div>
  )
}

export default Card