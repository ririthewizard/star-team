import "./App.css";
// import RootAppBar from "./components/AppBar";
import AddSeed from "./components/Seeds/AddSeed";
import ViewSeed from "./components/Seeds/ViewSeed";
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
        </ul>
      </nav>
      <Routes>
        {/* path determinds the URL, element determins which Hook is used. */}
        <Route path="/seeds/add" element={<AddSeed />} />

        <Route path="/seeds/view-seeds" element={<ViewSeed />} />
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
