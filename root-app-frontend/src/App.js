import "./App.css";
// import RootAppBar from "./components/AppBar";
import AddSeed from "./components/Seeds/AddSeed";
import ViewSeed from "./components/Seeds/ViewSeed";
import AddPlant from "./components/Plants/AddPlant";
import ViewPlant from "./components/Plants/ViewPlant";
import AddSoil from "./components/Soils/AddSoil";
import ViewSoil from "./components/Soils/ViewSoil";
import AddGarden from "./components/Gardens/AddGarden";
import ViewGarden from "./components/Gardens/ViewGarden";
import DeleteGarden from "./components/Gardens/DeleteGarden";
import { Link, Routes, Route } from "react-router-dom";

function App() {
  return (
    // Reminder: <> is fragment within which the <ROUTES> Hooks are wrapped.
    <>
      <nav>
        <ul>
          <li>
            {/*Link is like an anchor tag <a>, and to= is like href*/}
            <Link to="/seeds/add">Add Seeds</Link>
          </li>
          <li>
            <Link to="/seeds/view-seeds">View Seeds</Link>
          </li>
          <li>
            <Link to="/plants/add">Add Plants</Link>
          </li>
          <li>
            <Link to="/plants/view-plants">View Plants</Link>
          </li>
          <li>
            <Link to="/soil/add">Add Soil</Link>
          </li>
          <li>
            <Link to="/soil/view-soils">View Soils</Link>
          </li>
          <li>
            <Link to="/gardens/add">Add Garden</Link>
          </li>
          <li>
            <Link to="/gardens/view-gardens">View Gardens</Link>
          </li>
          <li>
            <Link to="/gardens/delete">Delete a Garden</Link>
          </li>
        </ul>
      </nav>
      <Routes>
        {/* path determinds the URL, element determins which Hook is used. */}
        <Route path="/seeds/add" element={<AddSeed />} />

        <Route path="/seeds/view-seeds" element={<ViewSeed />} />

        <Route path="/plants/add" element={<AddPlant />} />

        <Route path="/plants/view-plants" element={<ViewPlant />} />

        <Route path="/soil/add" element={<AddSoil />} />

        <Route path="/soil/view-soils" element={<ViewSoil />} />

        <Route path="/gardens/add" element={<AddGarden />} />

        <Route path="/gardens/view-gardens" element={<ViewGarden />} />

        <Route path="/gardens/delete" element={<DeleteGarden />} />
      </Routes>
    </>
    // <div>
    //   <header>
    //     <RootAppBar />
    //   </header>
    //   <body>
    //   </body>
    // </div>
  );
}

export default App;
