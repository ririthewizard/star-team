import React, { useState, useEffect } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import {
  Container,
  Paper,
  Button,
  FormControl,
  InputLabel,
  MenuItem,
  Select,
} from "@mui/material";

export default function AddGarden() {
  // FOR POST
  // THESE MUST EXACTLY MATCH THE FIELDS CREATED IN THE BACKEND
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  // SEED, PLANT AND SOIL OBJECTS
  const [gardenSeeds, setGardenSeeds] = useState([]);
  const [gardenPlants, setGardenPlants] = useState([]);
  const [gardenSoil, setGardenSoil] = useState([]);

  // FOR GET
  // THESE ARE USED TO PULL DATA FROM SQL. SEE useEffect FUNCTION BELOW
  const [seedList, setSeedList] = useState([]);
  const [plantList, setPlantList] = useState([]);
  const [soilList, setSoilList] = useState([]);

  // FOR SELECTING MULTIPLE SEEDS AND PLANTS
  // const [numSeeds, setNumSeeds] = useState(1);
  // const [numPlants, setNumPlants] = useState(1);

  // HANDLERS FOR SELECTING SEED, SOIL AND PLANT OBJECTS

  const handleSeedChange = (event) => {
    setGardenSeeds(event.target.value);
  };

  const handlePlantChange = (event) => {
    setGardenPlants(event.target.value);
  };

  const handleSoilChange = (event) => {
    setGardenSoil(event.target.value);
  };

  // HANDLERS FOR CHANGING NUMBER OF SEEDS AND PLANTS

  // const handleNumSeedsChange = (event) => {
  //   setNumSeeds(event.target.value);
  // };

  // const handleNumPlantsChange = (event) => {
  //   setNumPlants(event.target.value);
  // };

  // HANDLER TO SUBMIT A GARDEN

  const handleGardenSubmission = (e) => {
    e.preventDefault();
    let garden = {
      name,
      description,
      gardenSeeds,
      gardenPlants,
      gardenSoil,
    };

    // CONSOLE LOG TO CONFIRM THAT DATA IS SAVED TO JSON FORMAT
    console.log(garden);
    fetch("http://localhost:8080/gardens/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(garden),
    }).then(() => {
      console.log("New garden added");
    });
  };

  // THIS LONG useEffect FUNCTION PULLS DATA FROM SQL
  useEffect(() => {
    // Fetch Seed data
    fetch("http://localhost:8080/seeds/view-seeds")
      .then((res) => res.json())
      .then((result) => {
        setSeedList(result);
      })
      .catch((error) => {
        console.error("Error fetching Seed data:", error);
      });

    // Fetch Plant data
    fetch("http://localhost:8080/plants/view-plants")
      .then((res) => res.json())
      .then((result) => {
        setPlantList(result);
      })
      .catch((error) => {
        console.error("Error fetching Plant data:", error);
      });

    // Fetch Soil data
    fetch("http://localhost:8080/soil/view-soils")
      .then((res) => res.json())
      .then((result) => {
        setSoilList(result);
      })
      .catch((error) => {
        console.error("Error fetching Soil data:", error);
      });
  }, []);
  // END useEffect Function

  return (
    <Box
      component="form"
      sx={{
        "& .MuiTextField-root": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <Container>
        <Paper>
          {/* UPDATE MARGINS*/}
          <h1 style={{ padding: 10 }}>CREATE GARDEN</h1>
          <div>
            {/* NAME */}
            <TextField
              required
              id="outlined-required"
              label="Garden Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            {/* DESCRIPTION */}
            <TextField
              required
              id="outlined-required"
              label="Garden Description"
              helperText="Max of 255 characters"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
          </div>
          <form>
            <h2>SEEDS</h2>
            <FormControl fullWidth>
              <InputLabel>Select a Seed</InputLabel>
              <Select multiple value={gardenSeeds} onChange={handleSeedChange}>
                {seedList.map((aSeed) => (
                  <MenuItem key={aSeed.id} value={aSeed.id}>
                    {aSeed.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>

            {/* <TextField
              label="Number of Seeds"
              type="number"
              value={numSeeds}
              onChange={handleNumSeedsChange}
            /> */}

            <h2>PLANTS</h2>
            <FormControl fullWidth>
              <InputLabel>Select a Plant</InputLabel>
              <Select
                multiple
                value={gardenPlants}
                onChange={handlePlantChange}
              >
                {plantList.map((aPlant) => (
                  <MenuItem key={aPlant.id} value={aPlant.id}>
                    {aPlant.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>

            {/* <TextField
              label="Number of Plants"
              type="number"
              value={numPlants}
              onChange={handleNumPlantsChange}
            /> */}

            <h2>SOILS</h2>
            <FormControl fullWidth>
              <InputLabel>Select a Soil</InputLabel>
              <Select value={gardenSoil} onChange={handleSoilChange}>
                {soilList.map((aSoil) => (
                  <MenuItem key={aSoil.id} value={aSoil.id}>
                    {aSoil.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>

            <Button
              variant="contained"
              color="primary"
              onClick={handleGardenSubmission}
            >
              Build Your Garden
            </Button>
          </form>
        </Paper>
      </Container>
    </Box>
  );
}
