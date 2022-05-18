import React, { Component } from "react";
import logo from "./logo.svg";
import "./App.css";
import MenuAppBar from "./shared/MenuAppBar";
import Content from "./shared/Content";
import {BrowserRouter}  from "react-router-dom";
import {desarrollo} from './constants/views';

const settings = ['Perfil', 'Actualizar Contraseña', 'Logout'];
const TITLE = "CALA";

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <div className="App">
          <header className="App-header">
            <img src={logo} className="App-logo" alt="logo" />
            <h1 className="App-title">Pensando en el futuro</h1>
          </header>
          <MenuAppBar pages={desarrollo} settings={settings} title={TITLE}/>        
          <Content/>
        </div>
      </BrowserRouter>
    );
  }
}

export default App;
