
import React, { useState } from 'react';
import "./login.css"
import UserApi from '../services/UserApi';
import { useNavigate } from "react-router-dom";

// Kullanıcı giriş componenti
export default function Login() {
  const [email, setemail] = useState();
  const [password, setpassword] = useState();
  let userData={};
  let navigate = useNavigate();

  // Kullanıcı girişinin kontrol edilmesi ve yönlendirilmesi
  const loginControl = async (event) => {
    event.preventDefault();
      const response = await UserApi.userFindByEmail(email);
      console.log(response);
      userData=response.data[0];
      console.log(userData);
      if (response.status == 200) {
        if (userData.userPassword == password) {
          localStorage.setItem("id",userData.id);
          localStorage.setItem("userName", userData.userName);
          if (userData.userType == "Customer") {
            navigate("/Customer")
          }
          else {
            navigate("/Company")
          }
        }
        else {
          alert("Kullanıcı adı veya şifre yanlış");
        }
      }
    else{
      alert("Bağlantıda hata oluştu daha sonra tekrar deneyin..")
    }
  }

  return (
    <div>
      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3">
            <h2 className="text-center text-dark mt-5" >Login Cafe</h2>
            <div className="card my-5">
              <form className="card-body cardbody-color p-lg-5">
                <div className="text-center">
                  <img src="https://cdn.pixabay.com/photo/2016/03/31/19/56/avatar-1295397__340.png" className="img-fluid profile-image-pic img-thumbnail rounded-circle my-3" width="200px" alt="profile" />
                </div>
                <div className="mb-3">
                  <input type="text" className="form-control" id="Email" onChange={(e) => { setemail(e.target.value) }} aria-describedby="emailHelp" placeholder="E mail" />
                </div>
                <div className="mb-3">
                  <input type="password" className="form-control" id="password" onChange={(e) => { setpassword(e.target.value) }} placeholder="password" />
                </div>
                <div className="text-center"><button type="submit" className="btn btn-color px-5 mb-5 w-100" onClick={(e) => loginControl(e)} >Login</button></div>
                <div id="emailHelp" className="form-text text-center mb-5 text-dark">Kayıt ol.. <a href="/register" className="text-dark fw-bold"> Create an
                  Account</a>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>

  );
}
