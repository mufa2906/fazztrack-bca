import PropTypes from "prop-types";
import { Link } from "react-router-dom";
import './CardHome.css'
function CardHome({ id, image, title, description }) {
  return (
    <>
      <Link to={`../books/${id}`} className="col justify-content-center">
        <div className="card h-100 rounded-4 card-book-list"
        >
          <img
            // nanti get src nya ngehit api gambarnya
            src={image}
            className="card-img-top h-75"
            alt="..."
          />
          <div className="card-body h-25">
            <h5 className="card-title text-center title-book">{title}</h5>
            <p className="card-text desc-title-book">{description}</p>
          </div>
        </div>
      </Link>
    </>
  );
}

CardHome.propTypes = {
  id: PropTypes.string,
  image: PropTypes.string,
  title: PropTypes.string,
  description: PropTypes.string,
};

export default CardHome;
