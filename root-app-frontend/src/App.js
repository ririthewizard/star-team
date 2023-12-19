import "./App.css";
// import RootAppBar from "./components/AppBar";
import AddSeed from "./components/Seeds/AddSeed";
import ViewSeed from "./components/Seeds/ViewSeed";
import { Routes, Route } from "react-router-dom";

/*Team to develop JS */
function App() {
  return (
    <Routes>
      <Route path="/seeds/add" element={<AddSeed />} />

      <Route path="/seeds/view-seeds" element={<ViewSeed />} />
    </Routes>
    // <div>
    //   <header>
    //     <RootAppBar />
    //   </header>
    //   <body>
    //     <p>Placeholder Text</p>
    //     <SeedForm />
    //   </body>
    // </div>
  );
}

export default App;
