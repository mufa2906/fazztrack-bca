const BASEURL = "http://localhost:9090";

import { fetchApi } from "../configs/api";

export const getBooks = async () => {
  try {
    const url = `${BASEURL}/guest/books`;
    const response = await fetchApi({ url, method: "GET" });

    // validasi kalau status error bukan success
    if (response.status !== 200) {
      const error = {
        status: true,
        message: "Error get data!",
      };
      return error;
    }
    return response;
  } catch (error) {
    console.log(error);
  }
};

export const getBookById = async (id) => {
  try {
    const url = `${BASEURL}/books/${id}`;
    const response = await fetchApi({ url, method: "GET" });

    // validasi kalau status error bukan success
    if (response.status !== 200) {
      const error = {
        status: true,
        message: "Error get data!",
      };
      return error;
    }
    return response;
  } catch (error) {
    console.log(error);
  }
};
