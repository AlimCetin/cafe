/* eslint-disable import/no-anonymous-default-export */

// Axios
import axios from "axios";

// Persist Data Url
const PERSIST_URL = "http://localhost:8080/api/v1.0.0/companys";

class CompanyApi {
    // SEARCH  NAME
    //@GetMapping("/search")
    companyFindBycompanyId(companyId) {
        return axios.get((`${PERSIST_URL}/search?id=${companyId}`));
    }

    ///////////////////////////////////////////////////////////////////////////
    // CREATE
    // @PostMapping("/create")
    companyFoodCreate(companyDto) {
        return axios.post(`${PERSIST_URL}/create`, companyDto, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(companyDto),
        })
    }
///////////////////////////////////////////////////////////////////////////
    // UPDATE
    // @PutMapping(value = "/update/{id}")
    companyFoodUpdate(id, companyDto) {
        return axios.put(`${PERSIST_URL}/update/${id}`, companyDto)
    }
 ///////////////////////////////////////////////////////////////////////////
    // DELETE BY ID
    // @DeleteMapping("/delete/{id}")
    companyFoodDeleteById(id) {
        return axios.delete(`${PERSIST_URL}/delete/${id}`)
    }
} //end class

export default  new CompanyApi()
