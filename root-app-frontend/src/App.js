import "./App.css";
import RootAppBar from "./components/AppBar";
import AddSeed from "./components/Seed/AddSeed";
import ViewSeed from "./components/Seed/ViewSeed";

/*Team to develop JS */
function App() {
  return (
    <div>
      <header>
        <RootAppBar />
      </header>
      <body>
        <p>React Classes incorporated into App.js below:</p>
        <p>AddSeed.js and ViewSeed.js</p>
        <p>AppBar.js currently has no function other than appearing.</p>
        <p>
          Enter Seed data, press "Submit" and hit refresh, and the new seed data
          should appear below:
        </p>
        <AddSeed />
        <br />
        <ViewSeed />
      </body>
    </div>
  );
}

export default App;
