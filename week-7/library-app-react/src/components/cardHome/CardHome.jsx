function CardHome() {
  return (
    <a className="col justify-content-center" href="./detail.html">
      <div className="card h-100 rounded-4 card-book-list">
        <img
          // nanti get src nya ngehit api gambarnya
          src="../assets/cover-dilan.png"
          className="card-img-top"
          alt="..."
        />
        <div className="card-body">
          <h5 className="card-title text-center title-book">Dilan 1990</h5>
          <p className="card-text desc-title-book">
            This is a longer card with supporting text below as a natural
            lead-in to additional content. This content is a little bit longer.
            This is a longer card with supporting text below as a natural
            lead-in to additional content. This content is a little bit
            longer.This is a longer card with supporting text below as a natural
            lead-in to additional content. This content is a little bit longer.
          </p>
        </div>
      </div>
    </a>
  );
}

export default CardHome;
