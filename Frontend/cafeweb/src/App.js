import "./App.css";
import { Navigate, Route, Routes } from "react-router-dom";
import Login from "./components/Login.jsx";
import  Register from './components/Register.jsx'
import Customer from './components/Customer';
import Company from './components/Company'

function App() {
  return (
    <div className="App">
         <Routes>
            <Route  path="/login" element={<Login/>} />
             <Route path={"/register"} element={<Register/>} /> 
             <Route path={"/customer"} element={<Customer/>} /> 
             <Route path={"/company"} element={<Company/>} /> 
            <Route path={"*"} element={<Navigate to={"/"} />} />
        </Routes>
    </div>
  );
}

export default App;