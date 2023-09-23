import { fetchAPI } from "../configs/api";

const API_URL_PROD = import.meta.env.VITE_API_URL_DEV

//get all products
export const getProducts = async () =>{
  try {
    const url = API_URL_PROD;
    const response = await fetchAPI({url,method:'GET'});

    if(response.status !== 200) {
      const error = {
        status:true,
        message:"Error get Data"
      }
      return error
    }
    return response
  } catch (error) {
    console.log(error);
  }
}