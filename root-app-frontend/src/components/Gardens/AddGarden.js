import React, { useState } from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import { Container, Paper, Button } from "@mui/material";

export default function AddGarden() {
  // FOR POST
  // THESE MUST EXACTLY MATCH THE FIELDS CREATED IN THE BACKEND
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");

  // FOR GET
  // THESE ARE USED TO PULL DATA FROM SQL. SEE useEffect FUNCTION BELOW
  const [seeds, setSeeds] = useState([]);
  const [plants, setPlants] = useState([]);
  const [soil, setSoil] = useState([]);

  const handleGardenSubmission = (e) => {
    e.preventDefault();
    let garden = {
      name,
      description,
      seeds,
      plants,
      soil,
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
        setSeeds(result);
      })
      .catch((error) => {
        console.error("Error fetching Seed data:", error);
      });

    // Fetch Plant data
    fetch("http://localhost:8080/plants/view-plants")
      .then((res) => res.json())
      .then((result) => {
        setPlants(result);
      })
      .catch((error) => {
        console.error("Error fetching Plant data:", error);
      });

    // Fetch Soil data
    fetch("http://localhost:8080/soil/view-soils")
      .then((res) => res.json())
      .then((result) => {
        setSoil(result);
      })
      .catch((error) => {
        console.error("Error fetching Soil data:", error);
      });
  }, []);

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
          <h1 style={{ padding: 10 }}>ADD GARDENS</h1>
          <div>
            {/* NAME */}
            <TextField
              required
              id="outlined-required"
              label="Plant Name"
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
            {/* DESCRIPTION */}
            <TextField
              required
              id="outlined-required"
              label="Plant Description"
              helperText="Max of 255 characters"
              value={description}
              onChange={(e) => setDescription(e.target.value)}
            />
            {/* GROWING ZONE */}
            <TextField
              required
              id="outlined-required"
              label="Growing Zone"
              value={growingZone}
              onChange={(e) => setGrowingZone(e.target.value)}
            />
            {/* ANNUAL OR PERENNIAL */}
            <TextField
              required
              id="outlined-required"
              label="Annual or Perennial"
              value={annualOrPerennial}
              onChange={(e) => setAnnualOrPerennial(e.target.value)}
            />
          </div>
          <Button variant="contained" onClick={handlePlantSubmission}>
            SUBMIT
          </Button>
        </Paper>
      </Container>
    </Box>
  );
}
