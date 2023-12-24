import React, { useState } from 'react'
import './register.css'
import { useNavigate } from 'react-router-dom';
import UserApi from '../services/UserApi';

// Kullanıcı kayıt componenti
export default function Register() {

    const navigate = useNavigate();
    const [email, setemail] = useState();
    const [password, setpassword] = useState();
    const [userName, setUserName] = useState();
    const [userType, setUserType] = useState();

//////////////////////////////////////////////////////////////////////////////
//Girilen değerlerin değişkenlere atanması
    const emailOnChange = (event) => {
        setemail(event.target.value);
    }
    const passwordOnChange = (event) => {
        setpassword(event.target.value);
    }
    const userNameOnChange = (event) => {
        setUserName(event.target.value);
    }
    const userTypeOnClick = (event) => {
        setUserType(event.target.value);
    }
/////////////////////////////////////////////////////////////////////////////
//Kullanıcı kayıtı 
    const registerOnClick = async (event) => {
        const userCreateObject = {
            "userName": userName,
            "userEmail": email,
            "userPassword": password,
            "userType": userType
        }
        try {
            const response = await UserApi.userApiCreate(userCreateObject);
            if (response.status == 200) {
                alert("Bilginiz kaydedildi.");
                navigate("/login");

            }
        } catch (err) {
            console.error(err);
            alert("Bağlantıda hata oluştu daha sonra tekrar deneyin..")
        }
    }

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3">
                    <h2 className="text-center text-dark mt-5">Register Cafe</h2>
                    <div className="card my-5">
                        <form className="card-body cardbody-color p-lg-5">
                            <div className="mb-3">
                                <input type="text" className="form-control" id="userName" onChange={userNameOnChange} aria-describedby="emailHelp" placeholder="Name" />
                            </div>
                            <div className="mb-3">
                                <input type="text" className="form-control" id="email" onChange={emailOnChange} aria-describedby="emailHelp" placeholder="E mail" />
                            </div>
                            <div className="mb-3">
                                <input type="password" className="form-control" id="password" onChange={passwordOnChange} placeholder="password" />
                            </div>
                            <div className="mb-3">
                                <select className="form-select" onClick={userTypeOnClick} aria-label="Default select example">
                                    <option selected="">Kullanıcının Türü</option>
                                    <option value={"Customer"}>Customer</option>
                                    <option value={"Company"}>Company</option>
                                </select>
                            </div>
                            <div className="text-center"><button type="submit" className="btn btn-color px-5 mb-5 w-100" onClick={()=>registerOnClick}>Register</button></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

