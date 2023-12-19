import React, { useState } from 'react'
import Header from './Header.jsx'
import Footer from "./Footer.jsx";
import { Navigate, Route, Routes } from "react-router-dom";
import CustomerApi from '../services/CustomerApi.js';
import { useEffect } from 'react';

export default function Customer() {
 
  const [apiListData, setApiListData] = useState([]);
  const [userIdUp, setUserIdUp] = useState();
  const [userNameUp, setUserNameUp] = useState('');
  const [userKiloUp, setUserKiloUp] = useState();
  const [userHeightUp, setUserHeightUp] = useState();

  /////////////////////////////////////////////////
  // EFFECT
  useEffect(() => {
    fetchRegisterList();
  }, []);

/////////////////////////////////////////////////
  // Function
  //Geçmiş data bilgileri getiriyor ve apiListData ya aktarıyor.
  const fetchRegisterList = async () => {
    try {
      const response = await CustomerApi.customerFindBycustomerId(localStorage.getItem("id"))
      setApiListData(response.data);

    } catch (error) {
      console.error('Error fetching users:', error);
    }
  };
  
  //Tablo da seçtiği datayı database de siliyor.
  const userDeteleId = async (id) => {
    try {
      const response = await CustomerApi.customerDeleteById(id);
      if (response.status == 200) {
        alert("Silindi ");
        window.location.reload();
      }

    }
    catch (error) {
      console.error('Error fetching users:', error);
    }
  }
 
  return (
    <div>
      {/* HEADER */}
      <div>
        <Header />
      </div>
      <div className="row app">
        <div className="col col-6">

          <div>
            <h1>Geçmiş bilgilerin listesi</h1>
            {/* Table */}
            <table className='table table-striped table-hover  '>
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Food list</th>
                  <th>Company</th>
                  <th>Tarih</th>
                  <th>Sil</th>
                </tr>
              </thead>
              <tbody>
                {
                  // Gelen verileri listeliyor.
                  apiListData.map((data) =>
                    <tr key={data.id}>
                      <td>{data.id}</td>
                      <td>{data.foodList}</td>
                      <td>{data.company}</td>
                      <td>{data.systemDate}</td>
                      <td>
                        <i type="button" onClick={() => userDeteleId(data.id)} className="fa-solid fa-trash text-danger"></i>
                      </td>
                    </tr>
                  )
                }
              </tbody>
            </table>
            <br />
          </div>
        </div>
      </div>
      {/* FOOTER */}
      <Footer></Footer></div>
  )
}
