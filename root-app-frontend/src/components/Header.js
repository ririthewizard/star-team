import React from 'react';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <header>
      <div id="mag"><b>ROOT: </b> The garden builder application </div>
      <div className="nav">
        <Link to="/login" className="navlink">Log In</Link>
        <span style={{ marginLeft: '10px' }}></span>
        <Link to="/register" className="navlink">Register</Link>
        <span style={{ marginLeft: '10px' }}></span>

        {/* <Link to="/"className="navlink">Home</Link>
        <span style={{ marginLeft: '10px' }}></span> */}

      <Link to="/seeds/add" className="navlink">add Seeds</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/seeds/view-seeds" className="navlink">View Seeds</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/plants/add" className="navlink">Add Plants</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/plants/view-plants" className="navlink">View Plants</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/soil/add" className="navlink">Soil Add</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/soil/view-soils" className="navlink">Soil View</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/gardens/add" className="navlink">Add Garden </Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/gardens/view-gardens" className="navlink">View Garden</Link>
      <span style={{ marginLeft: '10px' }}></span>

      {/* <Link to="/journal/add" className="navlink">Add Journal</Link>
      <span style={{ marginLeft: '10px' }}></span>
      <Link to="/journal/view-jouirnal" className="navlink">View Journal</Link>
      <span style={{ marginLeft: '10px' }}></span> */}

        {/* Navigation links based on user authentication */}
      </div>
    </header>
  );
};

export default Header;
