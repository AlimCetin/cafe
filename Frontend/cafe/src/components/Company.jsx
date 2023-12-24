
// rfce
import React, { useEffect, useState } from 'react';
import CompanyApi from '../services/CompanyApi';
import Header from './Header.jsx'
import Footer from "./Footer.jsx";
// localStorage.setItem("id", 2);
function Company() {

    //Const
    const [apiListData, setApiListData] = useState([]);
    const [userIdUp, setUserIdUp] = useState();
    const [foodUp, setFoodUp] = useState('');
    const [priceUp, setPriceUp] = useState();

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
            const response = await CompanyApi.companyFindBycompanyId(localStorage.getItem("id"))
            setApiListData(response.data);
            console.log(apiListData);
        } catch (error) {
            console.error('Error fetching users:', error);
        }
    };
    // OnChange
    //Güncellenecek bilgilerin deişkenleri
    //Girilen bilgileri değişkenlere set ediliyor. 
    //userNameUp 
    const userFoodOnChange = (event) => {
        setFoodUp(event.target.value);
    }
    //userKiloUp
    const userPriceOnChange = (event) => {
        setPriceUp(event.target.value);
    }

    //Kullanıcının güncellediği verileri database de güncelliyor
    const userUpdate = async () => {
        //Gönderilecek obje
        const userUpObject = {
            "food": foodUp,
            "price": priceUp,

        }
        try {
            const response = await CompanyApi.companyFoodUpdate(userIdUp, userUpObject);
            if (response.status == 200) {
                alert("Güncellendi ");
                //Sayfa yenileniyor 
                window.location.reload();
            }
        }
        catch (error) {
            console.error('Error fetching users:', error);
        }

    }
    const userCreate = async () => {
        //Gönderilecek obje
        const userUpObject = {
            "companyId": localStorage.getItem("id"),
            "food": foodUp,
            "price": priceUp
        }
        try {
            const response = await CompanyApi.companyFoodCreate(userUpObject);
            if (response.status == 200) {
                alert("Eklendi ");
                //Sayfa yenileniyor 
                window.location.reload();
            }
        }
        catch (error) {
            console.error('Error fetching users:', error);
        }

    }
    //Tablo da seçtiği datayı database de siliyor.
    const userDeteleId = async (id) => {
        try {
            const response = await CompanyApi.companyFoodDeleteById(id);
            if (response.status == 200) {
                alert("Silindi ");
                window.location.reload();
            }

        }
        catch (error) {
            console.error('Error fetching users:', error);
        }

    }
    //Tablo da güncellemek için seçtiği verilerin bilgisini  modala taşıyor. 
    const userUpdateControl = (id) => {
        setUserIdUp(id);
        apiListData.map((data) => {
            setFoodUp(data.food);
            setPriceUp(data.price);
        })
    }
    // RETURN
    return (
        <div>
            {/* HEADER */}
            <div>
                <Header />
            </div>
            <div className="row app mt-5">
                <div className="col col-6"><div>
                    <h1>Yemek  listesi</h1>
                    {/* Table */}
                    <table className='table table-striped table-hover  '>
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Food</th>
                                <th>Price</th>
                                <th>Tarih</th>
                                <th>Güncelle</th>
                                <th>Sil</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                // Gelen verileri listeliyor.
                                apiListData.map((data) =>
                                    <tr key={data.id}>
                                        <td>{data.id}</td>
                                        <td>{data.food}</td>
                                        <td>{data.price}</td>
                                        <td>{data.systemDate}</td>
                                        <td>

                                            <i type="button" onClick={() => userUpdateControl(data.id)} className="fa-solid fa-pencil text-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"></i>
                                        </td>
                                        <td>
                                            <i type="button" onClick={() => userDeteleId(data.id)} className="fa-solid fa-trash text-danger"></i>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <br />
                    <button
                        type="button"
                        className="btn btn-secondary"
                        data-bs-toggle="modal" data-bs-target="#ekleModal">

                        Ekle
                    </button>
                    {/* ////////////////////////////////////////////// */}
                    {/* Modal  */}
                    <div
                        className="modal fade"
                        id="exampleModal"
                        tabIndex={-1}
                        aria-labelledby="exampleModalLabel"
                        aria-hidden="true"
                    >
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLabel">
                                        Güncellemek istediğiniz  bilgileri giriniz
                                    </h5>
                                    <button
                                        type="button"
                                        className="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close"
                                    />
                                </div>
                                <div className="modal-body">
                                    <div className="d-grid gap-4">
                                        {/* Name */}
                                        <div className=""><label htmlFor="userUpName"> Food: </label>
                                            <input
                                                type="text"
                                                id="userUpName"
                                                //  placeholder={apiFindByIdData.uname}
                                                onChange={userFoodOnChange}
                                                value={foodUp}
                                            />
                                        </div>

                                        {/* Kilo */}
                                        <div className=""><label htmlFor="userUpKilo">Price :</label>
                                            <input
                                                type="text"
                                                id="userUpKilo"
                                                //placeholder={apiFindByIdData.ukilo}
                                                onChange={userPriceOnChange}
                                                value={priceUp}
                                            />

                                        </div>
                                    </div>
                                </div>
                                {/* Buttons */}
                                <div className="modal-footer">
                                    <button
                                        type="button"
                                        className="btn btn-secondary"
                                        data-bs-dismiss="modal"
                                    >
                                        Kapat
                                    </button>
                                    <button type="button" className="btn btn-primary" onClick={() => userUpdate()} data-bs-dismiss="modal">
                                        Güncelle
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                    {/* ////////////////////////////////////////////// */}
                    {/* Modal  */}
                    <div
                        className="modal fade"
                        id="ekleModal"
                        tabIndex={-1}
                        aria-labelledby="exampleModalLabel"
                        aria-hidden="true"
                    >
                        <div className="modal-dialog">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLabel">
                                        Eklemek istediğiniz  bilgileri giriniz
                                    </h5>
                                    <button
                                        type="button"
                                        className="btn-close"
                                        data-bs-dismiss="modal"
                                        aria-label="Close"
                                    />
                                </div>
                                <div className="modal-body">
                                    <div className="d-grid gap-4">
                                        {/* Name */}
                                        <div className=""><label htmlFor="userUpName"> Food: </label>
                                            <input
                                                type="text"
                                                id="userUpName"
                                                //  placeholder={apiFindByIdData.uname}
                                                onChange={userFoodOnChange}
                                                value={foodUp}
                                            />
                                        </div>

                                        {/* Kilo */}
                                        <div className=""><label htmlFor="userUpKilo">Price :</label>
                                            <input
                                                type="text"
                                                id="userUpKilo"
                                                //placeholder={apiFindByIdData.ukilo}
                                                onChange={userPriceOnChange}
                                                value={priceUp}
                                            />

                                        </div>
                                    </div>
                                </div>
                                {/* Buttons */}
                                <div className="modal-footer">
                                    <button
                                        type="button"
                                        className="btn btn-secondary"
                                        data-bs-dismiss="modal"
                                    >
                                        Kapat
                                    </button>
                                    <button type="button" className="btn btn-primary" onClick={() => userCreate()} data-bs-dismiss="modal">
                                        Ekle
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </div>
            </div>
            {/* FOOTER */}
            <Footer></Footer></div>
    )
}

export default Company;
