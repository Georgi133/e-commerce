// import logo from './logo.svg';
import './App.css';
// import { RegularButton } from './Button/RegularButton';
// import { useTranslation } from "react-i18next";
import { Home } from './Home/Home';
import { Route, Routes } from "react-router-dom";
import { Navbar } from './Navbar/Navbar';

function App() {

  return (
    <>
      <Navbar/>
      <Routes>
        <Route path="/" element={<Home/>}/>
      </Routes>
    </>
  );
}

export default App;
