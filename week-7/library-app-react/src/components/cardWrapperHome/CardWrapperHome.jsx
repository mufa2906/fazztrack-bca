import PropTypes from "prop-types";

function CardWrapperHome({ children }) {
  return (
    <>
      <section className="container-fluid p-4 d-flex flex-column gap-4">
        <div>
          <h2 className="fs-4 fw-bold text-list-book">List Book</h2>
        </div>
        <div
          className="row row-cols-1 row-cols-md-3 g-4"
          id="list-book-wrapper"
        >
          {children}
        </div>
      </section>
    </>
  );
}

CardWrapperHome.propTypes = {
  children: PropTypes.arrayOf(PropTypes.element),
};

export default CardWrapperHome;
