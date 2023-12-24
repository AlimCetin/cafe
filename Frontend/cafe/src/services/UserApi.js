/* eslint-disable import/no-anonymous-default-export */

// Axios
import axios from "axios";

// Persist Data Url
const PERSIST_URL = "http://localhost:8080/api/v1.0.0/users";

//Burada kullanıcılarının servis bağlantıları belirleniyor
class UserApi {
    // SEARCH  EMAIL
    //@GetMapping("/search")
    userFindByEmail(userEmail) {
        return  axios.get((`${PERSIST_URL}/search?userEmail=${userEmail}`));
    }
    // CREATE
    // @PostMapping("/create")
    userApiCreate(userDto) {
        return axios.post(`${PERSIST_URL}/create`, userDto, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(userDto),
        });
    }
} //end class

export default  new UserApi()
