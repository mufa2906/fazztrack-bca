const BASEURL = import.meta.env.VITE_API_URL_DEV;

import { fetchApi } from "../configs/api";

export const getBooks = async () => {
  try {
    const url = `${BASEURL}/guest/books?deleted=false`;
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

export const getBookById = async (id, token) => {
  try {
    const url = `${BASEURL}/books/${id}`;
    const response = await fetchApi({ url, method: "GET", token });

    // validasi kalau status error bukan success
    // if (response.status !== 200) {
    //   const error = {
    //     status: true,
    //     message: "Error get data!",
    //   };
    //   return error;
    // }
    return response;
  } catch (error) {
    console.log(error);
  }
};

export const createBook = async (data, token) => {
  try {
    const url = `${BASEURL}/admin/books`;
    const response = await fetchApi({ url, method: "POST", data, token });
    return response;
  } catch (error) {
    console.log(error);
  }
};

export const updateBook = async (data, id, token) => {
  try {
    const url = `${BASEURL}/admin/books/${id}`;
    const response = await fetchApi({ url, method: "PUT", data, token });
    return response;
  } catch (error) {
    console.log(error);
  }
};

export const removeBook = async (id,token) => {
  try {
    const url = `${BASEURL}/admin/books/${id}`;
    const response = await fetchApi({ url, method: "DELETE",token });
    return response;
  } catch (error) {
    console.log(error);
  }
};
