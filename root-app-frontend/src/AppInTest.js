import React, { useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Home from './components/Home';
import Login from './components/Login';
import Register from './components/Register';

import AddSeed from "./components/Seeds/AddSeed";
import ViewSeed from "./components/Seeds/ViewSeed";
import AddPlant from "./components/Plants/AddPlant";
import ViewPlant from "./components/Plants/ViewPlant";
import AddSoil from "./components/Soils/AddSoil";
import ViewSoil from "./components/Soils/ViewSoil";
import AddGarden from "./components/Gardens/AddGarden";
import ViewGarden from "./components/Gardens/ViewGarden";
import Login from "./components/Login";
import Register from "./components/Register";
import AddJournal from "./components/Journal/AddJournal";
import ViewJournal from "./components/Journal/ViewJournal";
import Home from "./components/Home";


const App = () => {
  return (
    <Router>
      <Header />
      <Route path="/" exact component={Home} />
      <Route path="/login" component={Login} />
      <Route path="/register" component={Register} />
      <Route path="/seeds/add" component={AddSeed} />
      <Route path="/seeds/view-seeds" component={ViewSeed} />
      <Route path="/plants/add" component={AddPlant} />
      <Route path="/plants/view-plants" component={ViewPlant} />
      <Route path="/soil/add" component={AddSoil} />
      <Route path="/soil/view-soils" component={ViewSoil} />
      <Route path="/gardens/add" component={AddGarden} />
      <Route path="/gardens/view-gardens" component={ViewGarden} />
      <Route path="/journal/add" component={AddJournal} />
      <Route path="/journal/view-jouirnal" component={ViewJournal} />
    </Router>
  );
};

export default App;






