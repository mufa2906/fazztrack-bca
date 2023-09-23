import axios from "axios";

export const fetchAPI = async (url,method,data) =>{
  try {
    const responseAxios = await axios({
      url,
      method,
      data
    })
    return responseAxios
  } catch (error) {
    console.log(error.response);
  }
}