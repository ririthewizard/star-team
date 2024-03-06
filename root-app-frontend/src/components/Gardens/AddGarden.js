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

  // ERRORS
  const [errors, setErrors] = useState({});

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
    const inputErrors = validateGarden(garden);
    if (Object.keys(inputErrors).length === 0) {
      fetch("http://localhost:8080/gardens/add", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(garden),
      })
        // CONSOLE LOG TO CONFIRM IN CONSOLE THAT GARDEN IS ADDED
        .then(() => {
          console.log("New garden added");
        })
        // ERROR CATCH
        .catch((error) => {
          console.error("Error adding Garden:", error);
        });
    } else {
      setErrors(inputErrors);
    }
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

  const validateGarden = (data) => {
    let errors = {};

    if (!data.name.trim()) {
      errors.name = "Garden name is required!";
    }

    if (!data.description.trim()) {
      errors.description = "Garden description is required!";
    }

    if (data.gardenSeeds.length === 0) {
      errors.gardenSeeds = "Seeds required!";
    }

    if (data.gardenPlants.length === 0) {
      errors.gardenPlants = "Plants required!";
    }

    if (data.gardenSoil.length === 0) {
      errors.gardenSoil = "Soil required!";
    }

    return errors;
  };

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
            <p>{errors.name && <span>{errors.name}</span>}</p>
            {/* DESCRIPTION */}
            <TextField
              required
              id="outlined-required"
              label="Garden Description"
              helperText="Max of 255 characters"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
            <p>{errors.description && <span>{errors.description}</span>}</p>
          </div>
          <form>
            <h2>SEEDS</h2>
            <FormControl fullWidth>
              <InputLabel>Select Seeds:</InputLabel>
              <Select
                multiple
                value={gardenSeeds}
                onChange={(e) => setGardenSeeds(e.target.value)}
                required
              >
                {seedList.map((aSeed) => (
                  <MenuItem key={aSeed.id} value={aSeed.id}>
                    {aSeed.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
            <p>{errors.gardenSeeds && <span>{errors.gardenSeeds}</span>}</p>

            <h2>PLANTS</h2>
            <FormControl fullWidth>
              <InputLabel>Select Plants:</InputLabel>
              <Select
                multiple
                value={gardenPlants}
                onChange={(e) => setGardenPlants(e.target.value)}
                required
              >
                {plantList.map((aPlant) => (
                  <MenuItem key={aPlant.id} value={aPlant.id}>
                    {aPlant.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
            <p>{errors.gardenPlants && <span>{errors.gardenPlants}</span>}</p>

            <h2>SOILS</h2>
            <FormControl fullWidth>
              <InputLabel>Select a Soil</InputLabel>
              <Select
                value={gardenSoil}
                onChange={(e) => setGardenSoil(e.target.value)}
                required
              >
                {soilList.map((aSoil) => (
                  <MenuItem key={aSoil.id} value={aSoil.id}>
                    {aSoil.name}
                  </MenuItem>
                ))}
              </Select>
            </FormControl>
            <p>{errors.gardenSoil && <span>{errors.gardenSoil}</span>}</p>

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
