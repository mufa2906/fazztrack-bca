import { Link } from "react-router-dom";

function CarouselHome() {
  return (
    <>
      <Link
        className="cover-book carousel-cell rounded-4"
        id="cover-ubur-ubur-lembur"
      >
        <div className="h-100 d-flex flex-column">
          <div className="h-50"></div>
          <div className="desc-book d-flex flex-column justify-content-end p-4 container-fluid h-50 rounded-bottom-4">
            <h2 className="text-white">Ubur Ubur Lembur</h2>
            <h6 className="text-white">Raditya Dika</h6>
          </div>
        </div>
      </Link>
      <div className="cover-book carousel-cell rounded-4" id="cover-laskar-pelangi">
        <div className="h-100 d-flex flex-column">
          <div className="h-50"></div>
          <div className="desc-book d-flex flex-column justify-content-end p-4 container-fluid h-50 rounded-bottom-4">
            <h2 className="text-white">Laskar Pelangi</h2>
            <h6 className="text-white">Andrea Hirata</h6>
          </div>
        </div>
      </div>
      <div className="cover-book carousel-cell rounded-4" id="cover-dilan">
        <div className="h-100 d-flex flex-column">
          <div className="h-50"></div>
          <div className="desc-book d-flex flex-column justify-content-end p-4 container-fluid h-50 rounded-bottom-4">
            <h2 className="text-white">Dilan 1990</h2>
            <h6 className="text-white">Pidi Baiq</h6>
          </div>
        </div>
      </div>
    </>
  );
}

export default CarouselHome;
