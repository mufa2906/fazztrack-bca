const bookDetail = JSON.parse(localStorage.getItem("bookDetail"));
const title = document.getElementById("title-detail");
const imgUrl = document.getElementById("image-detail");
const description = document.getElementById("description-detail");
const imageHeroDetail = document.getElementById("image-hero-detail");

title.textContent = bookDetail.title;
description.textContent = bookDetail.description;
imgUrl.src = bookDetail.urlImage;
imageHeroDetail.style.backgroundImage = `url(${bookDetail.urlImage})`;

const savedBookDetail = document.getElementById("save-edit-detail-button");

savedBookDetail.addEventListener("click", () => {
  const urlImageBook =
    document.querySelector("#url-image").value != ""
      ? document.querySelector("#url-image").value
      : bookDetail.urlImage;
  let titleBook =
    document.querySelector("#title").value != ""
      ? document.querySelector("#title").value
      : bookDetail.title;
  const descriptionBook =
    document.querySelector("#description-book").value != ""
      ? document.querySelector("#description-book").value
      : bookDetail.description;

  const capitalize = (title) => {
    const array = title.split(" ");
    const textCapilatize = [];
    array.forEach((word) => {
      text = word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
      textCapilatize.push(text);
    });
    console.log(textCapilatize);
    return textCapilatize.join(" ");
  };
  titleBook = capitalize(titleBook);
  title.textContent = titleBook;

  const object = {
    urlImage: urlImageBook,
    title: titleBook,
    description: descriptionBook,
  };

  localStorage.setItem("bookDetail", JSON.stringify(object));

  description.textContent = descriptionBook;
  imgUrl.src = urlImageBook;
  imageHeroDetail.style.backgroundImage = `url(${urlImageBook})`;
});

const deleteModalBtn = document.querySelector("#deleteModalBtn");
const titleDelete = document.querySelector(".title-book-delete");
deleteModalBtn.addEventListener("click", () => {
  const bookDetail = JSON.parse(localStorage.getItem("bookDetail"));
  titleDelete.textContent = bookDetail.title;
});
