import React from 'react';
import {desarrollo} from '../constants/views';
import {Routes,Route} from "react-router-dom";
import Home from '../sections/views/HOME/Home';

const Content = () => {
  const [routes, setRoutes] = React.useState([]);

  React.useEffect(() => {
    setRoutes(desarrollo);
  }, []);

  return (
    <Routes>
      {routes.map((route, i) => <Route key={i} exact path={route.path} element={route.element} />)}
      <Route exact path={"/"} element={<Home/>} />
    </Routes>
  );
}

export default Content
