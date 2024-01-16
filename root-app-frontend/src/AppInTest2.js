import React from 'react';
import { Link, Routes, Route } from 'react-router-dom';


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
import Home from "./Home";

const App = () => {
  const loggedIn = false; // Set this based on authentication logic

  return (
    <>
      <html lang="en">
        <head>
          <meta charSet="UTF-8" />
          <title>ROOT</title>
          <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js"></script>
          <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
          />
          <link rel="stylesheet" href="/css/styles.css" />
          <link
            rel="preconnect"
            href="https://fonts.googleapis.com"
          />
          <link
            rel="preconnect"
            href="https://fonts.gstatic.com"
            crossOrigin="true"
          />
          <link
            href="https://fonts.googleapis.com/css2?family=Kodchasan:wght@200;400;700&family=Assistant:wght@400;700&display=swap"
            rel="stylesheet"
          />
        </head>

        <body>
          <header>
            <div id="mag">
              <b>ROOT: </b> The garden builder application
            </div>
            <div className="nav">
              {!loggedIn ? (
                <>
                  <Link className="navlink" to="/login">
                    Log In
                  </Link>
                  <span style={{ marginLeft: '10px' }}></span>
                  <Link className="navlink" to="/register">
                    Register
                  </Link>
                </>
              ) : (
                <>
                  <Link className="navlink" to="/journal/add">
                    Add Journal
                  </Link>
                  <Link className="navlink" to="/journal/view-journal">
                    View Journal
                  </Link>
                  {/* Add other links for logged-in users */}
                  <Link className="navlink" to="/logout">
                    Log Out
                  </Link>
                </>
              )}
            </div>
          </header>

          {/* Routes for your components */}
          <Routes>
            <Route path="/home" element={<Home />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/seeds/add" element={<AddSeed />} />
            <Route path="/seeds/view-seeds" element={<ViewSeed />} />
            <Route path="/journal/add" element={<AddJournal />} />
            <Route path="/journal/view-journal" element={<ViewJournal />} />
            <Route path="/plants/add" element={<AddPlant />} />
            <Route path="/plants/view-plants" element={<ViewPlant />} />
            <Route path="/soil/add" element={<AddSoil />} />
            <Route path="/soil/view-soils" element={<ViewSoil />} />
            <Route path="/gardens/add" element={<AddGarden />} />
            <Route path="/gardens/view-gardens" element={<ViewGarden />} />
          </Routes>
        </body>
      </html>
    </>
  );
};

export default App;
